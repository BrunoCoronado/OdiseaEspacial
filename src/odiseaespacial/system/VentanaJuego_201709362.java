/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.system;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import odiseaespacial.bean.Enemigo_201709362;

/**
 *
 * @author bruno
 */
public class VentanaJuego_201709362 extends javax.swing.JFrame{
    //dimensiones ventana
    private final int ALTO_VENTANA = 880;
    private final int ANCHO_VENTANA = 1800;
    //bounds panel
    private final int POSICION_X_PANEL = 10;
    private final int POSICION_Y_PANEL = 100;
    //hilos
    private DisparoNave_201709362 hiloDisparoNave = new DisparoNave_201709362();
    private AccionesItem_201709362 hiloAccionesItem = new AccionesItem_201709362();
    private Cronometro_201709362 hiloCronometro = new Cronometro_201709362();
    
    private boolean disparoLanzado=true;
    /**
     * Creates new form VentanaJuego_201709362
     */
    public VentanaJuego_201709362() {
        initComponents();
        initPropiedadesVentanta();
        initPanelDeJuego();
        initIndicadores();
        initEnemigos();
        initHilos();
    }
    
    private void initIndicadores() {
        lblPuntos.setText("0");
        lblVelocidad.setText("x1");
        Aplicacion_201709362.segundos = Aplicacion_201709362.configuracion.getDuracionPartida();
        lblTiempo.setText(Aplicacion_201709362.segundos+" s");
    }
    
    private void initPropiedadesVentanta() {
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        setResizable(false);
        addKeyListener(new ManejoDeTeclas_201709362());
    }

    private void initPanelDeJuego() {
        Aplicacion_201709362.panelJuego = new JPanel();
        Aplicacion_201709362.panelJuego.setBackground(Color.BLACK);
        Aplicacion_201709362.panelJuego.setOpaque(true);
        Aplicacion_201709362.panelJuego.setLayout(null);
        Aplicacion_201709362.panelJuego.setBounds(POSICION_X_PANEL, POSICION_Y_PANEL, Aplicacion_201709362.ANCHO_PANEL_ESPACIO, Aplicacion_201709362.ALTO_PANEL_ESPACIO);
        add(Aplicacion_201709362.panelJuego);
        
        
        Aplicacion_201709362.lblNave = new JLabel();
        Aplicacion_201709362.lblNave.setBackground(Color.RED);
        Aplicacion_201709362.lblNave.setOpaque(true);
        Aplicacion_201709362.panelJuego.add(Aplicacion_201709362.lblNave);
        Aplicacion_201709362.lblNave.setBounds(0,Aplicacion_201709362.posicionYNave,Aplicacion_201709362.ANCHO_NAVE,Aplicacion_201709362.ANCHO_NAVE);
    }
    
    private void initHilos(){
        //instanciar el hilo verificador de la victoria o derrota
        VerificadorVictoria verificadorVictoria = new VerificadorVictoria();
        //iniciamos los hilos, para las acciones de del juego
        hiloDisparoNave.start();
        if (Aplicacion_201709362.configuracion.getContadorItems()!=0) {
            hiloAccionesItem.start();
        }
        hiloCronometro.start();
        Aplicacion_201709362.hiloMovimientoNave.start();
        Aplicacion_201709362.hiloMovimientoEnemigos.start();
        verificadorVictoria.start();       
        
    }
    
    public void initEnemigos(){
        for (int columna = 0; columna < 5; columna++) {
            for (int fila = 0; fila < 8; fila++) {
                JLabel lblEnemigo = new JLabel();
                int coordenadaX = 1450+(88*columna);
                int coordenadaY = 25+(88*fila);
                int salud = 0;
                int tipo = 0;
                switch(columna){
                    case 0:
                        lblEnemigo.setIcon(new ImageIcon(getClass().getResource("../sprites/monster6.gif")));
                        salud = 2;
                        tipo = 1;
                        break;
                    case 1:
                        lblEnemigo.setIcon(new ImageIcon(getClass().getResource("../sprites/monster6.gif")));
                        salud = 3;
                        tipo = 2;
                        break;
                    case 2:
                        lblEnemigo.setIcon(new ImageIcon(getClass().getResource("../sprites/monster1.gif")));
                        salud = 3;
                        tipo = 2;
                        break;
                    case 3:
                        lblEnemigo.setIcon(new ImageIcon(getClass().getResource("../sprites/monster1.gif")));
                        //lblEnemigo.setBackground(Color.GREEN);
                        salud = 4;
                        tipo = 3;
                        break;
                    case 4:
                        lblEnemigo.setIcon(new ImageIcon(getClass().getResource("../sprites/monster3.gif")));
                        salud = 4;
                        tipo = 3;
                        break;
                }
                lblEnemigo.setOpaque(true);
                lblEnemigo.setBounds(coordenadaX, coordenadaY, 83, 83);
                Enemigo_201709362 enemigo = new Enemigo_201709362(lblEnemigo,tipo, coordenadaX, coordenadaY,salud);
                Aplicacion_201709362.enemigos.add(enemigo);
                Aplicacion_201709362.panelJuego.add(lblEnemigo);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblVelocidad = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();

        jLabel25.setText("jLabel25");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PUNTOS");

        jLabel2.setText("VELOCIDAD");

        jLabel3.setText("TIEMPO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblVelocidad)))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTiempo)
                    .addComponent(jLabel3))
                .addContainerGap(416, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuntos)
                    .addComponent(lblVelocidad)
                    .addComponent(lblTiempo))
                .addContainerGap(566, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public class ManejoDeTeclas_201709362 implements KeyListener{
        //movimiento nave----0 arriba-1 abajo
        @Override
        public void keyPressed(KeyEvent ke) {
            ejecutarAccionTeclado(0, ke.getKeyCode());
        }

        @Override
        public void keyTyped(KeyEvent ke) {}

        @Override
        public void keyReleased(KeyEvent ke) {
            ejecutarAccionTeclado(1, ke.getKeyCode());
        }
    }
    //0 presionado - 1 soltado 
    private void ejecutarAccionTeclado(int estado, int tecla){
        switch(tecla){
            case KeyEvent.VK_UP:
                if (estado == 0) {
                    Aplicacion_201709362.movimientoNave = 0;
                }else{
                    Aplicacion_201709362.movimientoNave = 2;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (estado == 0) {
                    Aplicacion_201709362.movimientoNave = 1;
                }else{
                    Aplicacion_201709362.movimientoNave = 2;
                }
                break;
            case KeyEvent.VK_SPACE:
                if (estado == 0) {
                    if (disparoLanzado) {
                        hiloDisparoNave.condicionesDeDisparo(true,Aplicacion_201709362.ANCHO_NAVE, (Aplicacion_201709362.posicionYNave+70));
                        disparoLanzado=false;
                    }
                }else{
                    disparoLanzado=true;
                }
                break;
            case KeyEvent.VK_ESCAPE:
                if (estado != 1  && Aplicacion_201709362.estadoJuego==0) {
                    if (!Aplicacion_201709362.juegoPausado) {
                        System.out.println("juego pausado");
                        Aplicacion_201709362.juegoPausado=true;
                        //parar timers o hilos
                        hiloDisparoNave.pausarTimerDisparos();
                        hiloAccionesItem.pausarTimerAccionesItem();
                        hiloCronometro.pausarTimerCronometro();
                        Aplicacion_201709362.hiloMovimientoNave.pausarTimerMovimientoNave();
                        Aplicacion_201709362.hiloMovimientoEnemigos.pausarTimerMovimientoEnemigos();
                    }else{
                        System.out.println("juego reanudado");
                        Aplicacion_201709362.juegoPausado=false;
                        //continuar hilos
                        hiloDisparoNave.reanudarTimerDisparos();
                        hiloAccionesItem.reanudarTimerAccionesItem();
                        hiloCronometro.reanudarTimerCronometro();
                        Aplicacion_201709362.hiloMovimientoNave.reanudarTimerMovimientoNave();
                        Aplicacion_201709362.hiloMovimientoEnemigos.reanudarTimerMovimientoEnemigos();
                    }
                }
                break;
        }
    }
    
    private class VerificadorVictoria extends Thread{
        private Timer verificadorVictoria;
        @Override
        public void run() {
            verificadorVictoria = new Timer(250, (ae) -> {
                //estado de la partida
                if (Aplicacion_201709362.estadoJuego!=0) {
                    switch(Aplicacion_201709362.estadoJuego){
                        case 1:
                            System.out.println("victoria");
                            pararJuego();
                            break;
                        case 2:
                            System.out.println("derrota");
                            pararJuego();
                            break;
                    }
                }
            });
            verificadorVictoria.start();
        }
    
        private void pararJuego(){
            try {
                hiloDisparoNave.pausarTimerDisparos();
                hiloAccionesItem.pausarTimerAccionesItem();
                hiloCronometro.pausarTimerCronometro();
                Aplicacion_201709362.hiloMovimientoNave.pausarTimerMovimientoNave();
                Aplicacion_201709362.hiloMovimientoEnemigos.pausarTimerMovimientoEnemigos();
                verificadorVictoria.stop();
            } catch (Exception e) {
                System.out.println("error al finalizar juego");
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel lblPuntos;
    public static javax.swing.JLabel lblTiempo;
    public static javax.swing.JLabel lblVelocidad;
    // End of variables declaration//GEN-END:variables
}
