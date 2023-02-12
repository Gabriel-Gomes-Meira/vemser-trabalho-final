public class Licitacao  {
    private String descricao, edital;
    private double valorAvaliado;

    public Licitacao(String descricao, String edital, double valorAvaliado) {
        this.descricao = descricao;
        this.edital = edital;
        this.valorAvaliado = valorAvaliado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public double getValorAvaliado() {
        return valorAvaliado;
    }

    public void setValorAvaliado(double valorAvaliado) {
        this.valorAvaliado = valorAvaliado;
    }

}
