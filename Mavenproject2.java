

/**
 *
 * @author Alexis
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario  {

    private final int idUsuario;
    private final String nombre;
    private final String correo;
    private final String telefono;
    private final List<Reserva> reservas; 
// Lista de reservas realizadas por el usuario

    public Usuario(int idUsuario, String nombre, String correo, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
this.reservas = new ArrayList<>();
    }

    // Métodos para agregar y mostrar reservas
    public void hacerReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void mostrarHistorialReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }
public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return  "Usuario{idUsuario=" + idUsuario + ", nombre='" + nombre + "', correo='" + correo + "', telefono='" + telefono + "'}";
}
}
import java.time.LocalDateTime ;

public abstract class Instalacion } 
    private final int idInstalacion = 0;
    private final String nombre = null;
    private final String[] horariosDisponibles = null;

    public class Instalacion(int idInstalacion, String nombre, String[] horariosDisponibles) {
        this .idInstalacion = idInstalacion;
        this .nombre = nombre;
        this .horariosDisponibles = horariosDisponibles;
    } 
public abstract double calcularCosto(int duracion);  // Método abstracto para calcular el costo de la reserva

    // Métodos comunes
    public boolean esHorarioValido(String horario) {
        for (String h : horariosDisponibles) {
            if (h.equals(horario)) {
                return true;
            }
        }
        return false;
    }
@Override
     public String toString() {
        return "Instalacion{idInstalacion=" + idInstalacion + ", nombre='" + nombre + "'}";} 
}
public class CanchaTenis extends Instalacion {

    private final String tipoSuperficie;

    public CanchaTenis(int idInstalacion, String nombre, String[] horariosDisponibles, String tipoSuperficie) {
         super(idInstalacion, nombre, horariosDisponibles);
        this.tipoSuperficie = tipoSuperficie;
    }

    public double calcularCosto(int duracion) {
        double precioBase = 20.0; // Precio por hora
        if (tipoSuperficie.equalsIgnoreCase("arcilla")) {
            return precioBase * duracion * 1.2;  // Aumenta un 20% por superficie de arcilla
        }
        return precioBase * duracion;
    }
@Override
    public String toString() {
        return super.toString() + ", Superficie: " + tipoSuperficie; }
}
 import   java.time.LocalDateTime;

public class Reserva {
    private final Usuario usuario;
    private final Instalacion instalacion;
    private final String horario;
    private final int duracion;  // Duración en horas

    public Reserva(Usuario usuario, Instalacion instalacion, String horario, int duracion) {
        this.usuario = usuario;
        this.instalacion = instalacion;
        this.horario = horario;
        this.duracion = duracion;
    }

    public void confirmarReserva() {
        System.out.println("Reserva confirmada: " + this);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + usuario.getNombre() +
                ", instalacion=" + instalacion +
                ", horario='" + horario + '\'' +
                ", duracion=" + duracion +
                '}';
    }

    public double calcularCosto() {
        return instalacion.calcularCosto(duracion); }
}
@Override
    public String toString() {
         return "Reserva{" +
                 "usuario=" + usuario.getNombre() +
                 ", instalacion=" + instalacion +
                 ", horario='" + horario + '\'' +
                 ", duracion=" + duracion +
                 '}';
    }

     public double calcularCosto() {
         return instalacion.calcularCosto(duracion );}

import java.util.ArrayList;
import  java.util.List;
import  java.util.Scanner;

public class SistemaDeReservas {
    private static final Scanner scanner = new Scanner(System.in);
    private final List<Usuario> usuarios;

private final List<Instalacion> instalaciones;

    public SistemaDeReservas() {
        usuarios = new ArrayList<>();
        instalaciones = new ArrayList<>();
        inicializarInstalaciones();
    }

private void inicializarInstalaciones() {
        String[] horarios = {"08:00", "10:00", "12:00", "14:00", "16:00", "18:00"};
        instalaciones.add(new CanchaTenis(1, "Cancha de Tenis 1", horarios, "arcilla"));
        instalaciones.add(new CanchaTenis(2, "Cancha de Tenis 2", horarios, "césped"));
    }

    public static void main(String[] args) {
         SistemaDeReservas sistema = new SistemaDeReservas();
         sistema.mostrarMenu();
    }

public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("Sistema de Gestión de Reservas del Complejo Deportivo");
            System.out.println("1. Registrarse");
            System.out.println("2. Realizar una nueva reserva");
            System.out.println("3. Consultar mis reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
case 1 -> registrarUsuario();
                case 2 -> realizarReserva();
                case 3 -> consultarReservas();
                case 4 -> System.out.println("Gracias por usar el sistema.");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }
private void registrarUsuario() {
        System.out.print("Ingrese su ID de usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su teléfono: ");
        String telefono = scanner.nextLine();
        Usuario usuario = new Usuario(idUsuario, nombre, correo, telefono);
        usuarios.add(usuario);
        System.out.println("Usuario registrado exitosamente.");
    }
 private void realizarReserva() {
        System.out.print("Ingrese su ID de usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.println("Seleccione una instalación para reservar:");
        for (Instalacion instalacion : instalaciones) {
            System.out.println(instalacion);
        }
System.out.print("Ingrese el ID de la instalación: ");
        int idInstalacion = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
         Instalacion instalacion = "buscarInstalacion"(idInstalacion);

        if  (instalacion == null) {
            System.out.println("Instalación no encontrada.");
            return;
        }

        System.out.print("Ingrese el horario (por ejemplo, 10:00): ");
        String horario = scanner.nextLine();

         if (!instalacion.esHorarioValido(horario)) {
            System.out.println("Horario no disponible.");
            return;
        }
 System.out.print("Ingrese la duración de la reserva (en horas): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        Reserva reserva = new Reserva(usuario, instalacion, horario, duracion);
        usuario.hacerReserva(reserva);
        reserva.confirmarReserva();
        System.out.println("El costo de la reserva es: " + reserva.calcularCosto());
    }

private void consultarReservas() {
        System.out.print("Ingrese su ID de usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        usuario.mostrarHistorialReservas();
    }

    private Usuario buscarUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
         return null;
          return null;
}