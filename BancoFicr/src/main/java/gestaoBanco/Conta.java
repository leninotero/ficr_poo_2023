package gestaoBanco;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Conta  {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "numero_conta")
    private String conta;
    @Column(name = "agencia")
    private int agencia;
    @Column(name = "saldo")
    private double saldo = 0.00;
    @Column(name = "limiteConta")
    private double limiteConta;

    public Conta (String conta, int agencia, double limiteConta){
        this.conta = conta;
        this.agencia = agencia;
        this.limiteConta = limiteConta;
    }

    public Conta (String conta, int agencia){
        this.conta = conta;
        this.agencia = agencia;
    }

    public Conta(){

    }

    public void setConta(String conta){
        this.conta = conta;
    }

    public void setAgencia(int agencia){
        this.agencia = agencia;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public String getConta(){
        return conta;
    }

    public int getAgencia(){
        return agencia;
    }

    public double getSaldo(){
        return saldo;
    }

    public double getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(double limiteConta) {
        this.limiteConta = limiteConta;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public abstract void sacar(double valor);

    public void pagarBoleto(String codBarras){
        double valorPagar;
        valorPagar = Double.parseDouble(codBarras.substring(codBarras.length() - 10));
        saldo = saldo - valorPagar;
    }

    public String retornaBanco(String codBarras){
        int codBanco = Integer.parseInt(codBarras.substring(0,3));
        String nomeBanco;
        if (codBanco == 336){
            nomeBanco = "banco C6";
        } else if (codBanco == 001){
            nomeBanco = "Banco do Brasil";
        } else if (codBanco == 237){
            nomeBanco = "Banco Bradesco";
        } else if (codBanco == 033){
            nomeBanco = "Banco Santander";
        } else {
            nomeBanco = "Código inválido";
        }
        return nomeBanco;
    }

    public String toString(){
        return "[Conta: " + this.conta + " Agencia: " + this.agencia
                + " Saldo: " + this.saldo + " Limite da Conta: " + this.limiteConta + "]";
    }
}
