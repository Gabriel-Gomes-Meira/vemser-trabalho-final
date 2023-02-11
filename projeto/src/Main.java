import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UsuarioController userControl = new UsuarioController();
        userControl.create(new Usuario("aaaaa", "aaaaa@email.com", "#00001"));

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
                    if(userControl.create(Interface.cadastrarUsuario())){
                        System.out.println("Criado");
                    }
            } else if(opcao == 4){
                if(userControl.delete(Interface.requerirIndex())){
                    System.out.println("Deletado");
                }else{
                    System.out.println("Erro");
                }
            } else if (opcao == 5) {
                if(userControl.update(Interface.requerirIndex(), Interface.atualizarUsuario())){
                    System.out.println("Atualizado");
                }
            }
        }
    }
}
