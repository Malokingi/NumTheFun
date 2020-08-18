package com.matthewsgrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.matthewsgrand.data.ConnectUtil;

public class del_glossary {
    static Connection con = ConnectUtil.getConnection();
    static PreparedStatement smt;

    public static void browse() {
        if (con == null) {
            System.err.println("The database is not available (Is probably why this didn't work).");
            return;
        }
        ResultSet res;
        final String q = "SELECT word, def FROM term_entry t join words w on word_id = w.id join defs d on def_id = d.id;";
        try {
            smt = con.prepareStatement(q);
            // smt.setString(1, word);
            res = smt.executeQuery();
            System.out.println("Here are the terms I know:");
            while (res.next()) {
                System.out.println(res.getString("word") + " - " + res.getString("def"));
            }
        } catch (final SQLException e) {
            System.err.println("Failed something SQL-related in glossary.");
            e.printStackTrace();
        }

    }

    public static String getWord(final String word) {
        final String def = "poop";

        return def;
    }
}