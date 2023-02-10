import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UsuarioController userControl = new UsuarioController();
        userControl.addUsuario(new Usuario("root", "root@email.com", "0000"));

        while (true) {
            int opcao = Interface.login();

            if (opcao == 1) {
                String credenciais[] = Interface.requerirCredenciais();
                if (userControl.findAndAuth(credenciais)){
                    System.out.println("Logado!");
                    break;
                }
                System.out.println("Não encontramos usuário com esses dados!");

            } else if (opcao == 2) {
                    userControl.addUsuario(Interface.cadastrarUsuario());
            }
        }
    }
}
