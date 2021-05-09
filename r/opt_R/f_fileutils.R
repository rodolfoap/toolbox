#!/bin/Rscript

library(quantmod)
library(TTR)
library(dplyr)
library(xts)
options("getSymbols.warning4.0"=FALSE)
options(warn=-1)
options(max.print=50)

downloadStock=function(symbol, fname){
  stock=na.approx(getSymbols(symbol, auto.assign=FALSE, src="yahoo"))
  stock.df=as.data.frame(stock)
  stock.df=cbind(data.frame(rownames(stock.df)), stock.df)
  colnames(stock.df)[1] <-sprintf("%s.Date", symbol)
  write.csv(stock.df, fname, row.names=FALSE)
  # return(stock)
}

loadStock=function(fname){
  stock.df=read.csv(file=fname)
  stock=mutate(stock.df, BTC.EUR.Date=as.Date(BTC.EUR.Date))
  rownames(stock)=stock$BTC.EUR.Date
  return(xts(stock[,-1], order.by=stock[,1]))
}

firstTimeInstall=function(){
  library(gert)
  library(credentials)
  library(openssl)
  library(reticulate)
  
  use_virtualenv("keras")
  library(keras)
  
  install.packages("gert")
  install.packages("devtools")
  install.packages("keras")
}
