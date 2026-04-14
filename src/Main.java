import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            mostrarMenu();
            option = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (option) {
                case 1:
                    registrarCamion();
                    break;
                case 2:
                    registrarFurgon();
                    break;
                case 3:
                    registrarMoto();
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    mostrarDisponibles();
                    break;
                case 6:
                    marcarNoDisponible();
                    break;
                case 7:
                    mostrarReporte();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opción inválida.");
            }

        } while (option != 8);
        sc.close();
    }
    public static void mostrarMenu(){
        System.out.println("=== SISTEMA DE VEHÍCULOS DE REPARTO ===\n" +
                "1. Registrar camión\n" +
                "2. Registrar furgón\n" +
                "3. Registrar moto de reparto\n" +
                "4. Mostrar todos los vehículos\n" +
                "5. Mostrar vehículos disponibles\n" +
                "6. Marcar vehículo como no disponible\n" +
                "7. Mostrar reporte general\n" +
                "8. Salir");
    }

    // === Helpers ===

    static boolean patenteDuplicada(String patente){
        for (Vehiculo v : vehiculos){
            if (v.getPatente().equalsIgnoreCase(patente))
                return true;
        }
        return false;
    }

    // Pide un String y valida que no esté vacío
    static String pedirTexto(String mensaje) {
        String valor;
        do {
            System.out.print(mensaje);
            valor = sc.nextLine().trim();
            if (valor.isEmpty()) System.out.println(" No puede estar vacío.");
        } while (valor.isEmpty());
        return valor;
    }

    // Pide un double y valida que sea positivo
    static double pedirPositivo(String mensaje) {
        double valor = -1;
        do {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(sc.nextLine());
                if (valor < 0) System.out.println(" No puede ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println(" Ingresá un número válido.");
            }
        } while (valor < 0);
        return valor;
    }

    // Pide la patente validando vacío y duplicados
    static String pedirPatente() {
        String patente;
        do {
            patente = pedirTexto("Patente: ");
            if (patenteDuplicada(patente)) {
                System.out.println(" Esa patente ya está registrada.");
                patente = "";
            }
        } while (patente.isEmpty());
        return patente;
    }

    // === opciones ====
    static void registrarFurgon() {
        System.out.println("\n--- Registrar Furgón ---");
        String patente   = pedirPatente();
        String marca     = pedirTexto("Marca: ");
        String modelo    = pedirTexto("Modelo: ");
        double capacidad = pedirPositivo("Capacidad de carga (kg): ");
        double volumen   = pedirPositivo("Volumen interior (m³): ");

        vehiculos.add(new Furgon(patente, marca, modelo, capacidad, true, volumen));
        System.out.println("✅ Furgón registrado.");
    }

    static void registrarCamion() {
        System.out.println("\n--- Registrar Camión ---");
        String patente   = pedirPatente();
        String marca     = pedirTexto("Marca: ");
        String modelo    = pedirTexto("Modelo: ");
        double capacidad = pedirPositivo("Capacidad de carga (kg): ");
        int ejes = -1;

        do {
            System.out.print("Número de ejes: ");
            try {
                ejes = Integer.parseInt(sc.nextLine()); // ← sc
                if (ejes <= 0) { System.out.println(" Debe ser mayor a 0."); ejes = -1; }
            } catch (NumberFormatException e) { System.out.println(" Número inválido."); ejes = -1; }
        } while (ejes <= 0);

        vehiculos.add(new Camion(patente, marca, modelo, capacidad, true, ejes)); // ← true
        System.out.println("✅ Camión registrado.");
    }
    static void registrarMoto() {
        System.out.println("\n--- Registrar Moto de Reparto ---");
        String patente   = pedirPatente();
        String marca     = pedirTexto("Marca: ");
        String modelo    = pedirTexto("Modelo: ");
        double capacidad = pedirPositivo("Capacidad de carga (kg): ");

        System.out.print("¿Tiene caja térmica? (s/n): ");
        boolean cajaTermica = sc.nextLine().trim().equalsIgnoreCase("s");

        vehiculos.add(new MotoReparto(patente, marca, modelo, capacidad, true, cajaTermica));
        System.out.println("✅ Moto registrada.");
    }

    static void mostrarTodos() {
        System.out.println("\n--- Todos los Vehículos ---");

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (Vehiculo v : vehiculos) {
            v.mostrarDetalle(); // polimorfismo en acción
        }
    }

    static void mostrarDisponibles() {
        System.out.println("\n--- Vehículos Disponibles ---");

        boolean hayAlguno = false;

        for (Vehiculo v : vehiculos) {
            if (v.isDisponible()) {
                v.mostrarDetalle();
                hayAlguno = true;
            }
        }

        if (!hayAlguno) {
            System.out.println("No hay vehículos disponibles.");
        }
    }
    static void marcarNoDisponible() {
        System.out.println("\n--- Marcar como No Disponible ---");
        String patente = pedirTexto("Ingresá la patente: ");
        boolean encontrado = false;

        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                v.setDisponible(false);
                System.out.println(" Vehículo marcado como no disponible.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(" No se encontró ningún vehículo con esa patente.");
        }
    }

    static void mostrarReporte() {
        System.out.println("\n===== REPORTE GENERAL =====");
        int camiones = 0, furgones = 0, motos = 0, disponibles = 0, noDisponibles = 0;

        for (Vehiculo v : vehiculos) {
            if (v instanceof Camion)      camiones++;
            if (v instanceof Furgon)      furgones++;
            if (v instanceof MotoReparto) motos++;
            if (v.isDisponible())         disponibles++;
            else                          noDisponibles++;
        }

        System.out.println("Total vehículos  : " + vehiculos.size());
        System.out.println("Camiones         : " + camiones);
        System.out.println("Furgones         : " + furgones);
        System.out.println("Motos de reparto : " + motos);
        System.out.println("Disponibles      : " + disponibles);
        System.out.println("No disponibles   : " + noDisponibles);

        System.out.println("\nPatente   | Tipo          | Marca  | Modelo | Disponible");
        System.out.println("----------|---------------|--------|--------|----------");
        for (Vehiculo v : vehiculos) {
            String tipo = v instanceof Camion ? "Camión" : v instanceof Furgon ? "Furgón" : "Moto";
            System.out.printf("%-10s| %-14s| %-7s| %-7s| %s%n",
                    v.getPatente(), tipo, v.getMarca(), v.getModelo(),
                    v.isDisponible() ? "Sí" : "No");
        }
    }



}