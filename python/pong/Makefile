all: 	run

run:	edit
	python main.py

edit:
	leafpad *.py

clean:
	-find . -maxdepth 1 -mindepth 1 -name \*pyc -type f -executable -print -exec rm {} \;
