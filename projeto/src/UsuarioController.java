import java.util.ArrayList;
import java.util.Objects;

public class UsuarioController implements Controller {
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

    private boolean userExists(Usuario usuario){
        for (int i = 0; i < usuarios.size(); i++) {
            if(Objects.equals(usuarios.get(i).getEmail(), usuario.getEmail())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }


    @Override
    public boolean create(Object usuario) {
        if(usuario instanceof Usuario && !userExists((Usuario) usuario)){
        usuarios.add((Usuario) usuario);
        return true;
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        if(index >= 0 && index < usuarios.size()){
            usuarios.remove(index);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean update(int index, Object usuario) {
        if(index >= 0 && index < usuarios.size()){
            usuarios.set(index, (Usuario) usuario);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void read() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
    }
}
