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
public class ComponentsGenerator extends Generator {

    private final List<Componente> componentes;
    private final CampoTextoGenerator campoTextoG;
    private final AreaTextoGenerator areaTextoG;

    public ComponentsGenerator(List<Componente> componentes) {
        this.componentes = componentes;
        campoTextoG = new CampoTextoGenerator();
        areaTextoG = new AreaTextoGenerator();
    }

    @Override
    public String generate() {
        componentes.forEach(c -> {
            switch(c.getClase()) {
                case "CAMPO_TEXTO" -> {
                    campoTextoG.setComp(c);
                    text.append(campoTextoG.generate());
                }
                case "AREA_TEXTO" -> {
                    areaTextoG.setComp(c);
                    text.append(areaTextoG.generate());
                }
                case "CHECKBOX" -> {}
                case "RADIO" -> {}
                case "FICHERO" -> {}
                case "IMAGEN" -> {}
                case "COMBO" -> {}
                case "BOTON" -> {}
            }
        });

        return text.toString();
    }

}
