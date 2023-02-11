import java.util.ArrayList;
import java.util.Date;

public class Leilao implements Controller{
    Licitacao licitacao;
    Date dataInicio, dataFim;

    ArrayList<Proposta> propostas;

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
                            "%d | Propostas {%s, %s}",
                    i,
                    propostas.get(i).valor,
                    propostas.get(i).comprador);
        }
    }
}
