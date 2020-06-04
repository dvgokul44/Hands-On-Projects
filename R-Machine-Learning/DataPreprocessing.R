#Import dataset
dataset = read.csv('Data.csv')

#Handle missing data
dataset$Age = ifelse(is.na(dataset$Age),
                     ave(dataset$Age, FUN = function(x) mean(x, na.rm = TRUE)),
                     dataset$Age)

dataset$Salary = ifelse(is.na(dataset$Salary),
                     ave(dataset$Salary, FUN = function(x) mean(x, na.rm = TRUE)),
                     dataset$Salary)

#Encode categorical values
dataset$Country = factor(dataset$Country,
                         levels = c('France', 'Germany', 'Spain'),
                         labels = c(1,2,3))

dataset$Purchased = factor(dataset$Purchased,
                         levels = c('No', 'Yes'),
                         labels = c(0,1))

#Train and test data split
install.packages('caTools')
library(caTools)
set.seed(13)
split = sample.split(dataset$Purchased,
                     SplitRatio = 0.8)

train_set = subset(dataset, split == TRUE)
test_set = subset(dataset, split == FALSE)

#Feature scaling
train_set[ , 2:3] = scale(train_set[ , 2:3])
test_set[ , 2:3] = scale(test_set[ , 2:3])
