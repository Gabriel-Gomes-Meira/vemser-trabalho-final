import java.util.ArrayList;
import java.util.Objects;

public class LeilaoController implements Controller {
    private ArrayList<Leilao> leiloes;

    public LeilaoController() {
        this.leiloes = new ArrayList<>();
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
                    i, leiloes.get(i).licitacao.getEdital(),
                    leiloes.get(i).getLicitacao().getValorAvaliado(),
                    leiloes.get(i).dataInicio.toString(),
                    leiloes.get(i).dataFim.toString());
        }
    }
}
