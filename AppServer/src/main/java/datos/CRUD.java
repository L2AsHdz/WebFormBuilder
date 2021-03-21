package datos;

import java.util.List;

/**
 *
 * @author asael
 */
public interface CRUD<T> {
    List<T> getList();
    void create(T t);
    T getObject(String id);
    boolean update(T t);
    boolean delete(String id);
    boolean exists(String id);
}
