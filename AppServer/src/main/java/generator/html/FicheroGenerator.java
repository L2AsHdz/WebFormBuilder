package generator.html;

import generator.Generator;
import model.Componente;

/**
 *
 * @date 29/03/2021
 * @time 01:42:48
 * @author asael
 */
public class FicheroGenerator extends Generator {
    
    private Componente c;

    public FicheroGenerator() {
    }

    public void setC(Componente c) {
        this.c = c;
    }

    @Override
    public String generate() {
        text = new StringBuilder();
        
        addLine("<div class=\"form-group mt-3\">", 8);
        addLine("<label for=\""+c.getNombreCampo()+"\">"+c.getTextoVisible()+"</label>", 9);
        addLine("<input type=\"file\" class=\"form-control-file border\" name=\""+c.getNombreCampo()+"\" accept=\".*\">", 9);
        addLine("</div>", 8);
        
        return text.toString();
    }

}
