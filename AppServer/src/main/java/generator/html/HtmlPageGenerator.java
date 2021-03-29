package generator.html;

import generator.Generator;
import model.Formulario;

/**
 *
 * @date 28/03/2021
 * @time 16:32:55
 * @author asael
 */
public class HtmlPageGenerator extends Generator {
    
    private Formulario form;
    private CampoTextoGenerator campoTextoG;

    public HtmlPageGenerator(Formulario form) {
        this.form = form;
        campoTextoG = new CampoTextoGenerator(form.getComponentes());
    }
    
    @Override
    public String generate() {
        addLine("<!DOCTYPE html>", 0);
        addLine("<html>", 0);
        //head
        addLine("<head>", 1);
        addLine("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">", 2);
        addLine("<title>"+form.getTitulo()+"</title>", 2);
           
        //extras css
        addLine("<link rel=\"stylesheet\" href=\"/WebFormBuilder/css/bootstrap.css\">", 2);
        addLine("<link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\">", 2);
        addLine("<link rel=\"stylesheet\" href=\"/WebFormBuilder/css/styles.css\">", 2);
        addLine("</head>", 1);
        //fin head
        
        //body
        addLine("<body>", 1);
        addLine("<div class=\"container-fluid\">", 2);
        addLine("<div class=\"row my-5\">", 3);
        addLine("<div class=\"col-2\"></div>", 4);
        addLine("<div class=\"col-8\">", 4);
        addLine("<div class=\"card my-5\">", 5);
        addLine("<div class=\"card-header text-center\">", 6);
        addLine("<h4>"+form.getTitulo()+"</h4>", 7);
        addLine("</div>", 6);
        
        //componentes
        addLine("<form id=\"form-"+form.getId()+"\" action=\"/WebFormBuilder/readData\" method=\"POST\" enctype=\"multipart/form-data\">", 6);
        addLine("<div class=\"card-body\">", 7);
        text.append(campoTextoG.generate());
        addLine("</div>", 7);
        addLine("</form>", 6);
        
        //divs de cierre
        addLine("</div>", 5 );
        addLine("</div>", 4);
        addLine("</div>", 3);
        addLine("</div>", 2);
        
        //extras js
        addLine("<script src=\"/WebFormBuilder/js/jquery-3.6.0.js\"></script>", 2);
        addLine("<script src=\"/WebFormBuilder/js/popper.js\"></script>", 2);
        addLine("<script src=\"/WebFormBuilder/js/bootstrap.js\"></script>", 2);
        addLine("</body>", 1);
        //fin body
        
        addLine("</html>", 0);
        
        return text.toString();
    }
}
