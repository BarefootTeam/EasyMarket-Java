/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marcos
 */
public class BDUtil {

    /**
     * Busca Proxima
     *
     * @return
     */
    public static Long getProxID() {

        
        
        String sql = " select nextval('sequence_geral') ";
        Long retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            if (rs.next()) {
                retorno = rs.getLong("nextval");
            }

            state.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return retorno;
    }
}
