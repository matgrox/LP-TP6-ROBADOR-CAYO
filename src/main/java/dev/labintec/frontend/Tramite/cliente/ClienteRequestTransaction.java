/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.frontend.Tramite.cliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matgr
 */
public class ClienteRequestTransaction {

    public static String requestTransactionPostNuevo(String jason) {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(jason);
            URI uri = URI.create("http://localhost:8080/api/v1/transactions");
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(body)
                    .build();
            HttpResponse<String> response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestTransactionObtenerTodas() {
        HttpClient cliente = HttpClient.newHttpClient();
        URI uri = URI.create("http://localhost:8080/api/v1/transactions");

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String requestTransactionObtenerPorEstado(String estado) {
        HttpClient cliente = HttpClient.newHttpClient();
        URI uri = URI.create("http://localhost:8080/api/v1/transactions/estado/"+estado);

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public static String requestTransactionObtenerPorTipo(String tipo){
        HttpClient cliente = HttpClient.newHttpClient();
        URI uri = URI.create("http://localhost:8080/api/v1/transactions/tipo/"+tipo);

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public static String requestTransactionObtenerPorid(int id){
        HttpClient cliente = HttpClient.newHttpClient();
        URI uri = URI.create("http://localhost:8080/api/v1/transactions/"+id);

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void requestTransactionEliminarPorid(int id){
        HttpClient cliente = HttpClient.newHttpClient();
        URI uri = URI.create("http://localhost:8080/api/v1/transactions/"+id);

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response;
        try {
            cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String requestTransactionActualizarEstado(int id, String nuevoEstado) {
    HttpClient cliente = HttpClient.newHttpClient();
    String json = "{ \"estado\": \"" + nuevoEstado + "\" }";
    HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(json);
    URI uri = URI.create("http://localhost:8080/api/v1/transactions/actualizar-e/" + id);

    HttpRequest peticion = HttpRequest.newBuilder()
        .uri(uri)
        .header("Content-Type", "application/json")
        .PUT(body)
        .build();

    HttpResponse<String> response;
        try {
            response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
     public static String requestTransactionActualizarTipo(int id, String nuevoTipo) {
    HttpClient cliente = HttpClient.newHttpClient();
    String json = "{ \"tipo\": \"" + nuevoTipo + "\" }";
    HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(json);
    URI uri = URI.create("http://localhost:8080/api/v1/transactions/actualizar-t/" + id);

    HttpRequest peticion = HttpRequest.newBuilder()
        .uri(uri)
        .header("Content-Type", "application/json")
        .PUT(body)
        .build();

    HttpResponse<String> response;
        try {
            response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteRequestTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
}
