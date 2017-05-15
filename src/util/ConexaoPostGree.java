package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoPostGree {

    private static Connection conexao;

    private ConexaoPostGree() {
    }

    public static Connection getConexao() {
        try {
            if ((conexao == null) || conexao.isClosed()) {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/easymarket", "postgres", "masterkey");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }

    public static void setConexao(Connection pConnection) {
        conexao = pConnection;
    }
}
