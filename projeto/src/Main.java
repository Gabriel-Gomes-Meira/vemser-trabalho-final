import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        UsuarioController userController = new UsuarioController();
        LicitacaoController licitacaoController = new LicitacaoController();
        LeilaoController leilaoController = new LeilaoController();
        CompradorController compradorController = new CompradorController();

        compradorController.create(new PessoaFisica("leandro","leandrodeAsis@gmail.com","2184568569", "08956745398"));
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
                int alternativa = Interface.controllerCrud();
                if (alternativa == 1) {
                    userController.read();
                } else if (alternativa == 2) {
                    if(userController.create(Interface.cadastrarUsuario())) {
                        System.out.println("Criado");
                    }
                } else if (alternativa == 3) {
                    if(userController.delete(Interface.requerirIndex(userController.getUsuarios().size()))){
                        System.out.println("Deletado");
                    }else{
                        System.out.println("Erro");
                    }
                } else if (alternativa == 4) {
                    if(Interface.atualizarUsuario(userController)){
                        System.out.println("Atualizado");
                    }
                }
            }

            if (opcao == 2) {
                int alternativa = Interface.controllerCrud();

                if (alternativa == 1) {
                    licitacaoController.read();
                } else if (alternativa == 2) {
                    if(licitacaoController.create(Interface.cadastrarLicitacao())) {
                        System.out.println("Criado");
                    }
                } else if (alternativa == 3) {
                    if(licitacaoController.delete(Interface.requerirIndex(licitacaoController.getLicitacoes().size()))){
                        System.out.println("Deletado");
                    }else{
                        System.out.println("Erro");
                    }
                } else if (alternativa == 4) {
                    if(Interface.atualizarLicitacao(licitacaoController)){
                        System.out.println("Atualizado");
                    }
                }
            }

            if (opcao == 3) {
                int alternativa = Interface.controllerCrudLeilao();

                if (alternativa == 1) {
                    leilaoController.read();
                } else if (alternativa == 2) {
                    if(leilaoController.create(Interface.cadastrarLeilao(licitacaoController))) {
                        System.out.println("Criado");
                    }
                } else if (alternativa == 3) {
                    if(leilaoController.delete(Interface.requerirIndex(leilaoController.getLeiloes().size()))){
                        System.out.println("Deletado");
                    }else{
                        System.out.println("Erro");
                    }
                } else if (alternativa == 4) {
                    if(Interface.atualizarLeilao(leilaoController, licitacaoController)){
                        System.out.println("Atualizado");
                    }
                } else if (alternativa == 5) {
                    leilaoController.read();
                    leilaoController.getLeiloes().get(Interface.requerirIndex(leilaoController.getLeiloes().size())).read();
                } else if (alternativa == 6) {
                    leilaoController.read();
                    leilaoController.getLeiloes().get(Interface.requerirIndex(leilaoController.getLeiloes().size()))
                            .create(Interface.cadastrarProposta(compradorController, leilaoController));
                } else if (alternativa == 7) {
                    leilaoController.read();
                    leilaoController.getLeiloes().get(Interface.requerirIndex(leilaoController.getLeiloes().size()));
                } else if (alternativa == 8) {
                    leilaoController.read();
                    Interface.atualizarProposta(leilaoController, compradorController);
                }
            }

            if (opcao == 4) {
                int alternativa = Interface.controllerCrud();
                if (alternativa == 1) {
                    compradorController.read();
                } else if (alternativa == 2) {
                    if(compradorController.create(Interface.cadastraComprador())) {
                        System.out.println("Criado");
                    }
                } else if (alternativa == 3) {
                    if(compradorController.delete(Interface.requerirIndex(compradorController.getCompradores().size()))){
                        System.out.println("Deletado");
                    }else{
                        System.out.println("Erro");
                    }
                } else if (alternativa == 4) {
                    if(Interface. atualizarComprador(compradorController)){
                        System.out.println("Atualizado");
                    }
                }
            }

            if(opcao == 5) {
                System.exit(0);
            }
        }

    }
}
