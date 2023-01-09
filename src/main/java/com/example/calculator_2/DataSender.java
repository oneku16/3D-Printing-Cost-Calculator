package com.example.calculator_2;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DataSender {

    // one instance, reuse
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void main(String[] args) throws Exception {

        DataSender obj = new DataSender();

//        System.out.println("Testing 1 - Send Http GET request");
//        obj.sendGet();

        System.out.println("Testing 2 - Send Http POST request");
        obj.sendPost();

    }

    private void sendGet() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
//        System.out.println(response.body());

    }

    private void sendPost() throws Exception {

        // form parameters
        /*
        *{
    "first_name" : "Elnazar",
    "last_name" : "Ulanbek",
    "print_name" : "demo",
    "filament_type" : "ABS",
    "material_length": 8.51,
    "print_time" : "0-12-34",
    "print_date" : "2022-12-12",
    "is_academic" : true,
    "print_cost" : 55.2
}
        * */
        Map<Object, Object> data = new HashMap<>();
        data.put("first_name", "Java");
        data.put("last_name", "Java");
        data.put("print_name", "TestJava");
        data.put("material_length", 11.2);
        data.put("print_time", "0-12-34");
        data.put("print_date", "2022-12-12");
        data.put("is_academic", true);
        data.put("print_cost", 100.1);

        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormDataFromMap(data))
                .uri(URI.create("http://127.0.0.1:8000/new_print/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());
//        System.out.println(data);
        // print response body
//        System.out.println(response.body());

    }

    private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        System.out.println(builder.toString());
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

}