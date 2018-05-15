package project.service;

import java.util.List;

public interface Service<T> {
    public void add(T t);

    public void update(T t);

    public void remove(int id);

    public T getById(int id);

    public List<T> list();

    public List<T> listWhere(String where);
}
