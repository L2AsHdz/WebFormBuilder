package generator.user;

import generator.Generator;
import model.Usuario;

/**
 *
 * @date 21/03/2021
 * @time 01:37:11
 * @author asael
 */
public class UserStorageStructureGenerator extends Generator {

    private Usuario user;

    public UserStorageStructureGenerator(Usuario user) {
        this.user = user;
    }
    
    @Override
    public String generate(){
        
        addLine("db.user(", 0);
        addLine("{", 1);
        addLine("\"USUARIO\" : \""+user.getNombre()+"\",", 2);
        addLine("\"PASSWORD\" : \""+user.getPassword()+"\",", 2);
        addLine("\"FECHA_CREACION\" : \""+user.getFechaCreacion()+"\"", 2);
        addLine("}", 1);
        addLine(")", 0);
        
        return getText().toString();
    }
}
