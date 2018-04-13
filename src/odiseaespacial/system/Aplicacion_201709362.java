/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.system;

/**
 *
 * @author bruno
 */
public class Aplicacion_201709362 {
    public static javax.swing.JLabel lblNave;
    public static javax.swing.JPanel panelEnemigos;
    public static javax.swing.JPanel panelJuego;
    
public static Integer movimientoNave = 2;
    public static int posicionYNave;
    
    public void iniciarAplicacion(){
        VentanaPrincipal_201709362 ventanaPrincipal = new VentanaPrincipal_201709362();
        ventanaPrincipal.setVisible(true);
    }
}
