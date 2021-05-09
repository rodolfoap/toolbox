#!/bin/Rscript
# See https://www.r-bloggers.com/2018/11/lstm-with-keras-tensorflow/

library(keras)
library(tensorflow)
tensorflow::tf_config()
install_keras()

# Check
to_categorical(0:3)

library(BatchGetSymbols)
tickers <- c('%5EIBEX')
first.date <- Sys.Date() - 360*15
last.date <- Sys.Date()
myts <- BatchGetSymbols(tickers = tickers,
                        first.date = first.date,
                        last.date = last.date,
                        cache.folder = file.path(tempdir(),
                                                 'BGS_Cache') ) # cache in tempdir()
head(myts)
print(myts$df.control)

y = myts$df.tickers$price.close
myts = data.frame(index = myts$df.tickers$ref.date, price = y, vol = myts$df.tickers$volume)
myts = myts[complete.cases(myts), ]
myts = myts[-seq(nrow(myts) - 3000), ]
myts$index = seq(nrow(myts))
library(plotly)
plot_ly(myts, x = ~index, y = ~price, type = "scatter", mode = "markers", color = ~vol)
acf(myts$price, lag.max = 3000)

msd.price = c(mean(myts$price), sd(myts$price))
msd.vol = c(mean(myts$vol), sd(myts$vol))
myts$price = (myts$price - msd.price[1])/msd.price[2]
myts$vol = (myts$vol - msd.vol[1])/msd.vol[2]
summary(myts)


datalags = 10
train = myts[seq(2000 + datalags), ]
test = myts[2000 + datalags + seq(1000 + datalags), ]
batch.size = 50

x.train = array(data = lag(cbind(train$price, train$vol), datalags)[-(1:datalags), ], dim = c(nrow(train) - datalags, datalags, 2))
y.train = array(data = train$price[-(1:datalags)], dim = c(nrow(train)-datalags, 1))
x.test = array(data = lag(cbind(test$vol, test$price), datalags)[-(1:datalags), ], dim = c(nrow(test) - datalags, datalags, 2))
y.test = array(data = test$price[-(1:datalags)], dim = c(nrow(test) - datalags, 1))


model <- keras_model_sequential()
model %>%
  layer_lstm(units = 100,
             input_shape = c(datalags, 2),
             batch_size = batch.size,
             return_sequences = TRUE,
             stateful = TRUE) %>%
  layer_dropout(rate = 0.5) %>%
  layer_lstm(units = 50,
             return_sequences = FALSE,
             stateful = TRUE) %>%
  layer_dropout(rate = 0.5) %>%
  layer_dense(units = 1)
model %>%
  compile(loss = 'mae', optimizer = 'adam')
model

for(i in 1:2000){
  model %>% fit(x = x.train,
                y = y.train,
                batch_size = batch.size,
                epochs = 1,
                verbose = 0,
                shuffle = FALSE)
  model %>% reset_states()
  print(i)
}

pred_out <- model %>% predict(x.test, batch_size = batch.size) %>% .[,1]
plot_ly(myts, x = ~index, y = ~price, type = "scatter", mode = "markers", color = ~vol) %>%
  add_trace(y = c(rep(NA, 2000), pred_out), x = myts$index, name = "LSTM prediction", mode = "lines")
## Warning: line.color doesn't (yet) support data arrays
## Warning: line.color doesn't (yet) support data arrays

plot(x = y.test, y = pred_out)
