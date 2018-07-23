#include <gtk/gtk.h>

//  gcc -o dialog dialog.c $(pkg-config --cflags --libs gtk+-2.0 gmodule-export-2.0)

typedef struct _Data Data; 
struct _Data {
    GtkWidget *quit;
    GtkWidget *about;
};
 
G_MODULE_EXPORT gboolean cb_delete_event( GtkWidget *window, GdkEvent  *event, Data *data ) {
    gint response = 1;
    response = gtk_dialog_run( GTK_DIALOG( data->quit ) );
    gtk_widget_hide( data->quit );
    return( 1 != response );
}
 
G_MODULE_EXPORT void cb_show_about( GtkButton *button, Data *data ) {
    gtk_dialog_run( GTK_DIALOG( data->about ) );
    gtk_widget_hide( data->about );
}
 
int main(int argc, char **argv) {
    GtkBuilder *builder;
    GtkWidget  *window;
    Data        data;
 
    gtk_init( &argc, &argv );
    builder = gtk_builder_new();
    gtk_builder_add_from_file( builder, "dialog.builder", NULL );
 
    window = GTK_WIDGET( gtk_builder_get_object( builder, "window1" ) );
    data.quit = GTK_WIDGET( gtk_builder_get_object( builder, "dialog1" ) );
    data.about = GTK_WIDGET( gtk_builder_get_object( builder, "aboutdialog1" ) );
 
    gtk_builder_connect_signals( builder, &data );
    g_object_unref( G_OBJECT( builder ) );
    gtk_widget_show( window );
    gtk_main();
    return( 0 );
}
