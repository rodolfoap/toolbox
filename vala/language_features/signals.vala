public class Foo : Object {
    public signal void some_event ();   // definition of the signal

    public void method () {
        some_event ();                  // emitting the signal (callbacks get invoked)
    }
}

static void callback_a () {
    stdout.printf ("Callback A\n");
}

static void callback_b () {
    stdout.printf ("Callback B\n");
}

static int main (string[] args) {
    var foo = new Foo ();
    foo.some_event.connect (callback_a);      // connecting the callback functions
    foo.some_event.connect (callback_b);
    foo.method ();
    return 0;
}

