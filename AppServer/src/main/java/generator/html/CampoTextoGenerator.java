package generator.html;

import generator.Generator;
import java.util.List;
import model.Componente;

/**
 *
 * @date 28/03/2021
 * @time 20:07:35
 * @author asael
 */
public class CampoTextoGenerator extends Generator {

    private List<Componente> componentes;

    public CampoTextoGenerator(List<Componente> componentes) {
        this.componentes = componentes;
    }

    @Override
    public String generate() {
        componentes.forEach(c -> {
            if (c.getClase().equals("CAMPO_TEXTO")) {
                addLine("<div class=\"form-group\">", 8);
                addLine("<label for=\""+c.getNombreCampo()+"\">" + c.getTextoVisible() + "</label>", 9);
                addLine("<input type=\"text\" class=\"form-control\" name=\""+c.getNombreCampo()+"\" value=\"\">", 9);
                addLine("</div>", 8);
            }
        });

        return text.toString();
    }

}
