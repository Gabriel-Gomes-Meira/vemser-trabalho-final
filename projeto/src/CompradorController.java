import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CompradorController extends Controller {

    private ArrayList <Comprador> compradores;

    public CompradorController() {
        this.compradores = new ArrayList<>();
    }

    public ArrayList<Comprador> getCompradores() {
        return compradores;
    }

    public void setCompradores(ArrayList<Comprador> compradores) {
        this.compradores = compradores;
    }

    @Override
    public boolean create(Object comprador) {
        if(comprador instanceof Comprador){
            compradores.add((Comprador) comprador);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        if(index >= 0 && index < compradores.size()){
            compradores.remove(index);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean update(int index, Object comprador) {
        if(index >= 0 && index < compradores.size()){
            compradores.set(index, (Comprador) comprador);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void read() {
        for (int i = 0; i < compradores.size(); i++) {
            System.out.printf("\n" +
                            "%d | Comprador {%s, %s, %s, %s}",
                    i,
                    compradores.get(i).getDocumento(),
                    compradores.get(i).getNome(),
                    compradores.get(i).getEmail(),
                    compradores.get(i).getTelefone());
        }
    }

    @Override
    public List collection() {
        return getCompradores();
    }

    @Override
    public Object showFormCreate() {
        String nome, email, telefone, documento, tipo;

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
                "##\tTelefone: \t\t\t\t\t\t###\n");
        telefone = inputScanner.nextLine();

        do {
            System.out.print("\n" +
                    "###################################\n" +
                    "##\tTipo de Pessoa: \t\t\t\t\t\t###\n" +
                    "##\t1 - Pessoa fisica: \t\t\t\t\t\t###\n" +
                    "##\t2 - Pessoa juridica: \t\t\t\t\t\t###\n");
            tipo = inputScanner.nextLine();
        } while (!validate(tipo.equals("1") || tipo.equals("2"), "Valor inválido!"));


        System.out.printf("\n" +
                "###################################\n" +
                "##\tDigite o %s: \t\t\t\t\t\t###\n",
                tipo.equals("1")?"CPF":"CNPJ");
        documento = inputScanner.nextLine();

        return new Comprador(documento, nome, email, telefone, Integer.valueOf(tipo));
    }

}