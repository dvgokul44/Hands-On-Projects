FROM ubuntu:latest

RUN apt-get update -q  \
 && apt-get install -yqq curl \
 wget \
 aptitude \
 htop \
 vim \
 git \
 traceroute \
 dnsutils \
 curl \
 ssh \
 tree \
 tcpdump \
 nano \
 psmisc \
 gcc \
 make \
 build-essential \
 libfreetype6 \
 libfontconfig \
 libkrb5-dev \
 ruby \
 sudo \
 apt-utils \
 python \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

WORKDIR /home

RUN wget https://repo.continuum.io/archive/Anaconda3-4.2.0-Linux-x86_64.sh

RUN chmod 755 /home/Anaconda3-4.2.0-Linux-x86_64.sh

RUN sudo /home/Anaconda3-4.2.0-Linux-x86_64.sh -b -p /home/anaconda

ENV PATH="/home/anaconda/bin:${PATH}"

RUN wget https://nodejs.org/dist/latest-v10.x/node-v10.19.0-linux-x64.tar.gz

RUN chmod 755 /home/node-v10.19.0-linux-x64.tar.gz

RUN mkdir node

RUN cd node && tar -xvf /home/node-v10.19.0-linux-x64.tar.gz 

ENV PATH="/home/node/node-v10.19.0-linux-x64/bin:${PATH}"

RUN pip install tensorflow==1.2.1 

RUN pip install spacy==1.9.0

RUN pip install textacy==0.4.0 

RUN pip install regex

RUN pip install pymongo==3.4.0

RUN pip install nltk==3.2.2

RUN conda install libgcc

RUN python -m spacy download en_core_web_sm

RUN python -m spacy link en_core_web_sm en_default

RUN mkdir python_source

COPY ./Python_Source /home/python_source 

RUN cd python_source && tar -xvf /home/python_source/nltk_data.tar.gz

RUN mv /home/python_source/nltk_data /home/anaconda/

ENV NLTK_DATA="/home/anaconda/nltk_data:${NLTK_DATA}"

RUN cd python_source && cp -rf tf-tensorboard.html /home/anaconda/lib/python3.5/site-packages/tensorflow/tensorboard/dist/

RUN rm -f Anaconda3-4.2.0-Linux-x86_64.sh

RUN rm -f node-v10.19.0-linux-x64.tar.gz

RUN rm -fr python_source
