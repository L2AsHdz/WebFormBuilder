package datos;

import analizadores.lexico.StorageLexer;
import analizadores.sintactico.StorageParser;
import java.io.Reader;
import model.Formulario;
import model.Usuario;

/**
 *
 * @date 24/03/2021
 * @time 00:52:31
 * @author asael
 */
public class StorageFileAnalyzer {

    private StorageLexer lex;
    private StorageParser parser;

    public StorageFileAnalyzer() {
    }
    
    public Usuario analyzeUser(Reader reader) {
        try {
            lex = new StorageLexer(reader);
            parser = new StorageParser(lex);
            
            parser.parse();
            return parser.getUsuario();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
    
    public Formulario analyzeForm(Reader reader){
        try {
            lex = new StorageLexer(reader);
            parser = new StorageParser(lex);
            
            parser.parse();
            return parser.getForm();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}
