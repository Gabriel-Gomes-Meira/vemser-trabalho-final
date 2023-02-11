public class PessoaFisica extends Comprador {

    private String cpf;

    public PessoaFisica(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone);

        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCnpj(String cpf) {
        this.cpf = cpf;
    }
}
