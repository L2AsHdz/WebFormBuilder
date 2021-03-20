package com.l2ashdz.appcliente.controller.textEditor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @date 19/03/2021
 * @time 13:08:54
 * @author asael
 */
public class SendDataToServer {
    
    private static final String URL = "http://localhost:8080/AppServer/requestReader";
    private static final HttpClient client = HttpClient.newHttpClient();
    
    public static String send(String text, String user) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(text))
                .setHeader("user", user)
                .uri(URI.create(URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(System.out);
            return e.getMessage();
        }
    }
}
