package repositorioBD;

import connect.Conexao;
import gestaoBanco.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CadastroConta {

    public static void salvarConta(Conta conta) throws Exception{
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO conta (conta, agencia, saldo, limiteConta) VALUES (?,?,?,?)";

        conn = Conexao.getConexao();
        pstm  = conn.prepareStatement(sql);
        pstm.setString(1, conta.getConta());
        pstm.setInt(2, conta.getAgencia());
        pstm.setDouble(3, conta.getSaldo());
        pstm.setDouble(4,  conta.getLimiteConta());
        pstm.executeUpdate();
        conn.close();
    }
}
