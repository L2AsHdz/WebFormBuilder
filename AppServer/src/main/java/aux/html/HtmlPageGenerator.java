package aux.html;

import model.Formulario;

/**
 *
 * @date 28/03/2021
 * @time 16:32:55
 * @author asael
 */
public class HtmlPageGenerator {
    
    private Formulario form;
    private StringBuilder textHtml;

    public HtmlPageGenerator(Formulario form) {
        this.form = form;
        this.textHtml = new StringBuilder();
    }
    
    public String generate() {
        addLine("<!DOCTYPE html>", 0);
        addLine("<html>", 0);
        //head
        addLine("<head>", 1);
        addLine("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">", 2);
        addLine("<title>"+form.getTitulo()+"</title>", 2);
           
        //extras css
        addLine("<link rel=\"stylesheet\" href=\"WebFormBuilder/css/bootstrap.css\">", 2);
        addLine("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\">", 2);
        addLine("<link rel=\"stylesheet\" href=\"WebFormBuilder/css/styles.css\">", 2);
        addLine("</head>", 1);
        //fin head
        
        //body
        addLine("<body>", 1);
        addLine("<div class=\"container-fluid\">", 2);
        addLine("<div class=\"row\">", 3);
        addLine("<div class=\"col-6\">", 4);
        addLine("</div>", 4);
        addLine("</div>", 3);
        addLine("</div>", 2);
        
        //extras js
        addLine("<script src=\"WebFormBuilder/js/jquery-3.6.0.js\"></script>", 2);
        addLine("<script src=\"WebFormBuilder/js/popper.js\"></script>", 2);
        addLine("<script src=\"WebFormBuilder/js/bootstrap.js\"></script>", 2);
        addLine("</body>", 1);
        //fin body
        
        addLine("</html>", 0);
        
        return textHtml.toString();
    }
    
    private void addLine(String s, int tabulaciones) {

        for (int i = 0; i < tabulaciones; i++) {
            textHtml.append("    ");
        }

        textHtml.append(s).append("\n");
    }
}
