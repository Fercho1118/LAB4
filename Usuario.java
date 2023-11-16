/**
 * Clase Usuario
 * Fernando Rueda - 23748
 * Descripción: Esta clase representa un usuario genérico en el sistema. Contiene información básica del usuario, como nombre, nombre de usuario y contraseña.
 * Fecha de creación: [11/11/2023]
 * Fecha de última modificación: [14/11/2023]
 */
public class Usuario {
    protected String nombre;
    protected String nombreUsuario;
    protected String contrasenia;

    /**
     * Constructor para crear un nuevo objeto Usuario.
     *
     * @param nombre        El nombre completo del usuario.
     * @param nombreUsuario El nombre de usuario elegido por el usuario.
     * @param contrasenia   La contraseña del usuario.
     */
    public Usuario(String nombre, String nombreUsuario, String contrasenia) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Establece el nombre de usuario del usuario.
     *
     * @param nombreUsuario El nuevo nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el nombre de usuario del usuario.
     *
     * @return El nombre de usuario del usuario.
     */
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    /**
     * Obtiene el nombre completo del usuario.
     *
     * @return El nombre completo del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombre El nuevo nombre completo del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia La nueva contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}

