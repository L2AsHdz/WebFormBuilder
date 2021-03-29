package generator.html;

import generator.Generator;
import model.Componente;

/**
 *
 * @date 28/03/2021
 * @time 22:41:30
 * @author asael
 */
public class AreaTextoGenerator extends Generator {

    private Componente c;

    public AreaTextoGenerator() {
    }

    public void setComp(Componente comp) {
        this.c = comp;
    }

    @Override
    public String generate() {
        text = new StringBuilder();
        
        addLine("<div class=\"form-group\">", 8);
        addLine("<label for=\"" + c.getNombreCampo() + "\">" + c.getTextoVisible() + "</label>", 9);
        addLine("<textarea class=\"form-control\" name=\"" + c.getNombreCampo() + "\" rows=\"" + c.getNoFilas() + "\" cols=\"" + c.getNoColumnas() + "\"></textarea>", 9);
        addLine("</div>", 8);

        return text.toString();
    }

}
