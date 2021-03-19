package com.l2ashdz.appcliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static final String URL = "http://localhost:8080/AppServer/requestReader";
    //public static final String URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(BodyPublishers.ofString("Este es un mensaje desde la appCliente"))
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
