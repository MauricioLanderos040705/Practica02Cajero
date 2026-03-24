package controller;

import model.Usuario;
import service.CajeroService;

public class CajeroController {

    private CajeroService service;

    public CajeroController(CajeroService service) {
        this.service = service;
    }

    public Usuario autenticar(String pin) {
        return service.autenticar(pin);
    }

    public double consultarSaldo(Usuario usuario) {
        return service.consultarSaldo(usuario);
    }

    public boolean retirar(Usuario usuario, double cantidad) {
        return service.retirar(usuario, cantidad);
    }

    public boolean depositar(Usuario usuario, double cantidad) {
        return service.depositar(usuario, cantidad);
    }
}