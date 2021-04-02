package datos.form;

import datos.CRUD;
import java.util.List;
import model.Formulario;

import static aux.FileController.*;
import datos.StorageFileAnalyzer;
import generator.Generator;
import generator.form.FormStorageStructureGenerator;
import generator.form.RecopiledDataGenerator;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import model.DatoRecopilado;

/**
 *
 * @date 21/03/2021
 * @time 11:42:41
 * @author asael
 */
public class DatoRecopiladoDAO {

    private final String NAME_USER_LINUX = System.getProperty("user.name");
    private final String PATH_FORMS = "/home/" + NAME_USER_LINUX + "/WebFormBuilder/data/forms/";
    private final StorageFileAnalyzer analyzer = new StorageFileAnalyzer();
    private Generator datoRSG;

    public void create(List<DatoRecopilado> t, String idForm) {
        datoRSG = new RecopiledDataGenerator(t);
        saveFile(PATH_FORMS + idForm + "/recopiledData.db" , datoRSG.generate());
    }

    public List<DatoRecopilado> getObject(String idForm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
