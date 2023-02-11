abstract class Comprador {
    String nome, email, telefone, documento;
    int tipoPessoa; // 1 - Pessoa Fisica
                    // 2 - Pessao Juridica


    public Comprador(String nome, String email, String telefone, int tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
