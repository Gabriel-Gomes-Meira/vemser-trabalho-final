import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Interface {

    public static int login() {
        System.out.println("\n" +
                "###################################\n" +
                "##\t1 - Entrar\t\t\t\t\t###\n" +
                "##\t2 - Cadastrar Usuário\t\t###\n" +
                "##\t3 - Encerrar\t\t\t\t###\n" +
                "###################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    public static String[] requerirCredenciais(){
        String nome, email, senha;
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n" +
                "###################################\n" +
                "##\tEmail: \t\t\t\t\t\t###\n");
        email = inputScanner.nextLine();

        System.out.print("\n" +
                "###################################\n" +
                "##\tSenha: \t\t\t\t\t\t###\n");
        senha = inputScanner.nextLine();

        return new String[]{email, senha};
    }

    public static Usuario cadastrarUsuario() {
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

    public static int requerirIndex() {
        int index;
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n" +
                "###################################\n" +
                "##\tDigite o índice: \t\t\t\t\t\t###\n");
        return inputScanner.nextInt();
    }

    public static boolean atualizarUsuario(UsuarioController usuarioController) {
        usuarioController.read();
        return usuarioController.update(requerirIndex(), cadastrarUsuario());
    }
    public static int controllerCrudPrincipal(LicitacaoController licitacaoController) {
        System.out.println("\n" +
                "###################################\n" +
                "##\t1 - Usuarios\t\t\t\t\t###\n" +
                "##\t2 - Licitações\t\t###\n" +
                (licitacaoController.getLicitacoes().size() != 0?"##\t3 - Leilao\t\t\t\t###\n":"")+
                "##\t4 - sair\t\t\t\t###\n" +
                "###################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    public static int controllerCrudLeilao(LicitacaoController licitacaoController) {
        System.out.println("\n" +
                "###################################\n" +
                "##\t1 - Usuarios\t\t\t\t\t###\n" +
                "##\t2 - Licitações\t\t###\n" +
                (licitacaoController.getLicitacoes().size() != 0?"##\t3 - Leilao\t\t\t\t###\n":"")+
                "##\t4 - sair\t\t\t\t###\n" +
                "###################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    public static int controllerCrud() {
        System.out.println("\n" +
                "###################################\n" +
                "##\t1 - listar\t\t\t\t\t###\n" +
                "##\t2 - cadastrar\t\t###\n" +
                "##\t3 - deletar\t\t\t\t###\n" +
                "##\t4 - atualizar\t\t\t\t###\n" +
                "###################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    public static int controllerCrudLeilao() {
        System.out.println("\n" +
                "###################################\n" +
                "##\t1 - Gerenciar Leilao\t\t\t\t\t###\n" +
                "##\t2 - Gerenciar Propostas\t\t\t\t###\n" +
                "##\t3 - Sair\t\t\t\t###\n" +
                "###################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    public static Licitacao cadastrarLicitacao() {
        String descricao, edital;
        double valorAvaliado;

        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n" +
                "###################################\n" +
                "##\tDescrição: \t\t\t\t\t\t###\n");
        descricao = inputScanner.nextLine();

        System.out.print("\n" +
                "###################################\n" +
                "##\tEdital: \t\t\t\t\t\t###\n");
        edital = inputScanner.nextLine();

        System.out.print("\n" +
                "###################################\n" +
                "##\tValor avaliado: \t\t\t\t\t\t###\n");
        valorAvaliado = inputScanner.nextDouble();


        return new Licitacao(descricao, edital, valorAvaliado);
    }

    public static boolean atualizarLicitacao(LicitacaoController licitacaoController) {
        licitacaoController.read();
        return licitacaoController.update(requerirIndex(), cadastrarLicitacao());
    }

    public static Leilao cadastrarLeilao(LicitacaoController licitacaoController) {
        Licitacao licitacaoEscolhida = null;
//        Date.
        int dataInicio[] = new int[3],
                dataFim[] = new int[3];
        licitacaoController.read();
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n" +
                "###################################\n" +
                "##\tLicitação: \t\t\t\t\t\t###\n");
        int index = inputScanner.nextInt();

        while (true){
            if (index >= 0 && index < licitacaoController.getLicitacoes().size()) {
                licitacaoEscolhida = licitacaoController.getLicitacoes().get(index);
                break;
            } else {
                System.out.println("Index inválido!");
            }
        }

        System.out.print("\n" +
                "###################################\n" +
                "##\tDia de Inicio: \t\t\t\t\t\t###\n");
        dataInicio[0] = inputScanner.nextInt();
        System.out.print("\nMês:");
        dataInicio[1] = inputScanner.nextInt();
        System.out.print("\nAno:");
        dataInicio[2] = inputScanner.nextInt();


        System.out.print("\n" +
                "###################################\n" +
                "##\tDia de Termino: \t\t\t\t\t\t###\n");
        dataFim[0] = inputScanner.nextInt();
        System.out.print("\nMês:");
        dataFim[1] = inputScanner.nextInt();
        System.out.print("\nAno:");
        dataFim[2] = inputScanner.nextInt();

        Date dateInico = Date.valueOf(LocalDate.of(dataInicio[2],
                                                    dataInicio[1],
                                                    dataInicio[0]));

        Date dateFim = Date.valueOf(LocalDate.of(dataFim[2],
                dataFim[1],
                dataFim[0]));


        return new Leilao(licitacaoEscolhida, dateInico, dateFim);
    }

    public static boolean atualizarLeilao(LeilaoController leilaoController, LicitacaoController licitacaoController) {
        leilaoController.read();
        return leilaoController.update(requerirIndex(), cadastrarLeilao(licitacaoController));
    }
}
