package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plocabral
 */
public class InsercaoDAO {

    private Connection con = null;

    public InsercaoDAO() throws Exception {
        con = BancoConnection.getConnection();
    }

    public String add_carro(int numero_chassi, String nome, String cor, int ano, int potencia, double valor) {

        String sql = "INSERT INTO carro (numero_chassi, nome, cor, "
                + "ano, potencia, valor) VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero_chassi);
            stmt.setString(2, nome);
            stmt.setString(3, cor);
            stmt.setInt(4, ano);
            stmt.setInt(5, potencia);
            stmt.setDouble(6, valor);
            stmt.execute();
            System.out.println(stmt);
            return stmt.toString();

        } catch (SQLException ex) {
            return ex.toString();
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public String add_pessoa(int cpf, int rg, int idade, String nome) {

        String sql = "INSERT INTO pessoa (cpf, rg, idade, nome) VALUES (?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cpf);
            stmt.setInt(2, rg);
            stmt.setInt(3, idade);
            stmt.setString(4, nome);
            stmt.execute();
            System.out.println(stmt);
            return stmt.toString();

        } catch (SQLException ex) {
            return ex.toString();
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public String add_venda(int id_pessoa, int id_carro, String datav) {

        String sql = "INSERT INTO venda (id_venda, data_venda, id_pessoa_fk, id_carro_fk) VALUES (DEFAULT,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, datav);
            stmt.setInt(2, id_pessoa);
            stmt.setInt(3, id_carro);
            stmt.execute();
            System.out.println(stmt);
            return stmt.toString();

        } catch (SQLException ex) {
            return ex.toString();
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

}
