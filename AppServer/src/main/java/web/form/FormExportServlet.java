package web.form;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import static aux.FileController.readFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStream;

/**
 *
 * @date 1/04/2021
 * @time 10:57:15
 * @author asael
 */
@WebServlet("/export")
public class FormExportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idForm = request.getParameter("id");
        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + idForm + ".form");

        String content = readFile("/home/asael/NetBeansProjects/WebFormBuilder/data/forms/" + idForm + "/estructura.db");
        File form = new File(idForm + ".form");
        FileWriter fileWriter = new FileWriter(form);
        try ( BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        

        FileInputStream inputStream = new FileInputStream(form);
        try ( PrintWriter out = response.getWriter()) {
            int i;
            while ((i = inputStream.read()) != -1) {
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
