package datos.form;

import datos.CRUD;
import java.util.List;
import model.Formulario;

import static aux.FileController.*;
import datos.StorageFileAnalyzer;
import generator.Generator;
import generator.form.FormStorageStructureGenerator;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @date 21/03/2021
 * @time 11:42:41
 * @author asael
 */
public class FormularioDAO implements CRUD<Formulario> {

    private final String NAME_USER_LINUX = System.getProperty("user.name");
    private final String PATH_FORMS = "/home/" + NAME_USER_LINUX + "/WebFormBuilder/data/forms/";
    private final StorageFileAnalyzer analyzer = new StorageFileAnalyzer();
    private Generator formSSG;

    @Override
    public List<Formulario> getList() {
        List<String> fileNames = getfileNames(PATH_FORMS);
        List<Formulario> forms = new ArrayList();

        fileNames.forEach(fn -> forms.add(getObject(fn)));

        return forms;
    }

    @Override
    public void create(Formulario f) {
        formSSG = new FormStorageStructureGenerator(f);
        createDirectory(PATH_FORMS + f.getId());
        saveFile(PATH_FORMS + f.getId() + "/estructura.db", formSSG.generate());
    }

    @Override
    public Formulario getObject(String id) {
        StringReader text = new StringReader(readFile(PATH_FORMS + id + "/estructura.db"));
        return analyzer.analyzeForm(text);
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
