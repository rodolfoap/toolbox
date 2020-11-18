#!/usr/bin/python3
from cassandra.cluster 	import Cluster
from cassandra.query 	import dict_factory

clstr=Cluster(['10.0.0.10'])
session=clstr.connect('test')
session.row_factory=dict_factory
rows=session.execute("SELECT * FROM entity LIMIT 1;")
for row in rows:
	print(row['uuid'])
	print(row)
