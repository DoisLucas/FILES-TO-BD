package DAOs;

import Beans.Sistema;
import View.Menu;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plocabral
 */
public class BancoConnection {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/rentcar";
    private static final String USER = "postgres";
    private static final String PASS = "********";

    public static Connection getConnection() throws Exception {

        FileWriter WR = null;
        try {
            WR = new FileWriter(Sistema.getInstance().getArquivo(), true);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter BW = new BufferedWriter(WR);

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            
            BW.write(ex.toString());
            throw new Exception("Erro na conexão", ex);

        }

    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(con, stmt);
    }

}
