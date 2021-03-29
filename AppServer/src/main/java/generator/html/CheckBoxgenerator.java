package generator.html;

import generator.Generator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Componente;

/**
 *
 * @date 29/03/2021
 * @time 00:08:16
 * @author asael
 */
public class CheckBoxgenerator extends Generator {

    private Componente c;

    public CheckBoxgenerator() {
    }

    public void setC(Componente c) {
        this.c = c;
    }

    @Override
    public String generate() {
        text = new StringBuilder();
        List<String> opciones;
        
        if (c.getOpciones().contains("|")) {
            opciones = Arrays.asList(c.getOpciones().split("\\|"));
        } else {
            opciones = new ArrayList();
            opciones.add(c.getOpciones());
        }

        addLine("<label for=\"check\">" + c.getTextoVisible() + "</label>", 8);

        opciones.forEach(o -> {
            addLine("<div class=\"form-check\">", 8);
            addLine("<label class=\"form-check-label\">", 9);
            addLine("<input type=\"checkbox\" class=\"form-check-input\" name=\"" + c.getNombreCampo() + "\" value=\"\">" + o + "", 10);
            addLine("</label>", 9);
            addLine("</div>", 8);
        });

        return text.toString();
    }

}
