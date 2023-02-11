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

    public static int requerirIndex(){
        int index;
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n" +
                "###################################\n" +
                "##\tDigite o índice: \t\t\t\t\t\t###\n");
        return inputScanner.nextInt();
    }

    public static Usuario atualizarUsuario() {
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
