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
public class MovimientoEnemigos_201709362 extends Thread{
    private final int ALTO_ENEMIGO = 35;
    private final int ANCHO_ENEMIGO = 35;
    
    private int corrienteDeMovimientoY = 0;
    //0 hacia arriba - 1 hacia abajo
    
    private Timer timer;
    @Override
    public void run() {
        timer = new Timer(Aplicacion_201709362.configuracion.getNivelVelocidad(), (ae) -> {
            try {
                switch(corrienteDeMovimientoY){
                    case 0:
                        //resta a y hacia arriba
                        end:
                        for (int i = 0; i < Aplicacion_201709362.enemigos.size(); i++) {
                            int movimeintoEnX = Aplicacion_201709362.enemigos.get(i).getPosicionX()-10;
                            int movimientoEnY = Aplicacion_201709362.enemigos.get(i).getPosicionY();
                            //obtenemos posicion en y, y analizamos su comportamiento
                            movimientoEnY=movimientoEnY-10;
                            if (movimientoEnY<0) {
                                corrienteDeMovimientoY = 1;
                                movimientoEnY=movimientoEnY+10;
                                break end;
                            }
                            //seteamos las nuevas posiciones y seteamos el nuevo bound
                            Aplicacion_201709362.enemigos.get(i).setPosicionX(movimeintoEnX);
                            Aplicacion_201709362.enemigos.get(i).setPosicionY(movimientoEnY);
                            Aplicacion_201709362.enemigos.get(i).getLblEnemigo().setBounds(Aplicacion_201709362.enemigos.get(i).getPosicionX(), Aplicacion_201709362.enemigos.get(i).getPosicionY(), ANCHO_ENEMIGO, ALTO_ENEMIGO);
                        }
                        break;
                    case 1:
                        end:
                        for (int i = 0; i < Aplicacion_201709362.enemigos.size(); i++) {
                            int index = (Aplicacion_201709362.enemigos.size()-1)-i;
                            int x = Aplicacion_201709362.enemigos.get(index).getPosicionX()-10;
                            int y = Aplicacion_201709362.enemigos.get(index).getPosicionY();
                            y=y+10;
                            if (y>(Aplicacion_201709362.ALTO_PANEL_ESPACIO-ALTO_ENEMIGO)) {
                                corrienteDeMovimientoY = 0;
                                y=y-10;
                                break end;
                            }
                            Aplicacion_201709362.enemigos.get(index).setPosicionX(x);
                            Aplicacion_201709362.enemigos.get(index).setPosicionY(y);
                            Aplicacion_201709362.enemigos.get(index).getLblEnemigo().setBounds(Aplicacion_201709362.enemigos.get(index).getPosicionX(), Aplicacion_201709362.enemigos.get(index).getPosicionY(), ANCHO_ENEMIGO, ALTO_ENEMIGO);
                        }
                        break;
                }   
                Aplicacion_201709362.panelJuego.repaint();
            } catch (Exception e) {
                System.out.println("error al mover enemigos");
                e.printStackTrace();
            }
        });
        timer.setInitialDelay(Aplicacion_201709362.configuracion.getNivelVelocidad());
        timer.start();
    }
    
    public void cambioEnLaVelocidadDeEnemigos(int multiplicador){
        timer.setDelay(Aplicacion_201709362.configuracion.getNivelVelocidad()/(multiplicador/10));
        timer.restart();
    }
    
    public void pausarTimerMovimientoEnemigos(){
        timer.stop();
    }
    
    public void reanudarTimerMovimientoEnemigos(){
        timer.restart();
    }
}
