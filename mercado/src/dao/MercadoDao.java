/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Mercado;
import java.sql.Date;
/**
 *
 * @author Administrador
 */
public class MercadoDao {
    public static boolean inserir(Mercado objeto) {
        String sql = "INSERT INTO mercado (nomefantasia, razaosocial, fundacao, nrdefuncionarios, valor) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNomefantasia());
            ps.setString(2, objeto.getRazaosocial());
            ps.setDate(3, Date.valueOf(objeto.getFundacao()));
            ps.setInt(4, objeto.getNrdefuncionarios());
            ps.setDouble(5, objeto.getValor());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
       public static boolean alterar(Mercado objeto) {
        String sql = "UPDATE mercado SET nomefantasia = ?, razaosocial = ?, fundacao = ?, nrdefuncionarios = ?, valor = ?  WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNomefantasia()); 
            ps.setString(2, objeto.getRazaosocial());
            ps.setDate(3, Date.valueOf(objeto.getFundacao()));
            ps.setInt(4, objeto.getNrdefuncionarios());
            ps.setDouble(5, objeto.getValor());
            ps.setInt(6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean excluir(Mercado objeto) {
        String sql = "DELETE FROM mercado WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
