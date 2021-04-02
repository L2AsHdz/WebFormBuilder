package generator.form;

import generator.Generator;
import java.util.List;
import model.DatoRecopilado;

/**
 *
 * @date 2/04/2021
 * @time 12:56:33
 * @author asael
 */
public class RecopiledDataGenerator extends Generator {

    private final List<DatoRecopilado> dt;

    public RecopiledDataGenerator(List<DatoRecopilado> dt) {
        this.dt = dt;
    }

    @Override
    public String generate() {
        text = new StringBuilder();

        addLine("db.recopiledData(", 0);
        addLine("{", 1);
        dt.forEach(d -> {
            addLine("\"" + d.getNombre() + "\" : \"" + d.getValor() + "\",", 2);
        });
        text.deleteCharAt(text.lastIndexOf(","));
        addLine("}", 1);
        addLine(")", 0);

        return text.toString();
    }

}
