package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConexao() throws Exception{
        Connection conn= null;
        String host = "jdbc:mysql://localhost/banco_ficr";
        String user  = "root";
        String psw = "";

        //com.mysql.jdbc.Driver() => deprecated
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        conn = DriverManager.getConnection(host, user, psw);

        return conn;
    }
}
