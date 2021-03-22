package datos.form;

import model.Formulario;

/**
 *
 * @date 22/03/2021
 * @time 01:08:45
 * @author asael
 */
public class FormStorageStructureGenerator {
    
    private static StringBuilder text;
    
    public static String generate(Formulario form) {
        text = new StringBuilder();
        
        addLine("db.form(");
        addLine("\t{");
        addLine("\t\t\"ID\" : \""+form.getId()+"\",");
        addLine("\t\t\"TITULO\" : \""+form.getTitulo()+"\",");
        addLine("\t\t\"NOMBRE\" : \""+form.getNombre()+"\",");
        addLine("\t\t\"TEMA\" : \""+form.getTema()+"\",");
        addLine("\t\t\"USUARIO_CREACION\" : \""+form.getUsuarioCreacion()+"\",");
        addLine("\t\t\"FECHA_CREACION\" : \""+form.getFechaCreacion()+"\"");
        addLine("\t}");
        addLine(")");
        
        return text.toString();
    }
    
    private static void addLine(String s){
        text.append(s).append("\n");
    }
}
