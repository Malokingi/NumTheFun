package com.matthewsgrand.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EntryRepository implements Dao {
    static Connection con = ConnectUtil.getConnection();
    static PreparedStatement smt;

    @Override
    public Object get(long id) {
        if (con == null) return null;
        ResultSet res;
        final String q = "SELECT word, def, example, anti_example FROM term_entry t join words w on word_id = w.id join defs d on def_id = d.id join examples e on example_id = e.id where t.id = " + id + ";";
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
        return null;
    }

    @Override
    public List getAll() {
        if (con == null) return null;
        ResultSet res;
        final String q = "SELECT word, def, example, anti_example FROM term_entry t join words w on word_id = w.id join defs d on def_id = d.id join examples e on example_id = e.id;";
        try {
            smt = con.prepareStatement(q);
            // smt.setString(1, word);
            res = smt.executeQuery();
            System.out.println("Here are the terms I know:");
            while (res.next()) {
                System.out.printf("%s - %s", res.getString("word"), res.getString("def"));
                System.out.printf("\tFor example, These are %s: %s", res.getString("example"));
                System.out.printf("\tThese are not %s: %s", res.getString("anti_example"));
            }
        } catch (final SQLException e) {
            System.err.println("Failed something SQL-related in glossary.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Object g) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Object g, String[] params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Object g) {
        // TODO Auto-generated method stub

    }
    
}