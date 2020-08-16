package com.matthewsgrand.data;

public class Entry {
    static long entry_id;
    // static long word_id;
    // static long def_id;
    // static long example_id;
    // static String added_by;
    // static String date_added;
    static String word;
    static String def;
    static String example;
    static String anti_example;

    public Entry(long id, String w, String d, String e, String anti_e) {
        entry_id = id;
        word = w;
        def = d;
        example = e;
        anti_example = anti_e;
    }


}