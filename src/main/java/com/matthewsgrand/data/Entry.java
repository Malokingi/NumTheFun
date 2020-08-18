package com.matthewsgrand.data;

public class Entry {
    static long entry_id; // happens to equal the foreigen keys at all times
    // static long word_id;
    // static long def_id;
    public String word;
    public String def;
    public String added_by;
    public String date_added;

    public Entry(long id, String w, String d, String ab, String da) {
        entry_id = id;
        word = w;
        def = d;
        added_by = ab;
        date_added = da;
    }
}