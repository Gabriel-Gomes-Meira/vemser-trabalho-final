import java.util.ArrayList;

public class UsuarioController {
    private ArrayList<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public boolean findAndAuth(String args[]){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).autenticar(args[0], args[1])) {
                return true;
            }
        }

        return false;
    }

    public void addUsuario (Usuario user) {
        usuarios.add(user);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
