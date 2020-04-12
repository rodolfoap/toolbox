#!/bin/python3

import lorem
import sys
import textstat
import time

test_data=lorem.paragraph()

for n in range(3):
	print(n, test_data)
	time.sleep(0.5)
print('DATA=', test_data, sep='')
print('FRE=', textstat.flesch_reading_ease(test_data), sep='')
print('SMOG_INDEX=', textstat.smog_index(test_data), sep='')
print('KINCAID=', textstat.flesch_kincaid_grade(test_data), sep='')
print('LIAU=', textstat.coleman_liau_index(test_data), sep='')
print('ARBLTY=', textstat.automated_readability_index(test_data), sep='')
print('DALECHALL=', textstat.dale_chall_readability_score(test_data), sep='')
print('DIFFICULT=', textstat.difficult_words(test_data), sep='')
print('LINSEAR=', textstat.linsear_write_formula(test_data), sep='')
print('GUNNING=', textstat.gunning_fog(test_data), sep='')
print('TXTSTD=', textstat.text_standard(test_data), sep='')
print('LENGTH='+str(len(test_data)), sep='')
sys.exit(0)
