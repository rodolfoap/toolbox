#!/usr/bin/python3
import csv, sys, json

if(len(sys.argv))<2:
	print('Usage:', sys.argv[0], '[INPUT.csv CORRESPONDENCES_FILE.json]')
	exit(0)

with open(sys.argv[1]) as sourcefile, open(sys.argv[2]) as json_file:
	pairs=json.load(json_file)
	writer=csv.DictWriter(sys.stdout, delimiter=',', extrasaction='ignore', lineterminator='\n', fieldnames=list(pairs.values()))
	writer.writeheader()
	reader=csv.DictReader(sourcefile, skipinitialspace=True)
	for row in reader:
		line={};
		for n in range(0, len(pairs)): line[list(pairs.values())[n]]=dict(row)[list(pairs.keys())[n]]
		writer.writerow(line)
