#!/bin/Rscript

# See https://bookdown.org/kochiuyu/technical-analysis-with-r-second-edition/charting.html
# https://www.rdocumentation.org/packages/quantmod/versions/0.4.18

source('f_fileutils.R')

downloadStock("BTC-EUR", "stock.csv")
stock=loadStock("stock.csv")
View(stock)

chartSeries(stock, type="line", theme=chartTheme('black'))
addBBands(n=20, sd=2)
addRSI(n=14, maType="EMA")
addMACD(fast=12, slow=26, signal=9, type="EMA", histogram=TRUE)

chartSeries(stock, type="candlesticks", subset='2021', theme=chartTheme('black'))
addBBands(n=20, sd=2)
addRSI(n=14, maType="EMA")
addMACD(fast=12, slow=26, signal=9, type="EMA", histogram=TRUE)

dev.copy(jpeg, filename="plot.jpg", width=28, height=10, units="in", res=200);
dev.off()
