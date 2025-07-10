package dev.labintec.frontend.usuario.cliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpResponse;

/**
 * Cliente HTTP para invocar el microservicio Usuarios-api
 * usando DTOs generados (RequestDTO con contraseña,
 * ResponseDTO sin contraseña).  
 * Aquí se implementan las operaciones disponibles en el microservicio usuarios-api:
 *   create         → POST   /api/v1/usuarios  
 *   readAll        → GET    /api/v1/usuarios
 *   readById       → GET    /api/v1/usuarios/{id}
 *   readByUsername → GET    /api/v1/usuarios/username/{username}  
 *   updatePassword → PUT    /api/v1/usuarios/{username}  
 *   delete         → DELETE /api/v1/usuarios/{username}
 * @author Quique
 */
public class ClienteRequestUsuarios {

    private static final String API_URI = "http://localhost:8080/api/v1/usuarios";

    /**
     * CREATE: envía un JSON con los datos del nuevo usuario al microservicio usuarios-api.
     * @param json JSON con los campos del usuario (username, password, etc.)
     * @return cuerpo de la respuesta (por ejemplo, el JSON del usuario creado), o null si falla la llamada
     */
    public static String requestNewUsuario(String json) {
        try {
            //1 Construye (o recupera) el cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();
            //2 Define la URL del endpoint de creación
            URI uri = URI.create(API_URI);
            //3 Prepara el body de la petición con el JSON
            BodyPublisher body = HttpRequest.BodyPublishers.ofString(json);
            //4 Monta el objeto HttpRequest:
            //    - Método POST
            //    - Header Content-Type: application/json
            //    - Body con el JSON serializado
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri).header("Content-Type", "application/json").POST(body).build();
            //5 Envía la petición de forma sincrónica y recibe la respuesta con el body como String
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            //6 Devuelve el payload de la respuesta
            int statusCode = response.statusCode();
            if (statusCode == 201)
                return response.body(); // éxito
            else if (statusCode == 409)
                return "409"; // usuario duplicado
            // Asegura que siempre retorne algo
            return "ERROR_" + statusCode;
        } catch (IOException | InterruptedException ex) {
            //7 En caso de error, retorna null
            System.out.println("Mensaje: " + ex);
            return null;
        }
    }

    /**
     * READ ALL: obtiene todos los usuarios existentes
     * llamando al endpoint GET /api/v1/usuarios
     */
    public static String requestReadAll() {
        try {
            //1 Construye (o recupera) el cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();
            //2 Define la URL del endpoint de lectura de todos los usuarios
            URI uri = URI.create(API_URI);
            //3 Monta el objeto HttpRequest:
            //    - Método GET
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            //4 Envía la petición de forma sincrónica y recibe la respuesta con el body como String
            HttpResponse<String> response = cliente.send(request,HttpResponse.BodyHandlers.ofString());
            //5 Devuelve el cuerpo de la respuesta (JSON con la lista de usuarios)
            return response.body();
        } catch (IOException | InterruptedException ex) {
            //6 En caso de error, retorna null
            System.out.println("Mensaje: " + ex);
            return null;
        }
    }

    /**
     * READ by ID: obtiene un usuario por su ID
     * llamando al endpoint GET /api/v1/usuarios/{id}
     * @param id identificador numérico del usuario
     * @return cuerpo de la respuesta (JSON del usuario) o null si falla
     */
    public static String requestReadById(Long id) {
        try {
            //1 Construye (o recupera) el cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();
            //2 Define la URL del endpoint, inyectando el ID
            URI uri = URI.create(API_URI + id);
            //3 Monta el objeto HttpRequest:
            //    - Método GET
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            //4 Envía la petición de forma sincrónica y recibe la respuesta con el body como String
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            //5 Devuelve el cuerpo de la respuesta (JSON del usuario)
            return response.body();
        } catch (IOException | InterruptedException ex) {
            //6 En caso de error, retorna null
            System.out.println("Mensaje: " + ex);
            return null;
        }
    }

    /**
     * READ by username: obtiene un usuario por su nombre de usuario
     * llamando al endpoint GET /api/v1/usuarios/username/{username}
     * @param username  nombre de usuario único
     * @return cuerpo de la respuesta (JSON del usuario) o null si falla
     */
    public static String requestReadByUsername(String username) {
        try {
            //1 Construye (o recupera) el cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();
            //2 Define la URL del endpoint con el username en la ruta
            URI uri = URI.create(API_URI + "/username/" + username);
            //3 Monta el objeto HttpRequest:
            //    - Método GET
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            //4 Envía la petición de forma sincrónica y recibe la respuesta con el body como String
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            //5 Devuelve el cuerpo de la respuesta (JSON del usuario)
            return response.body();
        } catch (IOException | InterruptedException ex) {
            //6 En caso de error, retorna null
            System.out.println("Mensaje: " + ex);
            return null;
        }
    }

    /**
     * email: actualiza el email de un usuario existente
     * llamando al endpoint PUT /api/v1/usuarios/actualizar-e.
     * @param username nombre de usuario cuyo password se modifica
     * @param newEmail nuevo email
     * @return cuerpo de la respuesta (JSON del usuario actualizado) o null si falla
     */
    public static String requestUpdateEmail(String username, String newEmail) {
        try {
            //1 Construye (o recupera) el cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();
            //2 Define la URL del endpoint con el username en la ruta
            URI uri = URI.create(API_URI + "/actualizar-e");
            //3 Crea el JSON con el nuevo email
            String json = "{\"username\":\"" + username + "\", \"email\":\"" + newEmail + "\"}";
            //4 Prepara el body de la petición con el JSON
            BodyPublisher body = HttpRequest.BodyPublishers.ofString(json);
            //5 Monta el HttpRequest:
            //    - Método PUT
            //    - Header Content-Type: application/json
            //    - Body con el JSON
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri).header("Content-Type", "application/json")
                    .PUT(body).build();
            //6 Envía la petición sincrónica y recibe la respuesta
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            //7 Devuelve el payload de la respuesta
            return response.body();
        } catch (IOException | InterruptedException ex) {
            //8 En caso de error, retorna null
            System.out.println("Mensaje: " + ex);
            return null;
        }
    }

    /**
     * DELETE: elimina un usuario por su nombre de usuario
     * llamando al endpoint DELETE /api/v1/usuarios/{username}
     * @param username nombre de usuario a eliminar
     * @return true si se eliminó correctamente; false si ocurrió un error
     */
    public static boolean requestDeleteUsuario(String username) {
        try {
            //1 Construye (o recupera) el cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();
            //2 Define la URL del endpoint con el username en la ruta
            URI uri = URI.create(API_URI + "/eliminar/" + username);
            //3 Monta el objeto HttpRequest:
            //    - Método DELETE
            HttpRequest request = HttpRequest.newBuilder().uri(uri).DELETE().build();
            //4 Envía la petición de forma sincrónica y obtiene el status code
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();
            //5 Devuelve true si fue 202 Accepted o 204 No Content
            return status == 202 || status == 204;
        } catch (IOException | InterruptedException ex) {
            //6 En caso de error, retorna false
            System.out.println("Mensaje: " + ex);
            return false;
        }
    }
}