using Gtk;

public void on_button1_clicked (Button source) {
	source.label = "Thank you!";
}

public void on_button2_clicked (Button source) {
	source.label = "Thanks!";
}

int main (string[] args) {	 
	Gtk.init (ref args);

	try {
		var builder = new Builder ();
		builder.add_from_file ("xmlsample.ui");
		builder.connect_signals (null);
		var window = builder.get_object ("window") as Window;
		window.show_all ();
		Gtk.main ();
	} catch (Error e) {
		stderr.printf ("Could not load UI: %s\n", e.message);
		return 1;
	} 

	return 0;
}

