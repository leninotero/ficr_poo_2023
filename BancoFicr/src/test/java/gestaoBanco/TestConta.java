package gestaoBanco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class TestConta {
    Conta c;

    @BeforeEach
    void init(){
        c = new Conta();
    }

    @Test
    @Order(1)
    @DisplayName("CT001-01 - Valida o Retorno de uma Conta Cadastrada")
    void testDeveRetornarNumeroContaCadastrado() {
        String resultadoEsperado = "1111-1";
        c.setConta("1111-1");

        assertEquals(resultadoEsperado, c.getConta(), "Falha na execução do Teste");
    }

    @Test
    @Order(2)
    @Disabled
    @DisplayName("CT001-02 - Deve validar tipos de dados diferentes de conta cadastrada")
    void getConta(){
        int resultadoEsperado = 22222;
        c.setConta("22222");

        assertNotEquals(resultadoEsperado, c.getConta(), "Falaha na execução do Teste");
    }

    @Test
    @Order(3)
    @DisplayName("CT002 - Valida o Retorno de uma Agencia Cadastrada")
    void getAgencia() {
        int resultadoEsperado = 123;
        c.setAgencia(123);
        
        assertEquals(resultadoEsperado, c.getAgencia(), "Falha na execução do teste");
    }

   //    @Test
//    void getSaldo() {
//    }
//
//    @Test
//    void getLimiteConta() {
//    }

    @Test
    @Order(4)
    @DisplayName("TC003 - Deve adicionar um valor no saldo ao realizar um deposito")
    void depositar() {
        assertAll(
                () -> assertEquals(120.00, c.depositar(120.00)),
                () -> assertEquals(140.00, c.depositar(20.00))
        );
    }
//    @Test
//    void sacar() {
//    }
//
//    @Test
//    void pagarBoleto() {
//    }
//
//    @Test
//    void getId() {
//    }
//
//    @Test
//    void setId() {
//    }
//
//    @Test
//    void retornaBanco() {
//    }

    @Test
    @Order(4)
    @DisplayName("CT004 - Deve registrar uma conta com valores válidos")
    void testCriarConta(){
        String resultadoEsperado = "[Conta: 1111-1 Agencia: 321 Saldo: 120.0 Limite da Conta: 1000.0]";

        c.setConta("1111-1");
        c.setAgencia(321);
        c.setSaldo(120.00);
        c.setLimiteConta(1000.00);

        assertEquals(resultadoEsperado, c.toString(), "Falha na Execução do Teste");
    }
}