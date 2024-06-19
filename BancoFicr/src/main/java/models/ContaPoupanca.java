package gestaoBanco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="conta_poupanca")
public class ContaPoupanca extends Conta{
    @Column(name = "bonus")
    private double bonus;

    public ContaPoupanca (String conta, byte agencia,double limiteConta){
        super(conta, agencia, limiteConta);
    }

    public ContaPoupanca (String conta, byte agencia){
        super(conta, agencia);
    }

    public ContaPoupanca(){
        super();

    }

    public void renderJuros(double taxa){
        double saldoAtual = getSaldo();
        depositar(saldoAtual * taxa);
    }

    public double depositar(double valor){
        this.bonus = this.bonus + (valor * 0.5);
        super.depositar(valor);
        return super.getSaldo();
    }

    public void sacar (double valor){
        setSaldo(getSaldo() - valor);
    }
}
