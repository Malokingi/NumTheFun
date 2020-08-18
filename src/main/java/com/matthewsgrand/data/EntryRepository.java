package com.matthewsgrand.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntryRepository implements Dao {
    static Connection con = ConnectUtil.getConnection();
    static PreparedStatement smt;

    @Override
    public Entry get(final long id) {
        if (con == null)
            return null;
        Entry ent = null;
        ResultSet res;
        final String select = "SELECT word, def, added_by, date_added ";
        final String from = "FROM term_entry t join words w on word_id = w.id join defs d on def_id = d.id ";
        final String where = "WHERE t.id = ?";
        final String query = select + from + where + ";";
        try {
            smt = con.prepareStatement(query);
            smt.setLong(1, id);
            res = smt.executeQuery();
            while (res.next()) {
                ent = new Entry(id, res.getString("word"), res.getString("def"), res.getString("added_by"), res.getString("date_added"));
            }
        } catch (final SQLException e) {
            System.err.println("Failed something SQL-related in EntryRepository:get().");
            e.printStackTrace();
        }
        return ent;
    }

    @Override
    public List<Entry> getAll() {
        if (con == null)
            return null;
        int total_terms = 0;
        ResultSet res;
        final List<Entry> db = new ArrayList<Entry>();
        final String select = "SELECT COUNT(DISTINCT id) ";
        final String from = "FROM term_entry";
        final String query = select + from + ";";
        try {
            smt = con.prepareStatement(query);
            res = smt.executeQuery();
            while (res.next()){
                total_terms = res.getInt("count");
            }
            System.out.printf("Looks like there are %d unique terms in the Glossary.\n", total_terms);
            for (int i = 0; i < total_terms; i++) {
                db.add(get(i + 1));
            }
        } catch (final SQLException e) {
            System.err.println("Failed something SQL-related in EntryRepository:get_all().");
            e.printStackTrace();
        }
        return db;
    }

    @Override
    public void save(final Object g) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(final Object g, final String[] params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(final Object g) {
        // TODO Auto-generated method stub

    }    
}