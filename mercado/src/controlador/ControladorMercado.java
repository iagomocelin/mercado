/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.MercadoDao;
import javax.swing.JOptionPane;
import modelo.Mercado;
import tela.manutencao.ManutencaoMercado;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;    
/**
 *
 * @author Administrador
 */
public class ControladorMercado {
    public static void inserir(ManutencaoMercado man){
        Mercado objeto = new Mercado();
        objeto.setNomefantasia(man.jtfNomefantasia.getText());
        objeto.setRazaosocial(man.jtfRazaosocial.getText());
        objeto.setFundacao(LocalDate.parse(man.jtfFundacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setNrdefuncionarios(Integer.parseInt(man.jtfNrdefuncionarios.getText()));
        objeto.setValor(Double.parseDouble(man.jtfValor.getText()));
        
        boolean resultado = MercadoDao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
      public static boolean alterar(Mercado objeto) {
        String sql = "UPDATE mercado SET nomefantasia = ?, razaosocial = ?, fundacao = ?,  WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setString(2, objeto.getDescricao());
            ps.setInt(3, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
