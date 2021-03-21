package datos.usuario;

import datos.CRUD;
import java.util.List;
import model.Usuario;

import static aux.FileController.*;
import static datos.usuario.UserStorageStructureGenerator.generate;

/**
 *
 * @date 20/03/2021
 * @time 18:53:34
 * @author asael
 */
public class UsuarioDAO implements CRUD<Usuario> {

    private final String PATH_USERS = "/home/asael/NetBeansProjects/WebFormBuilder/data/users/";

    @Override
    public List<Usuario> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Usuario u) {
        saveFile(PATH_USERS + u.getNombre() + ".db", generate(u));
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
        return verifyFile(PATH_USERS + id + ".db");
    }

}
