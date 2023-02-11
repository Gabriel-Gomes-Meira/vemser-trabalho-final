public class PessoaFisica extends Comprador {

    private String cpf;

    public PessoaFisica(String nome, String email, String telefone, int tipoPessoa, String cpf) {
        super(nome, email, telefone, tipoPessoa);

        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCnpj(String cpf) {
        this.cpf = cpf;
    }
}
