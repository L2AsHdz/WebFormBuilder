package datos.usuario;

import datos.CRUD;
import java.util.List;
import model.Usuario;

import static aux.FileController.*;
import datos.StorageFileAnalyzer;
import static datos.usuario.UserStorageStructureGenerator.generate;
import java.io.StringReader;

/**
 *
 * @date 20/03/2021
 * @time 18:53:34
 * @author asael
 */
public class UsuarioDAO implements CRUD<Usuario> {

    private final String PATH_USERS = "/home/asael/NetBeansProjects/WebFormBuilder/data/users/";
    private final StorageFileAnalyzer analyzer = new StorageFileAnalyzer();

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
        StringReader text = new StringReader(readFile(PATH_USERS + id + ".db"));
        return analyzer.analyzeUser(text);
    }

    @Override
    public boolean update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String path) {
        return deleteFile(PATH_USERS + path + ".db");
    }

    @Override
    public boolean exists(String id) {
        return verifyFile(PATH_USERS + id + ".db");
    }

}
