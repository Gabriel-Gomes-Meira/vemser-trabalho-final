public class PessoaJuridica extends Comprador{

    private String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, int tipoPessoa, String cnpj) {
        super(nome, email, telefone, tipoPessoa);

        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
