/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.system;

import javax.swing.Timer;
import static odiseaespacial.system.VentanaJuego_201709362.lblTiempo;

/**
 *
 * @author TrexT
 */
public class Cronometro_201709362 extends Thread{
    Timer tiempo;
    
    @Override
    public void run() {
        tiempo = new Timer(1000, (ae) -> {
            if (Aplicacion_201709362.segundos>0) {
                lblTiempo.setText(Aplicacion_201709362.segundos+" s");
                Aplicacion_201709362.segundos--;
            }else{
                lblTiempo.setText(Aplicacion_201709362.segundos+" s");
                Aplicacion_201709362.estadoJuego = 2;
            }
            //efecto del item congelar
            if (Aplicacion_201709362.tiempoCongelacion<=0) {
                Aplicacion_201709362.congelacion=false;
            }
            if (Aplicacion_201709362.congelacion) {
                Aplicacion_201709362.tiempoCongelacion--;
            }
            //efecto boost velocidad nave
            if (Aplicacion_201709362.tiempoBoostVelocidadNave<=0) {
                Aplicacion_201709362.boostVelocidadNave=false;
                Aplicacion_201709362.hiloMovimientoNave.cambioEnLaVelocidadDeEnemigos(10);
            }
            //contador del tiempo del boost de velocidad
            if (Aplicacion_201709362.boostVelocidadNave) {
                Aplicacion_201709362.tiempoBoostVelocidadNave--;
            }
            //contador de enemigos en el juego
            if (Aplicacion_201709362.contadorEnemigosTotal<=0) {
                Aplicacion_201709362.estadoJuego=1;
            }
        });
        tiempo.start();
    }
    
    public void pausarTimerCronometro(){
        tiempo.stop();
    }
    
    public void reanudarTimerCronometro(){
        tiempo.restart();
    }
}
