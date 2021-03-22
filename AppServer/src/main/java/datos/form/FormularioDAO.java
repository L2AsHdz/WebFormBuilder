package datos.form;

import datos.CRUD;
import java.util.List;
import model.Formulario;

import static aux.FileController.*;
import static datos.form.FormStorageStructureGenerator.generate;
import java.io.File;

/**
 *
 * @date 21/03/2021
 * @time 11:42:41
 * @author asael
 */
public class FormularioDAO implements CRUD<Formulario>{
    
    private final String PATH_FORMS = "/home/asael/NetBeansProjects/WebFormBuilder/data/forms/";

    @Override
    public List<Formulario> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Formulario f) {
        createDirectory(PATH_FORMS + f.getId());
        saveFile(PATH_FORMS + f.getId() + "/estructura.db", generate(f));
    }

    @Override
    public Formulario getObject(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Formulario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        return deleteDirectory(new File(PATH_FORMS + id));
    }

    @Override
    public boolean exists(String id) {
        return verifyFile(PATH_FORMS + id);
    }

}
