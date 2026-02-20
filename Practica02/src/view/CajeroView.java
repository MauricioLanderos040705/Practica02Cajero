package view;

import java.util.Scanner;

public class CajeroView {
    private Scanner scanner;

    public CajeroView() {
        scanner = new Scanner(System.in);
    }

    public String pedirPin() {
        System.out.print("Ingrese su PIN: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int mostrarMenu() {
        System.out.println("\n1. Ver saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public double pedirCantidad(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }
}