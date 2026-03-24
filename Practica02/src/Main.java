import model.Usuario;
import service.CajeroService;
import controller.CajeroController;
import view.CajeroView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("1234", "Juan", 1000.0));
        usuarios.add(new Usuario("5678", "Maria", 2500.0));

        CajeroService service = new CajeroService(usuarios);
        CajeroController controller = new CajeroController(service);
        CajeroView view = new CajeroView(controller);

        view.iniciar();
    }
}