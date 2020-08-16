package com.matthewsgrand.data;

import java.util.List;

/**
 * An Interface with Generics! Data Acess Object
 * 
 * @param <G>
 */
public interface Dao<G> {
    G get(long id);
    List<G> getAll();
    void save(G g);
    void update(G g, String[] params);
    void delete(G g);
}