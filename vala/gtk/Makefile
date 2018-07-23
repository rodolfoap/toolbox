all: ValaBrowser

ValaBrowser: ValaBrowser.vala
	valac --pkg gtk+-2.0 --pkg webkit-1.0 --thread -o valabrowser ValaBrowser.vala

clean:
	-find . -type f -executable -exec rm {} \;

