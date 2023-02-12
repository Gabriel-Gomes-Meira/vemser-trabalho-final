import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    public void levantarProposta(Proposta proposta) {
        // talvez adicionar validadção se a proposta tem um valor realmente maior dos que a anterior
        propostas.add(proposta);
    }

    public ArrayList<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(ArrayList<Proposta> propostas) {
        this.propostas = propostas;
    }

    @Override
    public boolean create(Object proposta) {
        if(proposta instanceof Proposta){
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
                            "%d | Propostas {%s, %s, %s}",
                    i,
                    propostas.get(i).getValor(),
                    propostas.get(i).getComprador().getNome(),
                    propostas.get(i).getComprador().getDocumento());
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
