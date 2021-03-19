package com.l2ashdz.appcliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import static com.l2ashdz.appcliente.controller.FileController.readFile;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static final String URL = "http://localhost:8080/AppServer/requestReader";

    public static void main(String[] args) {
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(BodyPublishers.ofString(readFile("Entrada.txt")))
                .uri(URI.create(URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(System.out);
        }
        
    }
}
