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
    void update(T t);
    void delete(String id);
    boolean exists(String id);
}
