package gestaoPessoas;

public class Pessoa {
    private String nome, username, pwd;
    private int idade;
    private char sexo;
    private double rendaMensal;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public Boolean validaSenha(String username, String pwd) {
        boolean acessou = false;
        if (this.username.equals(username) && (this.pwd.equals(pwd))) {
            acessou = true;
        }
        return acessou;
    }

    public String toString(){
        return "[Nome: " + this.nome + " Usuario: " + this.username +
                " Sexo: " + this.sexo + " Idade: " + this.idade +
                " Renda mensal: " + this.rendaMensal + " e mail: " + this.email + "]";
    }
}
