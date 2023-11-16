/**
 * Clase Cliente
 * Fernando Rueda - 23748
 * Descripción: Esta clase representa un cliente en el sistema de reserva de vuelos.
 * Fecha de creación: [11/11/2023]
 * Fecha de última modificación: [15/11/2023]
 */
public class Cliente extends Usuario {
    private String fechaVuelo;
    private String tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private boolean esPremium;
    private boolean descuentoAplicado;
    private String detallesReserva;
    private String numeroAsiento;
    private int cantidadMaletas;

    /**
     * Construye un nuevo objeto Cliente con el nombre, nombre de usuario y contraseña especificados.
     *
     * @param nombre        El nombre del cliente.
     * @param nombreUsuario El nombre de usuario del cliente.
     * @param contrasenia   La contraseña del cliente.
     */
    public Cliente(String nombre, String nombreUsuario, String contrasenia) {
        super(nombre, nombreUsuario, contrasenia);
    }
    /**
     * Establece la fecha del vuelo para la reserva.
     *
     * @param fecha La fecha del vuelo en formato AAAA-MM-DD.
     * @return La fecha del vuelo establecida.
     */
    public String fechaVuelo(String fecha) {
        this.fechaVuelo = fecha;
        return this.fechaVuelo;
    }

    /**
     * Establece el tipo de vuelo (ida y vuelta o solo ida).
     *
     * @param tipo El tipo de vuelo, que puede ser "ida y vuelta" o "solo ida".
     * @return El tipo de vuelo establecido.
     */    
    public String tipoVuelo(String tipo) {
        this.tipoVuelo = tipo;
        return this.tipoVuelo;
    }

    /**
     * Establece la cantidad de boletos para el vuelo.
     *
     * @param cantidad La cantidad de boletos.
     */
    public void setCantidadBoletos(int cantidad) {
        this.cantidadBoletos = cantidad;
    }

    /**
     * Obtiene la cantidad de boletos para el vuelo.
     *
     * @return La cantidad de boletos.
     */    
    public int getCantidadBoletos() {
        return this.cantidadBoletos;
    }

    /**
     * Establece la aerolínea para el vuelo.
     *
     * @param aerolinea El nombre de la aerolínea.
     * @return El nombre de la aerolínea establecido.
     */
    public String aerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
        return this.aerolinea;
    }

    /**
     * Establece el nombre de usuario del cliente.
     *
     * @param username El nuevo nombre de usuario.
     * @return El nuevo nombre de usuario establecido.
     */
    public String username(String username) {
        setNombreUsuario(username);
        return getNombreUsuario();
    }

    /**
     * Establece el número de tarjeta de crédito para la reserva.
     *
     * @param numero El número de tarjeta de crédito.
     * @return El número de tarjeta de crédito establecido.
     */
    public String numeroTarjeta(String numero) {
        this.numeroTarjeta = numero;
        return this.numeroTarjeta;
    }

    /**
     * Establece el número de cuotas para el pago.
     *
     * @param cuotas El número de cuotas.
     * @return El número de cuotas establecido.
     */    
    public int cuotas(int cuotas) {
        this.cuotas = cuotas;
        return this.cuotas;
    }

    /**
     * Establece la clase de vuelo (Económica o Premium).
     *
     * @param clase La clase de vuelo.
     * @return La clase de vuelo establecida.
     */
    public String claseVuelo(String clase) {
        this.claseVuelo = clase;
        return this.claseVuelo;
    }
    
    /**
     * Verifica si el cliente tiene privilegios premium.
     *
     * @return Verdadero si el cliente es premium, de lo contrario, falso.
     */
    public boolean esPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public boolean getDescuentoAplicado() {
        return descuentoAplicado;
    }

    /**
     * Establece si se ha aplicado un descuento a la reserva.
     *
     * @param descuentoAplicado Verdadero si se ha aplicado un descuento, de lo contrario, falso.
     */
    public void setDescuentoAplicado(boolean descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    /**
     * Obtiene los detalles de la reserva.
     *
     * @return Los detalles de la reserva.
     */
    public String getDetallesReserva() {
        return detallesReserva;
    }

    /**
     * Establece los detalles de la reserva, incluyendo la fecha del vuelo, el tipo de vuelo,
     * la cantidad de boletos y la aerolínea.
     *
     * @param fechaVuelo     La fecha del vuelo.
     * @param tipoVuelo      El tipo de vuelo.
     * @param cantidadBoletos La cantidad de boletos.
     * @param aerolinea      La aerolínea.
     */
    public void setDetallesReserva(String fechaVuelo, String tipoVuelo, int cantidadBoletos, String aerolinea) {
        this.detallesReserva = fechaVuelo + "," + tipoVuelo + "," + cantidadBoletos + "," + aerolinea;
    }
    /**
     * Obtiene el número de tarjeta de crédito.
     *
     * @return El número de tarjeta de crédito.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de tarjeta de crédito.
     *
     * @param numeroTarjeta El número de tarjeta de crédito.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

     /**
     * Obtiene el número de cuotas para el pago.
     *
     * @return El número de cuotas.
     */   
    public int getCuotas() {
        return cuotas;
    }

    /**
     * Establece el número de cuotas para el pago.
     *
     * @param cuotas El número de cuotas.
     */
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * Obtiene la clase de vuelo (Económica o Premium).
     *
     * @return La clase de vuelo.
     */
    public String getClaseVuelo() {
        return claseVuelo;
    }

    /**
     * Establece la clase de vuelo (Económica o Premium).
     *
     * @param claseVuelo La clase de vuelo.
     */
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    /**
     * Obtiene la fecha del vuelo.
     *
     * @return La fecha del vuelo.
     */
    public String getFechaVuelo() {
        return fechaVuelo;
    }

    /**
     * Obtiene el tipo de vuelo (ida y vuelta o solo ida).
     *
     * @return El tipo de vuelo.
     */
    public String getTipoVuelo() {
        return tipoVuelo;
    }

    /**
     * Obtiene el nombre de la aerolínea.
     *
     * @return El nombre de la aerolínea.
     */
    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * Obtiene el número de asiento asignado para la reserva.
     *
     * @return El número de asiento.
     */
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    /**
     * Establece el número de asiento asignado para la reserva.
     *
     * @param numeroAsiento El número de asiento.
     */
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Obtiene la cantidad de maletas para el vuelo.
     *
     * @return La cantidad de maletas.
     */
    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    /**
     * Establece la cantidad de maletas para el vuelo.
     *
     * @param cantidadMaletas La cantidad de maletas.
     */
    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }
}





