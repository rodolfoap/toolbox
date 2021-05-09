#!/bin/Rscript

library(reticulate)
use_condaenv('r-reticulate')
library(keras)
library(tensorflow)
#install_tensorflow(method='conda', envname='r-reticulate')
#install_keras(method='conda', envname='r-reticulate')

# Check
library(keras)
to_categorical(0:3)

rm(list=ls())
data(iris)
head(iris)
plot(iris$Petal.Length, iris$Petal.Width, col=iris$Species)

onehot.species = to_categorical(as.numeric(iris$Species) - 1)
iris = as.matrix(iris[, 1:4])
iris = cbind(iris, onehot.species) 

set.seed(17)
ind <- sample(2, nrow(iris), replace = TRUE, prob = c(0.7, 0.3))
iris.training <- iris[ind == 1, 1:4]
iris.test <- iris[ind == 2, 1:4]
iris.trainingtarget <- iris[ind == 1, -seq(4)]
iris.testtarget <- iris[ind == 2, -(1:4)]

model <- keras_model_sequential()
model %>%
  layer_dense(units = ncol(iris.trainingtarget), activation = 'softmax',
              input_shape = ncol(iris.training))
summary(model)
model$inputs
model$outputs
library(igraph)
g = graph_from_literal(Sepal.Length:Sepal.Width:Petal.Length:Petal.Width---Species,simplify = TRUE)
layout <- layout_in_circle(g, order = order(degree(g)))
plot(g,layout = layout,vertex.color = c(2,2,2,2,3))
