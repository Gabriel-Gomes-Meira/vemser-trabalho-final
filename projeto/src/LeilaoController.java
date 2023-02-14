import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeilaoController extends Controller {
    private ArrayList<Leilao> leiloes;

    public LeilaoController() {
        this.leiloes = new ArrayList<>();
    }

    public void setLeiloes(ArrayList<Leilao> leiloes) {
        this.leiloes = leiloes;
    }

    public ArrayList<Leilao> getLeiloes() {
        return leiloes;
    }


    @Override
    public boolean create(Object leilao) {
        if(leilao instanceof Leilao){
            leiloes.add((Leilao) leilao);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        if(index >= 0 && index < leiloes.size()){
            leiloes.remove(index);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean update(int index, Object leilao) {
        if(index >= 0 && index < leiloes.size()){
            leiloes.set(index, (Leilao) leilao);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void read() {
        for (int i = 0; i < leiloes.size(); i++) {
            System.out.printf("\n" +
                    "%d | Leilão {%s, %.2f, %s, %s}",
                    i, leiloes.get(i).getLicitacao().getEdital(),
                    leiloes.get(i).getLicitacao().getValorAvaliado(),
                    leiloes.get(i).getDataInicio().toString(),
                    leiloes.get(i).getDataFim().toString());
        }
    }

    @Override
    public List collection() {
        return getLeiloes();
    }

    @Override
    public String showOptions() {
        System.out.println("\n" +
                "#################################################################\n" +
                "##\t1 - Listar\t\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t2 - Cadastrar\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t3 - Atualizar\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t4 - Deletar\t\t\t\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t5 - Listar propostas\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t6 - Cadastrar proposta\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t7 - Atualizar proposta\t\t\t\t\t\t\t\t\t#####\n" +
                "##\t8 - Deletar proposta\t\t\t\t\t\t\t\t\t#####\n" +
                "##\tPressione qualquer outro tecla para sair\t\t\t\t#####\n" +
                "#################################################################\n");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextLine();
    }

    @Override
    public Object showFormCreate() {
        String dataInicio,
                dataFim;
        Scanner inputScanner = new Scanner(System.in);

        do {
            System.out.print("\n" +
                    "###################################\n" +
                    "##\tData de Inicio (yyyy-mm-dd): \t\t\t\t\t\t###\n");
            dataInicio = inputScanner.nextLine();

            System.out.print("\n" +
                    "###################################\n" +
                    "##\tData de Termino (yyyy-mm-dd): \t\t\t\t\t\t###\n");
            dataFim = inputScanner.nextLine();
        } while (!validate(Date.valueOf(dataInicio).getTime() <= Date.valueOf(dataFim).getTime(), "Data de termino não pode ser inferior à de inicio!"));

        return new Leilao(new Licitacao("", "", 0),
                Date.valueOf(dataInicio), Date.valueOf(dataFim));
    }

    // Classes com atributos dependentes de outros outras classes
    // implmentam o showFormCreate dessa forma.
    public Object showFormCreate(Controller controller) {
        Licitacao licitacaoEscolhida = (Licitacao) controller.selectItem();

        Leilao leilao = (Leilao) this.showFormCreate();
        leilao.setLicitacao(licitacaoEscolhida);
        return leilao;
    }

    public void showFormUpdate(Controller controller) {
        update(showFormIndex(), showFormCreate(controller));
    }

}
