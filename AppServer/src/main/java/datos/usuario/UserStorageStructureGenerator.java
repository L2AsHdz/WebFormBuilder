package datos.usuario;

import model.Usuario;

/**
 *
 * @date 21/03/2021
 * @time 01:37:11
 * @author asael
 */
public class UserStorageStructureGenerator {
        
    private static StringBuilder text;
    
    public static String generate(Usuario user){
        text = new StringBuilder();
        
        addLine("db.user(");
        addLine("\t{");
        addLine("\t\t\"USUARIO\" : \""+user.getNombre()+"\",");
        addLine("\t\t\"PASSWORD\" : \""+user.getPassword()+"\",");
        addLine("\t\t\"FECHA_CREACION\" : \""+user.getFechaCreacion()+"\"");
        addLine("\t}");
        addLine(")");
        
        return text.toString();
    }
    
    private static void addLine(String s){
        text.append(s).append("\n");
    }
}
