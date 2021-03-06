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
        text = new StringBuilder();
        addLine("db.user(", 0);
        addLine("{", 1);
        addLine("\"USUARIO\" : \""+user.getNombre()+"\",", 2);
        addLine("\"PASSWORD\" : \""+user.getPassword()+"\",", 2);
        addLine("\"FECHA_CREACION\" : \""+user.getFechaCreacion()+"\",", 2);
        if (user.getFechaModificacion() != null) addLine("\"FECHA_MODIFICACION\" : \""+user.getFechaModificacion()+"\",", 2);
        text.deleteCharAt(text.lastIndexOf(","));
        addLine("}", 1);
        addLine(")", 0);
        
        return text.toString();
    }
}
