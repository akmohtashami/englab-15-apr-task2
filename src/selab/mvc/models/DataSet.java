package selab.mvc.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DataSet<T extends Model> {
    private HashMap<String, T> set = new HashMap<>();
    private DataContext dataContext;

    public DataSet(DataContext dataContext) {
        this.dataContext = dataContext;
    }

    public DataContext getDataContext() {
        return dataContext;
    }

    public void add(T entity) {
        String key = entity.getPrimaryKey();
        if (set.containsKey(key))
            throw new IllegalArgumentException("Duplicate primary key.");
        entity.bind(this);
        set.put(key, entity);
    }

    public T get(String key) {
        return set.get(key);
    }

    public void remove(T entity) {
        String key = entity.getPrimaryKey();
        if (!set.containsKey(key))
            throw new IllegalArgumentException("No such primary key.");
        set.remove(key);
    }

    public ArrayList<T> getAll() {
        return new ArrayList(set.values());
    }
}
