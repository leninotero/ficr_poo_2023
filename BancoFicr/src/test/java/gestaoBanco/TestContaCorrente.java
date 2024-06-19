package gestaoBanco;

import com.example.springboot.models.Conta;
import com.example.springboot.models.ContaCorrente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestContaCorrente {
    private static Conta c;

    @BeforeEach
    void init(){
        c = new ContaCorrente();
    }

    @Test
    @DisplayName("TC001 - Deve validar o valor da conta inserido assim como seu tipo de dado")
    void testEscritaLeituraNumeroConta(){
        String resultadoEsperado = "1111-1";

        c.setConta("1111-1");
        assertEquals(resultadoEsperado, c.getConta(), "Erro na execução do teste");
    }

    @Test
    @DisplayName("TC002 - Deve validar que os tipos de de dados são diferentes")
    void testEscritaLeituraNumeroContaErro(){
        int resultadoEsperado = 1111-1;

        c.setConta("1111-1");
        assertNotEquals(resultadoEsperado, c.getConta(), "Erro na execução do teste");
    }

    @Test
    @DisplayName("TC003 = Teste de partição para o numero de agencia")
    void testValoresNumeroAgencia(){
        c.setAgencia((byte) 110);
        byte resultadoEsperado = 110;

        assertEquals(resultadoEsperado, c.getAgencia());

        c.setAgencia((byte) 127);
        byte resultadoEsperado2 = 127;

        assertEquals(resultadoEsperado2, c.getAgencia());

        c.setAgencia((byte) 128);
        int resultadoEsperado3 = 128;

        assertNotEquals(resultadoEsperado3, c.getAgencia());
    }
    
    //========= Teste de componente ===========
    @Test
    @DisplayName("TC004 - Deve validar os valores depositados")
    void testDepositarValor(){
        assertAll(
                () -> assertEquals(120.00, c.depositar(120.00)),
                () -> assertEquals(170.00, c.depositar(50.00)),
                () -> assertEquals(200.00, c.depositar(30.00))
        );
    }
    
    //============= Teste de Sistema ===============
    @Test
    @DisplayName("TC005 - Deve registrar as informações de conta com valores válidos")
    void testRegistrarInformacoesConta(){
        String resultadoEsperado = "[Conta: 1111-1 Agencia: 125 Saldo: 300.0 Limite da Conta: 500.0]";
        
        c.setConta("1111-1");
        c.setAgencia((byte) 125);
        c.setSaldo(300.00);
        c.setLimiteConta(500.00);

        assertEquals(resultadoEsperado, c.toString(), "Erro na execução do teste");
    }

}