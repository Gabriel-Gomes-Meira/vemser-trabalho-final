import java.util.ArrayList;
import java.util.Date;

public class Leilao {
    Licitacao licitacao;
    Date dataInicio, dataFim;

    ArrayList<Proposta> propostas;

    public Leilao(Licitacao licitacao, Date dataInicio, ArrayList<Proposta> propostas) {
        this.licitacao = licitacao;
        this.dataInicio = dataInicio;
        this.propostas = propostas;
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

//    public void setDataFim(Date dataFim) {
//        this.dataFim = dataFim;
//    }

    public void encerrarLeilao(){
        // dataFim = now
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
}
