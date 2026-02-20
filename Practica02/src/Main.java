import model.Usuario;
import view.CajeroView;
import controller.CajeroController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("1234", "Juan", 1000.0));
        usuarios.add(new Usuario("5678", "Maria", 2500.0));

        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(usuarios, view);

        controller.iniciar();
    }
}