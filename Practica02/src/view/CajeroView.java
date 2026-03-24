package view;

import controller.CajeroController;
import model.Usuario;

import java.util.Scanner;

public class CajeroView {

    private Scanner scanner;
    private CajeroController controller;

    public CajeroView(CajeroController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        Usuario usuarioActual = null;
        int intentos = 0;

        // AUTENTICACIÓN
        while (intentos < 3 && usuarioActual == null) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();

            usuarioActual = controller.autenticar(pin);

            if (usuarioActual == null) {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
        }

        if (usuarioActual == null) {
            System.out.println("Demasiados intentos fallidos. Adiós.");
            return;
        }

        System.out.println("Bienvenido, " + usuarioActual.getNombre());

        boolean salir = false;

        // MENÚ PRINCIPAL
        while (!salir) {

            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    double saldo = controller.consultarSaldo(usuarioActual);
                    System.out.println("Saldo actual: $" + saldo);
                    break;

                case 2:
                    System.out.print("Cantidad a retirar: ");
                    double retiro = scanner.nextDouble();
                    scanner.nextLine();

                    if (controller.retirar(usuarioActual, retiro)) {
                        System.out.println("Retiro exitoso.");
                    } else {
                        System.out.println("Fondos insuficientes.");
                    }
                    break;

                case 3:
                    System.out.print("Cantidad a depositar: ");
                    double deposito = scanner.nextDouble();
                    scanner.nextLine();

                    if (controller.depositar(usuarioActual, deposito)) {
                        System.out.println("Depósito exitoso.");
                    } else {
                        System.out.println("Cantidad inválida.");
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("Gracias por usar el cajero.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}