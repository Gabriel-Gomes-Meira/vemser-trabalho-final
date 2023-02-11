import java.util.ArrayList;

public class CompradorController implements Controller {

    ArrayList <Comprador> compradores;

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
                    (compradores.get(i) instanceof PessoaFisica ?
                        ((PessoaFisica) compradores.get(i)).getCpf():
                            ((PessoaJuridica) compradores.get(i)).getCnpj()),
                    compradores.get(i).nome,
                    compradores.get(i).email,
                    compradores.get(i).telefone);
        }
    }
}
