using Gtk;

public class SyncSample : Window {

    private SpinButton spin_box;
    private HScale slider;

    public SyncSample () {
        this.title = "Enter your age";
        this.position = WindowPosition.CENTER;
        this.destroy.connect (Gtk.main_quit);
        set_default_size (300, 20);

        spin_box = new SpinButton.with_range (0, 130, 1);
        slider = new HScale.with_range (0, 130, 1);
        spin_box.value_changed.connect ((s) => {
            slider.set_value (s.get_value ());
        });
        slider.value_changed.connect ((s) => {
            spin_box.set_value (s.get_value ());
        });
        spin_box.value = 35;

        var hbox = new HBox (true, 5);
        hbox.add (spin_box);
        hbox.add (slider);
        add (hbox);
    }

    public static int main (string[] args) {
        Gtk.init (ref args);

        var window = new SyncSample ();
        window.show_all ();

        Gtk.main ();
        return 0;
    }
}

