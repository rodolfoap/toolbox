#include <gtk/gtk.h>

GtkBuilder	*builder;
GtkWidget	*window, *entry;
 
int main (int argc, char *argv[]) {
	gtk_init (&argc, &argv);
	
	builder = gtk_builder_new ();
	gtk_builder_add_from_file (builder, "gtkmodel.glade", NULL);
 
	window = GTK_WIDGET (gtk_builder_get_object (builder, "window1"));
	entry=GTK_WIDGET (gtk_builder_get_object (builder, "entry1"));
	gtk_builder_connect_signals (builder, NULL);

	g_object_unref (G_OBJECT (builder));
	
	gtk_widget_show (window);
	gtk_main ();
	
	return 0;
}
void on_window1_destroy (GtkObject *object, gpointer user_data) {
	gtk_main_quit();
}
void on_button1_clicked (GtkButton *button, gpointer user_data) {
	gtk_entry_set_text(GTK_ENTRY(entry), "Hello, World!");
	printf("Hello, world!\n");
}

