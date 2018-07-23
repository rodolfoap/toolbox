public class MyProperty : Object {

    private static uint step = 0;

    /* Property-backing fields */
    private int _c_g_s_prop;
    private int _c_o_prop;
    private int _g_s_prop;

    /* Properties */

    public int construct_only_prop {
        construct {
            stdout.printf ("---- Step %u: construct_only ----\n", step);
            stdout.printf ("construct_only (before): %d\n", _c_o_prop);
            _c_o_prop = value;
            stdout.printf ("construct_only (after): %d\n\n", _c_o_prop);
            step++;
        }
        get {
            return _c_o_prop;
        }
    }

    public int construct_get_set_prop {
        construct set {
            stdout.printf ("---- Step %u: construct_get_set ----\n", step);
            stdout.printf ("construct_get_set (before): %d\n", _c_g_s_prop);
            _c_g_s_prop = value;
            stdout.printf ("construct_get_set (after): %d\n\n", _c_g_s_prop);
            step++;
        }
        get {
            return _c_g_s_prop;
        }
    }

    public int get_set_prop {
        set {
            stdout.printf ("---- Step %u: get_set ----\n", step);
            stdout.printf ("get_set_prop (before): %d\n", _g_s_prop);
            _g_s_prop = value;
            stdout.printf ("get_set_prop (after): %d\n\n", _g_s_prop);
            step++;
        }
        get {
            return _g_s_prop;
        }
    }

    /* Creation method */

    public MyProperty (int a, int b, int c) {
        Object (construct_only_prop: a, construct_get_set_prop: b);
        this.get_set_prop = c;
    }

    /* Construct block */

    construct {
        stdout.printf ("++++++++++ construct block +++++++++++++++\n\n");
        this.get_set_prop = 5;
        stdout.printf ("++++++++++ end of construct block ++++++++\n\n");
    }
}

void main () {
    stdout.printf ("===== Construction process: MyProperty (1, 2, 3) ====\n\n");
    var demo = new MyProperty (1, 2, 3);
    stdout.printf ("===== End of construction process ===================\n\n");
    demo.construct_get_set_prop = 222;
    demo.get_set_prop = 333;
}

