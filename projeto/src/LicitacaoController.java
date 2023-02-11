import java.util.ArrayList;
import java.util.Objects;

public class LicitacaoController implements  Controller{

    private ArrayList<Licitacao> licitacoes;
    public LicitacaoController() {
        this.licitacoes = new ArrayList<>();
    }

    private boolean licitionExists(Licitacao licitacao){
        for (int i = 0; i < licitacoes.size(); i++) {
            if(Objects.equals(licitacoes.get(i).getEdital(), licitacao.getEdital())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Licitacao> getLicitacoes() {
        return licitacoes;
    }

    public void setLicitacoes(ArrayList<Licitacao> licitacoes) {
        this.licitacoes = licitacoes;
    }

    @Override
    public boolean create(Object licitacao) {
        if(licitacao instanceof Licitacao && !licitionExists((Licitacao) licitacao)){
            licitacoes.add((Licitacao) licitacao);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        if(index >= 0 && index < licitacoes.size()){
            licitacoes.remove(index);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(int index, Object licitacao) {
        if(index >= 0 && index < licitacoes.size()){
            licitacoes.set(index, (Licitacao) licitacao);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void read() {
        for (int i = 0; i < licitacoes.size(); i++) {
            System.out.printf("\n" +
                            "%d | Licitação {%s\n, %s, %.2f}",
                    i, licitacoes.get(i).getDescricao(),
                    licitacoes.get(i).getEdital(),
                    licitacoes.get(i).getValorAvaliado());
        }
    }
}
