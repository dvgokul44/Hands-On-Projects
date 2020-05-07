#Import libraries
import nltk
import numpy as np
import pandas as pd
import re
from nltk.tokenize import sent_tokenize
from nltk.corpus import stopwords
from sklearn.metrics.pairwise import cosine_similarity
import networkx as nx
#nltk.download('punkt')


#Read input
df = pd.read_csv('tennis_articles_v4.csv')
print("\nDataframe:")
print(df.head())
print("\nText:")
print(df['article_text'][0])

#Break text into sentences using sent_tokenize and flatten it into a list
sentences = []

for s in df['article_text']:
    sentences.append(sent_tokenize(s))

sentences = [y for x in sentences for y in x]
print("\nFlatten list of sentences:")
print(sentences)

#Extracting word vectors
word_embeddings = {}

f = open('resources/glove.6B.100d.txt', encoding='utf-8')
for line in f:
    values = line.split()
    word = values[0]
    coefs = np.asarray(values[1:], dtype='float32')
    word_embeddings[word] = coefs
f.close()
print("\nWord vector length:",len(word_embeddings))

#Remove speacial characters and digits
clean_sentences = pd.Series(sentences).str.replace("[^A-Za-z]", " ")
clean_sentences = [x.lower() for x in clean_sentences]
print("\nClean sentences:",clean_sentences[0])

#Remove stop words
stop_words = stopwords.words('english')

def remove_stopwords(sentence):
    new_sentence = " ".join([i for i in sentence if i not in stop_words])
    return new_sentence

clean_sentences = [remove_stopwords(sentence.split()) for sentence in clean_sentences]
print("\nAfter removing stop words:",clean_sentences[0])

#Form vector representation by taking normalized sum of sentence
sentence_vector = []

for sent in clean_sentences:
    if len(sent)!= 0:
        vector = sum([word_embeddings.get(word,np.zeros(100,)) for word in sent.split()])/(len(sent.split())+0.0001)
    else:
        vector = np.zeros(100,)
    sentence_vector.append(vector)
print("\nSentence vector:",sentence_vector[0])

#Form similarity matrix
similarity_matrix = np.zeros([len(sentences), len(sentences)])

for i in range(len(sentences)):
    for j in range(len(sentences)):
        if i != j:
            similarity_matrix[i][j] = cosine_similarity(sentence_vector[i].reshape(1,100),sentence_vector[j].reshape(1,100))[0,0]
print("\nSimilarity Matrix:",similarity_matrix)

#Apply page rank algorithm after converting similarity matrix to a graph 
nx_graph = nx.from_numpy_array(similarity_matrix)
scores = nx.pagerank(nx_graph)
print(scores)

#Extract top 10 sentences as the summary of input

ranked_senteces = sorted(((scores[i],s) for i,s in enumerate(sentences)), reverse = True)
print("\nSummary:")
for i in range(10):
    print(ranked_senteces[i][1])