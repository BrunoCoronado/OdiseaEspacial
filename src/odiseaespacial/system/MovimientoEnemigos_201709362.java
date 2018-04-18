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
    private final int ALTO_ENEMIGO = 83;
    private final int ANCHO_ENEMIGO = 83;
    
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
                            verificarGolpeConNave(movimeintoEnX, movimientoEnY);
                            verificarPosicionLimite(movimeintoEnX);
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
                            verificarGolpeConNave(x, y);
                            verificarPosicionLimite(x);
                        }
                        break;
                }   
                Aplicacion_201709362.panelJuego.repaint();
            } catch (Exception e) {
                System.out.println("error al mover enemigos");
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
    
    private void verificarGolpeConNave(int posicionXEnemigo, int posicionYEnemigo){
        if(posicionXEnemigo <= Aplicacion_201709362.ANCHO_NAVE){
            int a = Aplicacion_201709362.posicionYNave;
            int b = Aplicacion_201709362.posicionYNave + Aplicacion_201709362.ALTO_NAVE;
            int c = posicionYEnemigo;
            int d = posicionYEnemigo + ALTO_ENEMIGO;
            if(c<=b){
                if (d>=a) {
                    Aplicacion_201709362.estadoJuego = 2;
                }
            }
        }
    }
    
    private void verificarPosicionLimite(int posicionXEnemigo){
        if (posicionXEnemigo<=0) {
            Aplicacion_201709362.estadoJuego = 2;
            timer.stop();
        }
    }
}
