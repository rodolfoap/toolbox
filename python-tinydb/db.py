#!/usr/bin/env python3

from tinydb import TinyDB, Query

db=TinyDB('db.json')

light=db.table('Light')
light.insert({"date":"2019-06-00","time":"16:00","light":30})
light.insert({"date":"2019-06-01","time":"16:01","light":31})
light.insert({"date":"2019-06-02","time":"16:02","light":32})
light.insert({"date":"2019-06-03","time":"16:03","light":33})
light.insert({"date":"2019-06-04","time":"16:04","light":34})

# Query
for row in light.search(Query().light>31): print('Q: light>31', row)
print()

# Update table
light.update({'date': 'MODIFIED'}) # all fields
light.update({'date': 'MODIFIED'}, Query().light>32)
for row in light.all(): print('MODIFIED:', row)

# Loop all
mydict=light.all()
for row in mydict: print('LIGHT:', row['light'])

# Rows to dict
mydict=light.search(Query().light>30)
for row in mydict:
	drow=dict(row)
	print(drow, 'TIME:', drow['time'])

db.close()
