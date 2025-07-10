/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.frontend.Tramite.cliente;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Cliente HTTP encargado de realizar operaciones contra el servicio backend de transacciones.
 * Utiliza el cliente nativo de Java 11+ (HttpClient) para realizar solicitudes REST.
 * Ofrece métodos para crear, consultar, actualizar y eliminar transacciones mediante JSON.
 *
 * Maneja errores de conexión mediante capturas específicas de ConnectException y excepciones generales,
 * mostrando mensajes simples en consola sin imprimir trazas completas.
 *
 * @author matgr
 */

public class ClienteRequestTransaction {
    /**
     * Realiza una solicitud POST para crear una nueva transacción.
     *
     * @param jason Cadena JSON que representa la transacción a crear.
     * @return Cuerpo de la respuesta como String, o {@code null} si hubo error de conexión.
     */
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
            return response.body();}catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");

        } catch (Exception ex) {
            System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
        return null;
    }
    /**
     * Realiza una solicitud GET para obtener todas las transacciones.
     *
     * @return Cuerpo de la respuesta como String, o {@code null} si hubo error de conexión.
     */

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
        }catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");
        } catch (Exception ex) {
        System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
        return null;
    }
     /**
     * Realiza una solicitud GET para obtener transacciones filtradas por estado.
     *
     * @param estado Valor de estado a consultar (ej.: "pendiente", "completado").
     * @return Cuerpo de la respuesta como String, o {@code null} si hubo error de conexión.
     */
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
        }catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");

        } catch (Exception ex) {
        System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
        return null;
    }
        /**
     * Realiza una solicitud GET para obtener transacciones filtradas por tipo.
     *
     * @param tipo Tipo de transacción a consultar (ej.: "alta", "baja").
     * @return Cuerpo de la respuesta como String, o {@code null} si hubo error de conexión.
     */
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
        }catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");

        } catch (Exception ex) {
        System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
        return null;
    }
     /**
     * Realiza una solicitud GET para obtener una transacción por su ID.
     *
     * @param id Identificador único de la transacción.
     * @return Cuerpo de la respuesta como String, o {@code null} si hubo error de conexión.
     */
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
        }catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");

        } catch (Exception ex) {
        System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
        return null;
    }
      /**
     * Realiza una solicitud DELETE para eliminar una transacción por ID.
     *
     * @param id Identificador único de la transacción a eliminar.
     */
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
       }catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");

        } catch (Exception ex) {
        System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
    }
     /**
     * Realiza una solicitud PUT para actualizar el estado de una transacción.
     *
     * @param id ID de la transacción a modificar.
     * @param nuevoEstado Nuevo valor para el campo 'estado'.
     * @return Cuerpo de la respuesta como String, o {@code null} si hubo error de conexión.
     */
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
       }catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");

        } catch (Exception ex) {
        System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
        return null;
}
    /**
     * Realiza una solicitud PUT para actualizar el tipo de una transacción.
     *
     * @param id ID de la transacción a modificar.
     * @param nuevoTipo Nuevo valor para el campo 'tipo'.
     * @return Cuerpo de la respuesta como String, o {@code null} si hubo error de conexión.
     */
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
        }catch (ConnectException ce) {
        System.out.println(" Error: No se pudo conectar al servicio. Verifique que el servicio este levantado.");

        } catch (Exception ex) {
        System.out.println(" Error: No se pudo conectar al servicio.verifique su bade de datos");
}
        return null;
}
}
