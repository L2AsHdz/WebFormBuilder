package generator.html;

import generator.Generator;
import model.Componente;

/**
 *
 * @date 28/03/2021
 * @time 22:29:35
 * @author asael
 */
public class CampoTextoGenerator extends Generator {

    private Componente c;

    public CampoTextoGenerator() {
    }

    public void setComp(Componente comp) {
        this.c = comp;
    }

    @Override
    public String generate() {
        text = new StringBuilder();
        
        addLine("<div class=\"form-group\">", 8);
        addLine("<label for=\"" + c.getNombreCampo() + "\">" + c.getTextoVisible() + "</label>", 9);
        addLine("<input type=\"text\" class=\"form-control\" name=\"" + c.getNombreCampo() + "\" value=\"\">", 9);
        addLine("</div>", 8);

        return text.toString();
    }

}
