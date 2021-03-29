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
    private final CheckBoxgenerator checkBoxG;
    private final RadioGenerator raadioG;
    private final FicheroGenerator ficheroG;

    public ComponentsGenerator(List<Componente> componentes) {
        this.componentes = componentes;
        campoTextoG = new CampoTextoGenerator();
        areaTextoG = new AreaTextoGenerator();
        checkBoxG = new CheckBoxgenerator();
        raadioG = new RadioGenerator();
        ficheroG = new FicheroGenerator();
    }

    @Override
    public String generate() {
        text = new StringBuilder();
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
                case "CHECKBOX" -> {
                    checkBoxG.setC(c);
                    text.append(checkBoxG.generate());
                }
                case "RADIO" -> {
                    raadioG.setC(c);
                    text.append(raadioG.generate());
                }
                case "FICHERO" -> {
                    ficheroG.setC(c);
                    text.append(ficheroG.generate());
                }
                case "IMAGEN" -> {}
                case "COMBO" -> {}
                case "BOTON" -> {}
            }
        });

        return text.toString();
    }

}
