package dev.labintec.frontend.usuario.cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Data Transfer Object (DTO) que representa la información básica de un usuario.
 * Utilizado para intercambio de datos entre el frontend y los servicios backend.
 * @author Quique
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {
    private Long coduser;
    private String username;
    private String email;

    /**
     * Obtiene el identificador único del usuario.
     * @return Long código del usuario
     */
    public Long getCoduser() {
        return coduser;
    }

    /**
     * Establece el identificador único del usuario.
     * @param coduser código del usuario
     */
    public void setCoduser(Long coduser) {
        this.coduser = coduser;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return String username del usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     * @param username nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return String email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email correo electrónico
     */
    public void setEmail(String email) {
        this.email = email;
    }
}