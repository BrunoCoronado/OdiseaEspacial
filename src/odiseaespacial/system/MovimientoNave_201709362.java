/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.system;
import javax.swing.Timer;
/**
 *
 * @author bruno
 */
public class MovimientoNave_201709362 extends Thread{
    //constantes de movimiento
    private final int MOVIMIENTO_ARRIBA = 0;
    private final int MOVIMIENTO_ABAJO = 1;
    
    private Timer timer;
    @Override
    public void run() {
        timer = new Timer(Aplicacion_201709362.VELOCIDAD_NAVE, (ae) -> {
            if (!Aplicacion_201709362.congelacion) {
                switch(Aplicacion_201709362.movimientoNave){
                    // 0 arriba - 1 abajo
                    case MOVIMIENTO_ARRIBA:
                        Aplicacion_201709362.posicionYNave = Aplicacion_201709362.posicionYNave-2;
                        if(Aplicacion_201709362.posicionYNave<0){
                            Aplicacion_201709362.posicionYNave=0;
                        }
                        break;
                    case MOVIMIENTO_ABAJO:
                        Aplicacion_201709362.posicionYNave = Aplicacion_201709362.posicionYNave+2;
                        if(Aplicacion_201709362.posicionYNave>(Aplicacion_201709362.ALTO_PANEL_ESPACIO-Aplicacion_201709362.ALTO_NAVE)){
                            Aplicacion_201709362.posicionYNave=Aplicacion_201709362.ALTO_PANEL_ESPACIO-Aplicacion_201709362.ALTO_NAVE;
                        }
                        break;
                }
                Aplicacion_201709362.lblNave.setBounds(0, Aplicacion_201709362.posicionYNave, Aplicacion_201709362.ANCHO_NAVE, Aplicacion_201709362.ALTO_NAVE);
                Aplicacion_201709362.panelJuego.repaint();
            }
        });
        timer.setInitialDelay(Aplicacion_201709362.VELOCIDAD_NAVE);
        timer.start();
    }
    
    public void cambioEnLaVelocidadDeEnemigos(int multiplicador){
        timer.setDelay(Aplicacion_201709362.VELOCIDAD_NAVE/(multiplicador/10));
        timer.restart();
    }
    
    public void pausarTimerMovimientoNave(){
        timer.stop();
    }
    
    public void reanudarTimerMovimientoNave(){
        timer.restart();
    }
}
