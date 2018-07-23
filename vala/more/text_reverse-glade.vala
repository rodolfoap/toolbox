/**
 * Compile: 			valac --pkg gtk+-2.0 --pkg gmodule-2.0 helloworld.vala
 * Strings sample:		http://live.gnome.org/Vala/StringSample
 * GLib String Object doc:	http://references.valadoc.org/glib-2.0/string.html
 * Gtk Widget Library doc:	http://references.valadoc.org/gtk+-2.0/Widget__Gallery.htm
 * Gtk.main_quit doc:		http://references.valadoc.org/gtk+-2.0/Gtk.main_quit.html
 * Gtk.Builder Object doc:	http://references.valadoc.org/gtk+-2.0/Gtk.Builder.html
 * Gtk.Builder.get_object doc:	http://references.valadoc.org/gtk+-2.0/Gtk.Builder.get_object.html
 * More code samples:		http://code.valaide.org/ 
 */
using Gtk;

Window window;
Entry entry1;
Label label1;
public void on_button1_clicked (Button source) {
	string temp=entry1.text;
	int c;
	/* Own reverse code: */
	for(c=0; c<temp.len(); c++) label1.label=temp.substring(c, 1)+label1.label;
	/* Or glib string.reverse method: */
	label1.label=temp.reverse();
}
public void on_button2_clicked (Button source) {
	Gtk.main_quit ();
}
int main (string[] args) {	 
	Gtk.init (ref args);

	try {
		var builder = new Builder ();
		builder.add_from_file ("text_reverse-glade.ui");
		builder.connect_signals (null);
		window = builder.get_object ("window1") as Window;
		entry1 = builder.get_object ("entry1") as Entry;
		label1 = builder.get_object ("label1") as Label;
		window.destroy.connect (Gtk.main_quit);
		window.show_all ();
		Gtk.main ();
	} catch (Error e) {
		stderr.printf ("Could not load UI: %s\n", e.message);
		return 1;
	} 

	return 0;
}
