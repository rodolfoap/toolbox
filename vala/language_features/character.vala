void main () {

    string unicode_string = "1234567890 ١٢٣٤٥٦٧٨٩۰ ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz أبتةثجحخدذرزسشصضطظعغفقكلمنهوي";

    for (unowned string s = unicode_string; s.get_char () != 0 ; s = s.next_char ()) {

        unichar unicode_character = s.get_char ();
        UnicodeType unicode_character_type = unicode_character.type ();

        stdout.printf("'%s' is ", new StringBuilder ().append_unichar (unicode_character).str);

        switch (unicode_character_type) {
        case UnicodeType.UPPERCASE_LETTER:
            stdout.printf ("UPPERCASE_LETTER\n");
            break;
        case UnicodeType.LOWERCASE_LETTER:
            stdout.printf ("LOWERCASE_LETTER\n");
            break;
        case UnicodeType.OTHER_LETTER:
            stdout.printf("OTHER_LETTER\n");
            break;
        case UnicodeType.DECIMAL_NUMBER:
            stdout.printf ("OTHER_NUMBER\n");
            break;
        case UnicodeType.SPACE_SEPARATOR:
            stdout.printf ("SPACE_SEPARATOR\n");
            break;
        }
    }
}

