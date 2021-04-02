package web.form;

import datos.CRUD;
import datos.form.DatoRecopiladoDAO;
import datos.form.FormularioDAO;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Componente;
import model.DatoRecopilado;
import model.Formulario;

/**
 *
 * @date 2/04/2021
 * @time 02:34:25
 * @author asael
 */
@WebServlet("/readData")
@MultipartConfig
public class ReadDataServlet extends HttpServlet {

    private final CRUD<Formulario> formDAO = new FormularioDAO();
    private final DatoRecopiladoDAO dataDAO = new DatoRecopiladoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idForm = request.getParameter("idForm");
        var form = formDAO.getObject(idForm);

        Part part;
        String value;
        String values;
        List<DatoRecopilado> datosRecopilados;
        
        if (dataDAO.exists(idForm)) {
            datosRecopilados = dataDAO.getObject(idForm);
        } else {
            datosRecopilados = new ArrayList();
        }
        
        for (Componente c : form.getComponentes()) {
            values = null;
            value = null;
            switch (c.getClase()) {
                case "CHECKBOX" -> {
                    values = Arrays.toString(request.getParameterValues(c.getNombreCampo())).replace("[", "").replace("]", "").replaceAll("\\s", "");
                }
                case "FICHERO" -> {
                    try {
                        part = request.getPart(c.getNombreCampo());
                        value = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    } catch (IOException | ServletException e) {
                    }
                }
                case "CAMPO_TEXTO", "RADIO", "COMBO", "AREA_TEXTO" ->
                    value = request.getParameter(c.getNombreCampo());
            }
            if (values != null) {
                if (!values.equals("null")) {
                    datosRecopilados.add(new DatoRecopilado(c.getNombreCampo(), values));
                }
            }

            if (value != null) {
                if (!value.trim().isEmpty()) {
                    datosRecopilados.add(new DatoRecopilado(c.getNombreCampo(), value));
                }
            }
        }
        
        dataDAO.create(datosRecopilados, idForm);

        response.sendRedirect("success.jsp");
    }

}
