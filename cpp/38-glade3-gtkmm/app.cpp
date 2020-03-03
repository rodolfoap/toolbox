#include <gtkmm.h>

class FrmMain: public Gtk::Window {
	Gtk::Box *cont;
        Gtk::Label *display_label;
        Gtk::Button *display_button;
	Glib::RefPtr<Gtk::Builder> builder;
public:
	FrmMain(): builder{Gtk::Builder::create_from_file("simple.glade")} {
		builder->get_widget<Gtk::Box>("cont", cont);
	        builder->get_widget("display_label", display_label);
	        builder->get_widget("display_button", display_button);
		display_button->signal_clicked().connect( [this]() { display_label->set_text("Hello World"); });
		add(*cont);
		//set_title("Simple Gtk::Builder demo");
		//set_default_size(400, 400);
		show_all();
	}
};

int main(int argc, char *argv[]) {
	auto app=Gtk::Application::create( argc, argv, "org.gtkmm.example.HelloApp");
	FrmMain hw;
	return app->run(hw);
}

/*
class FrmMain : public Gtk::Window{
protected:
        Glib::RefPtr<Gtk::Builder> builder;
        Gtk::Button *btnOk;
        Gtk::Button *btnCancel;
        Gtk::Label *lblNotice;
public:
	FrmMain(BaseObjectType* bot, const Glib::RefPtr<Gtk::Builder>& refg): Gtk::Window(bot), builder(refg){
	        builder->get_widget("btnOk", btnOk);
	        builder->get_widget("btnCancel", btnCancel);
	        builder->get_widget("lblNotice",lblNotice);
	        btnOk->signal_clicked().connect(sigc::mem_fun(*this, &FrmMain::on_ok_button_clicked));
	        btnCancel->signal_clicked().connect(sigc::mem_fun(*this, &FrmMain::on_cancel_button_clicked));
	}
protected:
        void on_ok_button_clicked(){ lblNotice->set_text("OK clicked"); }
        void on_cancel_button_clicked(){ lblNotice->set_text("Cancel clicked"); }
};

int main(int argc, char **argv) {
        cout << "Started" << endl;
        Main kit(argc,argv);
        Glib::RefPtr<Gtk::Builder> builder = Gtk::Builder::create_from_file("gui.glade");
        FrmMain *frm = 0;
        builder->get_widget_derived("frmMain", frm);
        kit.run(*frm);
        cout << "End" << endl;
        return 0;
}
*/
