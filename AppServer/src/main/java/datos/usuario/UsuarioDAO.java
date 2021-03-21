package datos.usuario;

import datos.CRUD;
import java.io.File;
import java.util.List;
import model.Usuario;

/**
 *
 * @date 20/03/2021
 * @time 18:53:34
 * @author asael
 */
public class UsuarioDAO implements CRUD<Usuario> {

    @Override
    public List<Usuario> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getObject(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(String id) {
        return new File("/home/asael/NetBeansProjects/WebFormBuilder/data/users/" + id + ".db").exists();
    }

}
