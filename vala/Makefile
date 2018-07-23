all: basicsample basicsamplei sync textvwr filedialog createdialog xmlsample treelist treeview treeview2 clipboard multipad curses

basicsample: basicsample.vala
	valac --pkg gtk+-3.0 basicsample.vala

basicsamplei: basicsamplei.vala
	valac --pkg gtk+-3.0 basicsamplei.vala

sync: sync.vala
	valac --pkg gtk+-3.0 sync.vala

textvwr: textvwr.vala
	valac --pkg gtk+-3.0 textvwr.vala

filedialog: filedialog.vala
	valac --pkg gtk+-3.0 filedialog.vala

createdialog: createdialog.vala
	valac --pkg gtk+-3.0 createdialog.vala

xmlsample: xmlsample.vala
	valac --pkg gtk+-3.0 --pkg gmodule-2.0 xmlsample.vala

treelist: treelist.vala
	valac --pkg gtk+-3.0 treelist.vala

treeview: treeview.vala
	valac --pkg gtk+-3.0 treeview.vala

treeview2: treeview2.vala
	valac --pkg gtk+-3.0 treeview2.vala

clipboard: clipboard.vala
	valac --pkg gtk+-3.0 clipboard.vala

multipad: multipad.vala
	valac --pkg gtk+-3.0 multipad.vala

curses: curses.vala
	valac --pkg curses -X -lncurses curses.vala

clean:
	-find . -type f -executable -exec rm {} \;

