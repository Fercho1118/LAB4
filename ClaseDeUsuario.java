/**
 * Interfaz ClaseDeUsuario
 * Fernando Rueda - 23748
 * Descripción: Esta interfaz define los métodos que deben implementar las clases de usuarios en el sistema.
 * Fecha de creación: [11/11/2023]
 * Fecha de última modificación: [11/11/2023]
 */

public interface ClaseDeUsuario {
    /**
     * Establece la fecha del vuelo.
     *
     * @param fechaVuelo La fecha del vuelo en formato YYYY-MM-DD.
     * @return La fecha del vuelo establecida.
     */
    String fechaVuelo(String fechaVuelo);

    /**
     * Establece el tipo de vuelo (ida y vuelta o solo ida).
     *
     * @param tipoVuelo El tipo de vuelo, que puede ser "ida" o "ida y vuelta".
     * @return El tipo de vuelo establecido.
     */
    String tipoVuelo(String tipoVuelo);

    /**
     * Establece la cantidad de boletos para el vuelo.
     *
     * @param cantidadBoletos La cantidad de boletos.
     * @return La cantidad de boletos establecida.
     */
    String cantidadBoletos(String cantidadBoletos);

    /**
     * Establece la aerolínea para el vuelo.
     *
     * @param aerolinea El nombre de la aerolínea.
     * @return El nombre de la aerolínea establecido.
     */
    String aerolinea(String aerolinea);

    /**
     * Establece el nombre de usuario del usuario.
     *
     * @param username El nuevo nombre de usuario.
     * @return El nuevo nombre de usuario establecido.
     */
    String username(String username);

    /**
     * Establece el número de tarjeta de crédito para la reserva.
     *
     * @param numeroTarjeta El número de tarjeta de crédito.
     * @return El número de tarjeta de crédito establecido.
     */
    String numeroTarjeta(String numeroTarjeta);

    /**
     * Establece la cantidad de cuotas para el pago.
     *
     * @param cuotas La cantidad de cuotas.
     * @return La cantidad de cuotas establecida.
     */
    int cuotas(int cuotas);

    /**
     * Establece la clase del vuelo (Económica o Premium).
     *
     * @param claseVuelo La clase del vuelo.
     * @return La clase del vuelo establecida.
     */
    String claseVuelo(String claseVuelo);

    /**
     * Establece el número de asiento para la reserva.
     *
     * @param numeroAsiento El número de asiento.
     * @return El número de asiento establecido.
     */
    int numeroAsiento(int numeroAsiento);

    /**
     * Establece la cantidad de maletas para el vuelo.
     *
     * @param cantidadMaletas La cantidad de maletas.
     * @return La cantidad de maletas establecida.
     */
    int cantidadMaletas(int cantidadMaletas);
}
