using Gtk;

int main (string[] args) {
	Gtk.init (ref args);

	var window = new Window ();
	window.title = "First GTK+ Program";
	window.border_width = 10;
	window.window_position = WindowPosition.CENTER;
	window.set_default_size (350, 70);
	window.destroy.connect (Gtk.main_quit);

	var button = new Button.with_label ("Click me!");
	button.clicked.connect (() => {
		button.label = "Thank you";
	});

	try {
		window.icon = new Gdk.Pixbuf.from_file ("icon.png");
		//window.icon = IconTheme.get_default ().load_icon ("my-app", 48, 0);
	} catch (Error e) {
		stderr.printf ("Could not load application icon: %s\n", e.message);
	}

	window.add (button);
	window.show_all ();

	Gtk.main ();
	return 0;
}

