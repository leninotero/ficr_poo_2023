package repositorioBD;

import connect.Conexao;
import gestaoBanco.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CadastroConta {
    private static Connection conn = null;
    private static PreparedStatement pstm = null;

    public static void salvarConta(Conta conta) throws Exception{
        String sql = "INSERT INTO conta (conta, agencia, saldo, limiteConta) VALUES (?,?,?,?)";

        try{
            conn = Conexao.getConexao();
            pstm  = conn.prepareStatement(sql);
            pstm.setString(1, conta.getConta());
            pstm.setInt(2, conta.getAgencia());
            pstm.setDouble(3, conta.getSaldo());
            pstm.setDouble(4,  conta.getLimiteConta());
            pstm.executeUpdate();
            conn.close();
            System.out.println("Conta criada com sucesso!");
        }catch (Exception e){
            conn.rollback();
            System.out.println(e.getMessage());
        }

    }

    public static List<Conta> listarContas(Conta conta) throws Exception{
        List<Conta> listaContas = null;
        ResultSet result;
        String sql = "SELECT * FROM conta";

        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        result = pstm.executeQuery();

        while (result.next()){
            conta.setConta(result.getString("conta"));
            conta.setAgencia(result.getInt("agencia"));
            conta.setSaldo(result.getDouble("saldo"));
            conta.setLimiteConta(result.getDouble("limiteConta"));
            listaContas.add(conta);
        }

        conn.close();
        return listaContas;
    }

    public static void alterarConta(Conta conta) throws Exception{
        String sql = "UPDATE conta SET agencia=?, saldo=?, limiteConta=? WHERE conta=?";

        try{
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, conta.getAgencia());
            pstm.setDouble(2, conta.getSaldo());
            pstm.setDouble(3,  conta.getLimiteConta());
            pstm.setString(4, conta.getConta());
            pstm.executeUpdate();
            conn.close();
            System.out.println("As alterações da conta  foram realizadas!");
        }catch (Exception e){
            conn.rollback();
            System.out.println(e.getMessage());
        }

    }

    public static void excluirConta(Conta conta) throws Exception {
        String sql = "DELETE FROM conta WHERE conta=?";

        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, conta.getConta());
            pstm.executeUpdate();
            conn.close();
            System.out.println("Conta removida com sucesso!");
        }catch (Exception e){
            conn.rollback();
            System.out.println(e.getMessage());
        }
    }
}
