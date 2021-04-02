package datos.form;

import java.util.List;

import static aux.FileController.*;
import datos.StorageFileAnalyzer;
import generator.Generator;
import generator.form.RecopiledDataGenerator;
import java.io.StringReader;
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
        StringReader text = new StringReader(readFile(PATH_FORMS + idForm + "/recopiledData.db"));
        return analyzer.analyzeData(text);
    }
    
    public boolean exists(String idForm) {
        return verifyFile(PATH_FORMS + idForm + "/recopiledData.db");
    }

}
