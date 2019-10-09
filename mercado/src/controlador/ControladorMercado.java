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
      
      public static void alterar(ManutencaoMercado man){
        Mercado objeto = new Mercado();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNomefantasia(man.jtfNomefantasia.getText());
        objeto.setRazaosocial(man.jtfRazaosocial.getText());
        objeto.setNrdefuncionarios(Integer.parseInt(man.jtfNrdefuncionarios.getText()));
        objeto.setFundacao(LocalDate.parse(man.jtfFundacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setValor(Double.parseDouble(man.jtfValor.getText()));
        
        boolean resultado = MercadoDao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      
      public static void excluir(ManutencaoMercado man){
        Mercado objeto = new Mercado();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado;
        resultado = MercadoDao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
