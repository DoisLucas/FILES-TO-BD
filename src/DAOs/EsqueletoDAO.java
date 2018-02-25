/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Beans.Esqueleto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author plocabral
 */
public class EsqueletoDAO {

    private Connection con = null;

    public EsqueletoDAO() throws Exception {
        con = BancoConnection.getConnection();
    }

    public ArrayList<String> add_cliente(ArrayList<Esqueleto> array) throws IOException {

        ArrayList<String> a = new ArrayList<>();
        String sql = "INSERT INTO leitura.tabela_txt (num_documento, cedente_documento, sacado_documento, "
                + "valor_documento, valor_baixa) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;
        System.out.println("Querys Lançadas: ");
        
        try {
            for (Esqueleto esqueleto : array) {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, esqueleto.getNum_domcumento());
                stmt.setString(2, esqueleto.getCedente_documento());
                stmt.setString(3, esqueleto.getSacado_documento());
                stmt.setFloat(4, esqueleto.getValor_documento());
                stmt.setFloat(5, esqueleto.getValor_baixa());
                System.out.println(stmt.toString());
                a.add(stmt.toString());
                stmt.executeUpdate();
            }

            return a;
        } catch (SQLException ex) {
            a.add(ex.toString());
            return a;
        } finally {
            BancoConnection.closeConnection(con, stmt);
        }

    }
}
