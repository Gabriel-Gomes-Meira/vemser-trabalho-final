import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UsuarioController extends Controller {
    private ArrayList<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean findAndAuth(String args[]){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).autenticar(args[0], args[1])) {
                return true;
            }
        }

        return false;
    }

    private boolean verifyIfExists(Usuario usuario){
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
        if(usuario instanceof Usuario && !verifyIfExists((Usuario) usuario)){
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
            System.out.printf("\n" +
                            "%d | Usuário {%s, %s}",
                    i, usuarios.get(i).getNome(),
                    usuarios.get(i).getEmail());
        }
    }

    @Override
    public List collection() {
        return getUsuarios();
    }


    @Override
    public Object showFormCreate() {
        String nome, email, senha;
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n" +
                "###################################\n" +
                "##\tNome: \t\t\t\t\t\t###\n");
        nome = inputScanner.nextLine();

        System.out.print("\n" +
                "###################################\n" +
                "##\tEmail: \t\t\t\t\t\t###\n");
        email = inputScanner.nextLine();

        System.out.print("\n" +
                "###################################\n" +
                "##\tSenha: \t\t\t\t\t\t###\n");
        senha = inputScanner.nextLine();

        return new Usuario(nome, email, senha);
    }

}
