#include <gtkmm.h>

class FrmMain: public Gtk::Window {
	Gtk::Box *cont;
        Gtk::Label *display_label;
        Gtk::Button *display_button;
	Glib::RefPtr<Gtk::Builder> builder;
public:
	FrmMain(): builder{Gtk::Builder::create_from_file("app.ui")} {
		builder->get_widget<Gtk::Box>("cont", cont);
	        builder->get_widget("display_label", display_label);
	        builder->get_widget("display_button", display_button);
	        display_button->signal_clicked().connect(sigc::mem_fun(*this, &FrmMain::on_ok_button_clicked));
		add(*cont);
		show_all();
	}
private:
        void on_ok_button_clicked(){ display_label->set_text("Hello World"); }
};

int main(int argc, char *argv[]) {
	auto app=Gtk::Application::create(argc, argv, "org.gtkmm.example.HelloApp");
	FrmMain hw;
	return app->run(hw);
}
