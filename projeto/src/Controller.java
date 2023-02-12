import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public abstract class Controller implements Menu{

    public abstract boolean create(Object usuario);

    public abstract boolean delete(int index);

    public abstract boolean update(int index, Object usuario);

    public abstract void read();

    public abstract List collection();

    @Override
    public int showOptions() {
        System.out.println("\n" +
                "#################################################################\n" +
                "##\t1 - Listar\t\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t2 - Cadastrar\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t3 - Atualizar\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t4 - Deletar\t\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t9 - Sair\t\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "#################################################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    @Override
    public int showFormIndex() {
        while (true){
            Scanner inputScanner = new Scanner(System.in);
            read();
            System.out.print("\n" +
                    "###################################\n" +
                    "##\tDigite o índice: \t\t\t\t\t\t###\n");
            int entrada = inputScanner.nextInt();
            if (entrada < collection().size() && entrada >= 0) {
                return entrada;
            }
        }
    }

    @Override
    public void showFormUpdate() {
        read();
        update(showFormIndex(), showFormCreate());
    }

    public Object selectItem() {
        return collection().get(showFormIndex());
    }
}
