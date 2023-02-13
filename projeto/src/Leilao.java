import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Leilao extends Controller{
    private Licitacao licitacao;
    private Date dataInicio, dataFim;

    private ArrayList<Proposta> propostas;

    public Leilao(Licitacao licitacao, Date dataInicio, Date dataFim) {
        this.licitacao = licitacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.propostas = new ArrayList<>();
    }

    public Licitacao getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(Licitacao licitacao) {
        this.licitacao = licitacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public ArrayList<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(ArrayList<Proposta> propostas) {
        this.propostas = propostas;
    }

    public Proposta getGanhador() {
        List<Proposta> sortedPropostas = getPropostas().stream()
                                                            .sorted(Comparator.comparing(Proposta::getValor))
                                                            .collect(Collectors.toList());
        return sortedPropostas.get(sortedPropostas.size() - 1);
    }

    @Override
    public boolean create(Object proposta) {
        if(proposta instanceof Proposta &&
                validate(getGanhador().getValor() < ((Proposta) proposta).getValor(),
                        String.format("Valor inválido! Deve superar a proposta ganhadora! Mínimo: %.2f", getGanhador().getValor()))){
            propostas.add((Proposta) proposta);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        if(index >= 0 && index < propostas.size()){
            propostas.remove(index);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean update(int index, Object proposta) {
        if(index >= 0 && index < propostas.size()){
            propostas.set(index, (Proposta) proposta);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void read() {
        for (int i = 0; i < propostas.size(); i++) {
            System.out.printf("\n" +
                            "%d | Propostas {%s, %s, %s}\n" +
                            "Ganhador: %s, %.2f",
                    i,
                    propostas.get(i).getValor(),
                    propostas.get(i).getComprador().getNome(),
                    propostas.get(i).getComprador().getDocumento(),
                    getGanhador().getComprador().getNome(),
                    getGanhador().getValor());
        }
    }

    @Override
    public List collection() {
        return getPropostas();
    }

    @Override
    public Object showFormCreate() {
        double valor;
        Scanner inputScanner = new Scanner(System.in);

        do {
            System.out.print("\n" +
                    "###################################\n" +
                    "##\tValor: \t\t\t\t\t\t###\n");
            valor = inputScanner.nextDouble();
        } while (!validate(valor > getLicitacao().getValorAvaliado(), String.format("Valor inválido! Mínimo: %.2f", getLicitacao().getValorAvaliado())));

        return new Proposta(valor, new Comprador("", "", "", "", 1));
    }

    // Classes com atributos dependentes de outros outras classes
    // implmentam o showFormCreate dessa forma.
    public Object showFormCreate(Controller controller) {
        Comprador compradorEscolhido = (Comprador) controller.selectItem();

        Proposta proposta = (Proposta) this.showFormCreate();
        proposta.setComprador(compradorEscolhido);
        return proposta;
    }

    public void showFormUpdate(Controller controller) {
        update(showFormIndex(), showFormCreate(controller));
    }

}
