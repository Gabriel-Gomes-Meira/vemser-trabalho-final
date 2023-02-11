import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        UsuarioController userController = new UsuarioController();
        LicitacaoController licitacaoController = new LicitacaoController();
        LeilaoController leilaoController = new LeilaoController();

        userController.create(new Usuario("aaaaa", "aaaaa@email.com", "#00001"));
        licitacaoController.create(new Licitacao("Moto Honda", "114/23", 3200));
        leilaoController.create(new Leilao(licitacaoController.getLicitacoes().get(0),
                        Date.valueOf(LocalDate.of(2024,5,23)),
                        Date.valueOf(LocalDate.of(2024,5,23))));

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

        while (true) {
            int opcao = Interface.controllerCrudPrincipal(licitacaoController);

            if (opcao == 1) {
                 opcao = Interface.controllerCrud();
                if (opcao == 1) {
                    userController.read();
                } else if (opcao == 2) {
                    if(userController.create(Interface.cadastrarUsuario())) {
                        System.out.println("Criado");
                    }
                } else if (opcao == 3) {
                    if(userController.delete(Interface.requerirIndex())){
                        System.out.println("Deletado");
                    }else{
                        System.out.println("Erro");
                    }
                } else if (opcao == 4) {
                    if(Interface.atualizarUsuario(userController)){
                        System.out.println("Atualizado");
                    }
                }

            }
            if (opcao == 2) {
                opcao = Interface.controllerCrud();

                if (opcao == 1) {
                    licitacaoController.read();
                } else if (opcao == 2) {
                    if(licitacaoController.create(Interface.cadastrarLicitacao())) {
                        System.out.println("Criado");
                    }
                } else if (opcao == 3) {
                    if(licitacaoController.delete(Interface.requerirIndex())){
                        System.out.println("Deletado");
                    }else{
                        System.out.println("Erro");
                    }
                } else if (opcao == 4) {
                    if(Interface.atualizarLicitacao(licitacaoController)){
                        System.out.println("Atualizado");
                    }
                }
            }
            if (opcao == 3) {
                opcao = Interface.controllerCrudLeilao();

                switch (opcao) {
                    case 1:
                        opcao = Interface.controllerCrud();
                        if (opcao == 1) {
                            leilaoController.read();
                        } else if (opcao == 2) {
                            if(leilaoController.create(Interface.cadastrarLeilao(licitacaoController))) {
                                System.out.println("Criado");
                            }
                        } else if (opcao == 3) {
                            if(leilaoController.delete(Interface.requerirIndex())){
                                System.out.println("Deletado");
                            }else{
                                System.out.println("Erro");
                            }
                        } else if (opcao == 4) {
                            if(Interface.atualizarLeilao(leilaoController, licitacaoController)){
                                System.out.println("Atualizado");
                            }
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        continue;
                    default:
                        continue;
                }
            }
        }

    }
}
