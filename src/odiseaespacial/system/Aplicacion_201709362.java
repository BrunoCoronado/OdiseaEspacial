/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.system;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import odiseaespacial.bean.Configuracion_201709362;
import odiseaespacial.bean.Enemigo_201709362;

/**
 *
 * @author bruno
 */
public class Aplicacion_201709362 {
    //ventana principal del juego estatica
    public static VentanaPrincipal_201709362 ventanaPrincipal = new VentanaPrincipal_201709362();
    //Configuracion del juego---se crea una configuracion default 
    public static Configuracion_201709362 configuracion = new Configuracion_201709362();
    //componentes estaticos
    public static javax.swing.JLabel lblNave;
    public static JPanel panelJuego;
    //variables estaticas
    public static Integer movimientoNave = 2;
    public static int posicionYNave = 268;
    
    public static int contadorEnemigosTipo1 = 8;
    public static int contadorEnemigosTipo2 = 16;
    public static int contadorEnemigosTotal = 40;
    
    public static boolean juegoPausado;
    //entero estatico que define el estado de juego- 0 en curso - 1 victorie - 2 derrota
    public static int estadoJuego = 0;
    //indicadores
    public static int puntos = 0;
    public static int segundos = 90;
    //contadores items
    public static int tiempoCongelacion = 0;
    public static boolean congelacion;
    public static int tiempoBoostVelocidadNave = 0;
    public static boolean boostVelocidadNave;
    //public static int contadorEnemigosTipo3 = 16;
    //constantes estaticas
    public static final int ALTO_NAVE=150;
    public static final int ANCHO_NAVE=80;
    
    //public static final int VELOCIDAD_ENEMIGOS = 750;
    public static final int VELOCIDAD_NAVE = 5; 
    //propiedades del panel
    public static final int ALTO_PANEL_ESPACIO = 735;
    public static final int ANCHO_PANEL_ESPACIO = 1770;
    
    //lista de los enemigos
    public static ArrayList<Enemigo_201709362> enemigos = new ArrayList<Enemigo_201709362>();
    
    //hilos
    public static MovimientoEnemigos_201709362 hiloMovimientoEnemigos = new MovimientoEnemigos_201709362();
    public static MovimientoNave_201709362 hiloMovimientoNave = new MovimientoNave_201709362();
    
    public void iniciarAplicacion(){
        ventanaPrincipal.setVisible(true);
    }
}
