package com.cajero.menuapp;

import com.cajero.model.domain.*;

import java.util.Scanner;

//Menuapp se encarga de toda la logica y la interacción con el usuario
//Controla los flujos de cada movimiento llamando a metodos de otras clases
public class MenuApp {

    private final Scanner sc;
    private final Banco banco;
    private final Autenticacion autenticacion;

    private Usuario usuarioActual;
    private Cuenta cuentaActual;
    private boolean sesionActiva;

    public MenuApp() {
        this.sc = new Scanner(System.in);
        this.banco = new Banco();
        this.autenticacion = new Autenticacion();
        this.sesionActiva = false;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // PUNTO DE ENTRADA
    // ─────────────────────────────────────────────────────────────────────────

    //Inicia la app y con el ciclo la mantiene activa
    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            mostrarMenuPrincipal();
            int opcion = leerEntero();

            switch (opcion) {
                case 1 -> flujoIniciarSesion();
                case 2 -> flujoRegistrarse();
                case 0 -> {
                    System.out.println("¡Hasta luego!");
                    ejecutando = false;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }

    // FLUJOS PRINCIPALES

    //Flujo de registro de Usuario
    private void flujoRegistrarse() {

    }

    //Flujo de inicio de Sesión
    private void flujoIniciarSesion() {
    }

    //Menu de inicio de sesion mientras la sesion este activa
    private void menuSesion() {
        boolean enSesion = true;
        while (enSesion) {
            mostrarMenuSesion();
            int opcion = leerEntero();

            switch (opcion) {
                case 1 -> flujoConsignar();
                case 2 -> flujoRetirar();
                case 3 -> flujoTransferir();
                case 4 -> flujoConsultarMovimientos();
                case 0 -> {
                    System.out.println("Sesión cerrada. Hasta luego, " + usuarioActual.getNombre() + ".");
                    cerrarSesion();
                    enSesion = false;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }


    // FLUJOS DE TRANSACCIONES


    //Flujo para consignar la cuenta
    private void flujoConsignar() {

    }

    //Flujo para retirar dinero de la cuenta
    private void flujoRetirar() {

    }

    //Flujo para transferir dinero a otra cuenta
    private void flujoTransferir() {

    }

    //Flujo para consultar movimientos
    private void flujoConsultarMovimientos() {

    }

    // ─────────────────────────────────────────────────────────────────────────
    // MENÚS (VISTAS)
    // ─────────────────────────────────────────────────────────────────────────

    private void mostrarMenuPrincipal() {
        System.out.println("\n╔══════════════════════╗");
        System.out.println("║      MI PLATA        ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("║  1. Iniciar sesión   ║");
        System.out.println("║  2. Registrarse      ║");
        System.out.println("║  0. Salir            ║");
        System.out.println("╚══════════════════════╝");
        System.out.print("Seleccione: ");
    }

    private void mostrarMenuSesion() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║  Saldo: $" + String.format("%-20.2f", cuentaActual.getSaldo()) + "║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║  1. Consignar                ║");
        System.out.println("║  2. Retirar                  ║");
        System.out.println("║  3. Transferir               ║");
        System.out.println("║  4. Ver movimientos          ║");
        System.out.println("║  0. Cerrar sesión            ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Seleccione: ");
    }


    // UTILIDADES

    private void cerrarSesion() {
        sesionActiva = false;
        usuarioActual = null;
        cuentaActual = null;
    }

    //lee un entero de manera segura en la consola
    private int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Por favor ingrese un número válido: ");
            }
        }
    }

    //lee un double de manera segura en la consola
    private double leerDouble() {
        while (true) {
            try {
                double valor = Double.parseDouble(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Por favor ingrese un monto válido: ");
            }
        }
    }
}
