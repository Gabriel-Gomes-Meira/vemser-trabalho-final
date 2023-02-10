public class Proposta {
    double valor;
    Comprador comprador;

    public Proposta(double valor, Comprador comprador) {
        this.valor = valor;
        this.comprador = comprador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
}
