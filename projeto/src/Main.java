import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();
        LicitacaoController licitacaoController = new LicitacaoController();
        LeilaoController leilaoController = new LeilaoController();
        CompradorController compradorController = new CompradorController();

        compradorController.create(new Comprador("2184568569", "leandro", "leandrodeAsis@gmail.com", "08956745398", 1));
        usuarioController.create(new Usuario("root", "root@email.com", "0000"));
        licitacaoController.create(new Licitacao("Moto Honda", "114/23", 3200));
        leilaoController.create(new Leilao(licitacaoController.getLicitacoes().get(0),
                Date.valueOf(LocalDate.of(2024, 5, 23)),
                Date.valueOf(LocalDate.of(2024, 5, 23))));
        leilaoController.getLeiloes().get(0).create(new Proposta(20000, compradorController.getCompradores().get(0)));

//        if (login(usuarioController)){
            do {
                String opcao = paginaPrincipal(licitacaoController);
                switch (opcao) {
                    case "1":
                        crudSemDependencia(usuarioController);
                        continue;
                    case "2":
                        crudSemDependencia(licitacaoController);
                        continue;
                    case "3":
                        crudLeiloes(leilaoController, licitacaoController, compradorController);
                        continue;
                    case "4":
                        crudSemDependencia(compradorController);
                        continue;
                    default:
                        System.exit(0);
                }
            } while (true);
//        }
    }

    public static String paginaPrincipal(LicitacaoController licitacaoController) {
        System.out.println("\n" +
                "#################################################################\n" +
                "##\t1 - Usuarios\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t2 - Licitações\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                (licitacaoController.getLicitacoes().size() != 0?"##\t3 - Leilao\t\t\t\t\t\t\t\t\t\t\t\t#####\n":"")+
                "##\t4 - Compradores\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\tPressione qualquer outro tecla para sair\t\t\t\t#####\n" +
                "#################################################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextLine();
    }

    public static void crudSemDependencia(Controller controller){
        boolean sair = false;
        do {
            String opcao = controller.showOptions();
                switch (opcao){
                    case "1":
                        controller.read();
                        break;
                    case "2":
                        controller.create(controller.showFormCreate());
                        break;
                    case "3":
                        controller.showFormUpdate();
                        break;
                    case "4":
                        controller.delete(controller.showFormIndex());
                        break;
                    default:
                        sair = true;
                }
        } while (!sair);
    }

    public static void crudLeiloes(LeilaoController leilaoController, LicitacaoController licitacaoController, CompradorController compradorController){
        boolean sair = false;
        do {
            String opcao = leilaoController.showOptions();
                if (opcao.equals("1")) {
                    leilaoController.read();
                } else if (opcao.equals("2")) {
                    leilaoController.create(leilaoController.showFormCreate(licitacaoController));
                } else if (opcao.equals("3")) {
                    leilaoController.showFormUpdate(licitacaoController);
                } else if (opcao.equals("4")) {
                    leilaoController.delete(leilaoController.showFormIndex());
                } else if (opcao.equals("5")) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();
                    leilao.read();
                } else if (opcao.equals("6")) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();
                    leilao.create(leilao.showFormCreate(compradorController));
                } else if (opcao.equals("7")) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();
                    leilao.showFormUpdate(compradorController);
                } else if (opcao.equals("8")) {
                    Leilao leilao = (Leilao) leilaoController.selectItem();;
                    leilao.delete(leilao.showFormIndex());
                } else {
                    sair = true;
                }
        } while (!sair);
    }

    public static boolean login(UsuarioController usuarioController) {
        while (true) {
            System.out.println("\n" +
                    "#################################################################\n" +
                    "##\t1 - Logar\t\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                    "##\tPressione qualquer outro número para sair\t\t\t\t#####\n" +
                    "#################################################################\n");
            Scanner inputScanner = new Scanner(System.in);
            String opcao = inputScanner.nextLine();

            if (opcao.equals("1")) {
                String credenciais[] = new String[2];
                System.out.println("Email:");
                credenciais[0] = inputScanner.nextLine();
                System.out.println("Senha:");
                credenciais[1] = inputScanner.nextLine();
                if (usuarioController.findAndAuth(credenciais)) {
                    System.out.println("Logado!");
                    return true;
                }
                System.out.println("Não encontramos usuário com esses dados!");
            } else {
                System.exit(0);
            }
        }
    }
}
