package gestaoBanco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends Conta{
    @Column(name = "taxas")
    private double taxas;

    public void sacar(double valor){
        taxas = getSaldo() * 0.01;
        setSaldo(getSaldo() - valor - taxas);
    }
}
