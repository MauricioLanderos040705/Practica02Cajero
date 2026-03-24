package service;

import model.Usuario;
import java.util.List;

public class CajeroService {

    private List<Usuario> usuarios;

    public CajeroService(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticar(String pin) {
        for (Usuario u : usuarios) {
            if (u.getPin().equals(pin)) {
                return u;
            }
        }
        return null;
    }

    public double consultarSaldo(Usuario usuario) {
        return usuario.getSaldo();
    }

    public boolean retirar(Usuario usuario, double cantidad) {
        if (cantidad > 0 && cantidad <= usuario.getSaldo()) {
            usuario.setSaldo(usuario.getSaldo() - cantidad);
            return true;
        }
        return false;
    }

    public boolean depositar(Usuario usuario, double cantidad) {
        if (cantidad > 0) {
            usuario.setSaldo(usuario.getSaldo() + cantidad);
            return true;
        }
        return false;
    }
}