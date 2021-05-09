#!/bin/Rscript

# See https://bookdown.org/kochiuyu/technical-analysis-with-r-second-edition/charting.html
# https://www.rdocumentation.org/packages/quantmod/versions/0.4.18

library(quantmod)
library(TTR)
options("getSymbols.warning4.0"=FALSE)
options(warn=-1)

stock=na.approx(getSymbols("BTC-EUR", auto.assign=FALSE, src="yahoo"))
tail(stock, n=5)

chartSeries(stock, type="line", theme=chartTheme('black'))
addBBands(n=20, sd=2)
addRSI(n=14, maType="EMA")
addMACD(fast=12, slow=26, signal=9, type="EMA", histogram=TRUE)

chartSeries(stock, type="candlesticks", subset='2021', theme=chartTheme('black'))
addBBands(n=20, sd=2)
addRSI(n=14, maType="EMA")
addMACD(fast=12, slow=26, signal=9, type="EMA", histogram=TRUE)

dev.copy(jpeg, filename="/opt/R/plot.jpg", width=28, height=10, units="in", res=200);
dev.off()