package controller;

import model.Usuario;
import view.CajeroView;

import java.util.List;

public class CajeroController {

    private List<Usuario> usuarios;
    private CajeroView view;

    public CajeroController(List<Usuario> usuarios, CajeroView view) {
        this.usuarios = usuarios;
        this.view = view;
    }

    public void iniciar() {
        Usuario usuarioActual = autenticar();

        if (usuarioActual == null) {
            view.mostrarMensaje("Demasiados intentos fallidos. Adiós.");
            return;
        }

        view.mostrarMensaje("Bienvenido, " + usuarioActual.getNombre());

        boolean salir = false;

        while (!salir) {
            int opcion = view.mostrarMenu();

            switch (opcion) {
                case 1:
                    view.mostrarMensaje("Saldo actual: $" + usuarioActual.getSaldo());
                    break;

                case 2:
                    double retiro = view.pedirCantidad("Cantidad a retirar: ");
                    if (usuarioActual.retirar(retiro)) {
                        view.mostrarMensaje("Retiro exitoso.");
                    } else {
                        view.mostrarMensaje("Fondos insuficientes.");
                    }
                    break;

                case 3:
                    double deposito = view.pedirCantidad("Cantidad a depositar: ");
                    usuarioActual.depositar(deposito);
                    view.mostrarMensaje("Depósito exitoso.");
                    break;

                case 4:
                    salir = true;
                    view.mostrarMensaje("Gracias por usar el cajero.");
                    break;

                default:
                    view.mostrarMensaje("Opción inválida.");
            }
        }
    }

    private Usuario autenticar() {
        int intentos = 0;

        while (intentos < 3) {
            String pin = view.pedirPin();

            for (Usuario u : usuarios) {
                if (u.getPin().equals(pin)) {
                    return u;
                }
            }

            view.mostrarMensaje("PIN incorrecto.");
            intentos++;
        }
        return null;
    }
}