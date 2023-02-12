import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UsuarioController userController = new UsuarioController();
        LicitacaoController licitacaoController = new LicitacaoController();
        LeilaoController leilaoController = new LeilaoController();
        CompradorController compradorController = new CompradorController();

        compradorController.create(new Comprador("leandro","leandrodeAsis@gmail.com","2184568569", "08956745398", 1));
        userController.create(new Usuario("aaaaa", "aaaaa@email.com", "#00001"));
        licitacaoController.create(new Licitacao("Moto Honda", "114/23", 3200));
        leilaoController.create(new Leilao(licitacaoController.getLicitacoes().get(0),
                        Date.valueOf(LocalDate.of(2024,5,23)),
                        Date.valueOf(LocalDate.of(2024,5,23))));
        leilaoController.getLeiloes().get(0).create(new Proposta(20000, compradorController.getCompradores().get(0)));

//        while (true) {
//            int opcao = Interface.login();
//
//            if (opcao == 1) {
//                String credenciais[] = Interface.requerirCredenciais();
//                if (userController.findAndAuth(credenciais)){
//                    System.out.println("Logado!");
//                    break;
//                }
//                System.out.println("Não encontramos usuário com esses dados!");
//
//            } else if (opcao == 2) {
//                    if(userController.create(Interface.cadastrarUsuario())){
//                        System.out.println("Criado");
//                    }
//            }
//        }
        do {
            int opcao = paginaPrincipal(licitacaoController);
            if(opcao > 0 && opcao <= 4){
                switch (opcao){
                    case 1:
                        crudSemDependencia(userController);
                        continue;
                    case 2:
                        crudSemDependencia(licitacaoController);
                        continue;
                    case 3:
                        crudLeiloes(leilaoController, licitacaoController, compradorController);
                        continue;
                    case 4:
                        crudSemDependencia(compradorController);
                }
            } else {
                break;
            }
        }while (true);
    }

    public static int paginaPrincipal(LicitacaoController licitacaoController) {
        System.out.println("\n" +
                "#################################################################\n" +
                "##\t1 - Usuarios\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t2 - Licitações\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                (licitacaoController.getLicitacoes().size() != 0?"##\t3 - Leilao\t\t\t\t\t\t\t\t\t\t\t\t#####\n":"")+
                "##\t4 - Compradores\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\tPressione qualquer outro número para sair\t\t\t\t#####\n" +
                "#################################################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    public static void crudSemDependencia(Controller controller){
        do {
            int opcao = controller.showOptions();
            if(opcao > 0 && opcao <= 4){
                switch (opcao){
                    case 1:
                        controller.read();
                        continue;
                    case 2:
                        controller.create(controller.showFormCreate());
                        continue;
                    case 3:
                        controller.showFormUpdate();
                        continue;
                    case 4:
                        controller.delete(controller.showFormIndex());
                }
            } else {
                break;
            }
        } while (true);
    }

    public static void crudLeiloes(LeilaoController leilaoController, LicitacaoController licitacaoController, CompradorController compradorController){
        do {
            int opcao = leilaoController.showOptions();
            if(opcao > 0 && opcao <= 8){
                if (opcao == 1) {
                    leilaoController.read();
                } else if (opcao == 2) {
                    leilaoController.create(leilaoController.showFormCreate(licitacaoController));
                } else if (opcao == 3) {
                    leilaoController.showFormUpdate(licitacaoController);
                } else if (opcao == 4) {
                    leilaoController.delete(leilaoController.showFormIndex());
                } else if (opcao == 5) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();
                    leilao.read();
                } else if (opcao == 6) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();
                    leilao.create(leilao.showFormCreate(compradorController));
                } else if (opcao == 7) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();
                    leilao.showFormUpdate(compradorController);
                } else if (opcao == 8) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();;
                    leilao.delete(leilao.showFormIndex());
                }
            } else {
                break;
            }
        } while (true);
    }
}
