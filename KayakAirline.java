/**
 * Clase KayakAriline
 * Fernando Rueda - 23748
 * Descripción: Esta clase representa el sistema de reservas de vuelos de Kayak Airlines.
 * Fecha de creación: [11/11/2023]
 * Fecha de última modificación: [15/11/2023]
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class KayakAirline {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Cliente clienteActual = null;

    /**
     * El método principal del programa que inicia el sistema de reservas de Kayak Airlines.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        cargarClientes();
        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    ingresar();
                    break;
                case 3:
                    realizarReserva();
                    break;
                case 4:
                    confirmarReserva();
                    break;
                case 5:
                    modificarPerfil();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Gracias por utilizar el sistema de Kayak.");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    /**
     * Muestra el menú principal del sistema.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\nBienvenido al Sistema de Reservas Kayak");
        System.out.println("1. Registrarse");
        System.out.println("2. Ingresar");
        System.out.println("3. Reservar Vuelo");
        System.out.println("4. Confirmar Reserva");
        System.out.println("5. Modificar Perfil");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Registra un nuevo usuario en el sistema.
     */
    private static void registrarUsuario() {
        System.out.println("\nRegistro de Nuevo Usuario");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasenia = scanner.nextLine();
    
        System.out.println("Seleccione el plan:");
        System.out.println("1. Gratis");
        System.out.println("2. VIP");
        System.out.print("Ingrese el número correspondiente al plan (1/2): ");
        int plan = Integer.parseInt(scanner.nextLine());
    
        Cliente nuevoCliente = new Cliente(nombre, nombreUsuario, contrasenia);
        
        if (plan == 2) {
            nuevoCliente.setEsPremium(true);
        }
    
        clientes.add(nuevoCliente);
        System.out.println("Usuario registrado con éxito.\n");
        guardarClientes();
    }
    
    /**
     * Permite a un usuario ingresar al sistema.
     */
    private static void ingresar() {
        System.out.println("\nIngreso al Sistema");
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasenia = scanner.nextLine();

        for (Cliente c : clientes) {
            if (c.getNombreUsuario().equals(nombreUsuario) && c.getContrasenia().equals(contrasenia)) {
                clienteActual = c;
                System.out.println("Ingreso exitoso. Bienvenido " + c.getNombre() + ".\n");
                return;
            }
        }
        System.out.println("Nombre de usuario o contraseña incorrectos.\n");
    }
    
    /**
     * Carga los datos de los clientes desde un archivo.
     */
    private static void cargarClientes() {
        File archivo = new File("usuarios.csv");
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    Cliente cliente = new Cliente(datos[0], datos[1], datos[2]);
                    clientes.add(cliente);
                }
            } catch (IOException e) {
                System.out.println("Error al cargar los datos de los clientes: " + e.getMessage());
            }
        }
    }

    /**
     * Guarda los datos de los clientes en un archivo.
     */
    private static void guardarClientes() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("usuarios.csv"))) {
            for (Cliente cliente : clientes) {
                pw.println(cliente.getNombre() + "," + cliente.getNombreUsuario() + "," + cliente.getContrasenia());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de los clientes: " + e.getMessage());
        }
    }

   /**
     * Guarda los detalles de la reserva de un cliente en un archivo.
     *
     * @param cliente El cliente cuya reserva se va a guardar.
     */
    private static void guardarReserva(Cliente cliente) {
        File archivo = new File("reservas.csv");
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            String reserva = String.join(",",
                cliente.getNombreUsuario(),
                cliente.getFechaVuelo(),
                cliente.getTipoVuelo(),
                String.valueOf(cliente.getCantidadBoletos()),
                cliente.getAerolinea(),
                cliente.getNumeroTarjeta(),
                String.valueOf(cliente.getCuotas()),
                cliente.getClaseVuelo(),
                cliente.getNumeroAsiento(),
                String.valueOf(cliente.getCantidadMaletas())
            );
            out.println(reserva);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la reserva: " + e.getMessage());
        }
    }
    
    /**
     * Modifica el perfil del cliente actual.
     */
    private static void modificarPerfil() {
        if (clienteActual == null) {
            System.out.println("Debe ingresar al sistema primero.");
            return;
        }

        System.out.print("Ingrese su nuevo nombre (deje en blanco para no cambiarlo): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            clienteActual.setNombre(nuevoNombre);
        }

        System.out.print("Ingrese su nueva contraseña (deje en blanco para no cambiarla): ");
        String nuevaContrasenia = scanner.nextLine();
        if (!nuevaContrasenia.isEmpty()) {
            clienteActual.setContrasenia(nuevaContrasenia);
        }

        System.out.println("Perfil actualizado con éxito.\n");
        guardarClientes();
    }

    /**
     * Realiza una reserva de vuelo para el cliente actual.
     */
    private static void realizarReserva() {
        if (clienteActual == null) {
            System.out.println("Debe ingresar al sistema primero.");
            return;
        }

        System.out.println("\n---- Reserva de Vuelo ----");
        clienteActual.fechaVuelo(solicitarInput("Ingrese la fecha de su vuelo (YYYY-MM-DD): "));
        clienteActual.tipoVuelo(solicitarInput("¿Es un vuelo de ida y vuelta? (si/no): "));
        clienteActual.setCantidadBoletos(Integer.parseInt(solicitarInput("Ingrese la cantidad de boletos: ")));
        clienteActual.aerolinea(solicitarInput("Ingrese la aerolínea: "));
        
        System.out.println("Reserva realizada con éxito. Por favor proceda a la confirmación.");
    }

    /**
     * Confirma una reserva de vuelo para el cliente actual.
     */
    private static void confirmarReserva() {
        if (clienteActual == null) {
            System.out.println("Debe ingresar al sistema primero.");
            return;
        }
    
        System.out.println("\nConfirmar Reserva");
        try {
            System.out.print("Ingrese el número de tarjeta de crédito: ");
            String numeroTarjeta = scanner.nextLine();
            System.out.print("Ingrese la cantidad de cuotas (1 para pago único): ");
            int cuotas = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese la clase del vuelo (Económica/Premium): ");
            String claseVuelo = scanner.nextLine();
    
            clienteActual.setNumeroTarjeta(numeroTarjeta);
            clienteActual.setCuotas(cuotas);
            clienteActual.setClaseVuelo(claseVuelo);
    
            if (clienteActual.esPremium()) {
                System.out.println("Plan VIP seleccionado.");
                System.out.println("Opciones premium disponibles:");
                System.out.println("1. Seleccionar número de asiento (Premium)");
                System.out.println("2. Definir cantidad de maletas (Premium)");
                System.out.print("Seleccione una opción premium (1/2) o cualquier otra tecla para continuar: ");
                String opcionPremium = scanner.nextLine();
                if (opcionPremium.equals("1")) {
                    seleccionarNumeroAsientoPremium();
                } else if (opcionPremium.equals("2")) {
                    definirCantidadMaletasPremium();
                } else {
                    System.out.println("Opción no válida.");
                }
            }
    
            guardarReserva(clienteActual);
    
            System.out.println("Reserva confirmada para " + clienteActual.getNombre() + ".");
    
        } catch (NumberFormatException e) {
            System.out.println("Error en la entrada. Por favor, ingrese un número válido para las cuotas.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al confirmar la reserva: " + e.getMessage());
        }
    }

    /**
     * Permite al cliente seleccionar un número de asiento premium.
     */  
    private static void seleccionarNumeroAsientoPremium() {
        if (clienteActual == null) {
            System.out.println("Debe ingresar al sistema primero.");
            return;
        }

        if (!clienteActual.esPremium()) {
            System.out.println("Esta función está disponible solo para usuarios premium.");
            return;
        }

        System.out.print("Ingrese el número de asiento premium deseado: ");
        String numeroAsiento = scanner.nextLine();
        clienteActual.setNumeroAsiento(numeroAsiento);
        System.out.println("Número de asiento premium seleccionado con éxito.");
    }

    /**
     * Permite al cliente definir la cantidad de maletas premium.
     */
    private static void definirCantidadMaletasPremium() {
        if (clienteActual == null) {
            System.out.println("Debe ingresar al sistema primero.");
            return;
        }

        if (!clienteActual.esPremium()) {
            System.out.println("Esta función está disponible solo para usuarios premium.");
            return;
        }

        System.out.print("Ingrese la cantidad de maletas premium que llevará: ");
        int cantidadMaletas = Integer.parseInt(scanner.nextLine());
        clienteActual.setCantidadMaletas(cantidadMaletas);
        System.out.println("Cantidad de maletas premium definida con éxito.");
    }    

    /**
     * Solicita una entrada al usuario y devuelve la entrada como una cadena.
     *
     * @param mensaje El mensaje a mostrar al usuario.
     * @return La entrada del usuario como una cadena.
     */
    private static String solicitarInput(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}



