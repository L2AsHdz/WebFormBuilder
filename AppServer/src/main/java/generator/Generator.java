package generator;

/**
 *
 * @date 28/03/2021
 * @time 19:38:14
 * @author asael
 */
public abstract class Generator {
    
    private StringBuilder text = new StringBuilder();
    
    public abstract String generate();

    public StringBuilder getText() {
        return text;
    }
    
    protected void addLine(String s, int tabulaciones) {

        for (int i = 0; i < tabulaciones; i++) {
            text.append("    ");
        }

        text.append(s).append("\n");
    }
}
