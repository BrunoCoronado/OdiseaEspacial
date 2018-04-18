/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.system;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
import odiseaespacial.bean.Bala_201709362;

/**
 *
 * @author TrexT
 */
public class DisparoNave_201709362 extends Thread{
    //listas de disparos, arraylist para no tener limite de disparos
    private ArrayList<Bala_201709362> disparos = new ArrayList<Bala_201709362>();
    //tamaño disparo
    private final int ALTO_BALA=5;
    private final int ANCHO_BALA=15;
    //booleano para ver estado del disparo 
    private boolean disparoLanzado=false;
    private boolean disparoEnTrayecto = false;
    //contador de disparos
    //objeto bala
    Bala_201709362 bala;
    //Timer
    Timer timer;
    @Override
    public void run() {
        timer = new Timer(5, (ae) -> {
            if(disparoLanzado){
                try {
                    JLabel lblDisparo = new JLabel();
                    lblDisparo.setBackground(Color.WHITE);
                    lblDisparo.setOpaque(true);
                    lblDisparo.setBounds(bala.getPosicionX(), bala.getPosicionY(), ANCHO_BALA, ALTO_BALA);
                    bala.setLblDisparo(lblDisparo);
                    disparos.add(bala);
                    Aplicacion_201709362.panelJuego.add(disparos.get(disparos.size()-1).getLblDisparo());
                    disparoEnTrayecto = true;
                    disparoLanzado=false;
                } catch (Exception e) {
                    System.out.println("erro al crear bala en  el panel");
                }
            }
            if(disparoEnTrayecto){
                try {
                    for (int i = 0; i < disparos.size(); i++) {
                        //verificar si golpea la bala, devuelve un booleano
                        if(!verificarGolpe(disparos.get(i).getPosicionX(), disparos.get(i).getPosicionY(),i)){
                            //mover bala
                            disparos.get(i).setPosicionX(disparos.get(i).getPosicionX()+5);
                            disparos.get(i).getLblDisparo().setBounds(disparos.get(i).getPosicionX(), disparos.get(i).getPosicionY(), ANCHO_BALA, ALTO_BALA);
                            //en caso se salga de panel, se elimina
                            if (disparos.get(i).getPosicionX() >= Aplicacion_201709362.ANCHO_PANEL_ESPACIO) {
                                disparos.remove(i);
                            }
                        }
                    }   
                } catch (Exception e) {
                    System.out.println("error en mover/golpe de bala");
                }
            }
            if (disparos.isEmpty()) {
                disparoEnTrayecto=false;
            }
            Aplicacion_201709362.panelJuego.repaint();
        });
        timer.start();
    }
    
    public void condicionesDeDisparo(boolean disparo, int x, int y){
        disparoLanzado = disparo;
        bala = new Bala_201709362();
        bala.setPosicionX(x);
        bala.setPosicionY(y);
    }

    private boolean verificarGolpe(int posicionX, int posicionY, int index) {
        for (int i = 0; i < Aplicacion_201709362.enemigos.size(); i++) {
            int a = Aplicacion_201709362.enemigos.get(i).getPosicionY();
            int b = Aplicacion_201709362.enemigos.get(i).getPosicionY()+83;
            int c = posicionY;
            int d = posicionY+5;
            if ((posicionX+ANCHO_BALA)>=Aplicacion_201709362.enemigos.get(i).getPosicionX()) {
                if (c<=b) {
                    if(d>=a){
                        try {
                            //eliminar bala
                            Aplicacion_201709362.panelJuego.remove(disparos.get(index).getLblDisparo());
                            disparos.remove(index);
                            //dañar enemigo
                            Aplicacion_201709362.enemigos.get(i).setSalud(Aplicacion_201709362.enemigos.get(i).getSalud()-1);
                            if (Aplicacion_201709362.enemigos.get(i).getSalud() <= 0) {
                                //eliminar enemigo en posicion i
                                Aplicacion_201709362.contadorEnemigosTotal--;
                                revisarVelocidadEnemigos(Aplicacion_201709362.enemigos.get(i).getTipo());
                                añadirPuntos(Aplicacion_201709362.enemigos.get(i).getTipo());
                                Aplicacion_201709362.panelJuego.remove(Aplicacion_201709362.enemigos.get(i).getLblEnemigo());
                                Aplicacion_201709362.enemigos.remove(i);
                            }
                            Aplicacion_201709362.panelJuego.repaint();
                            return true;
                        } catch (Exception e) {
                            System.out.println("error al colisionar bala");
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private void revisarVelocidadEnemigos(int tipo){
        switch(tipo){
            case 1:
                Aplicacion_201709362.contadorEnemigosTipo1--;
                if (Aplicacion_201709362.contadorEnemigosTipo1==0) {
                    Aplicacion_201709362.hiloMovimientoEnemigos.cambioEnLaVelocidadDeEnemigos(15);
                    VentanaJuego_201709362.lblVelocidad.setText("x1.5");
                }
                break;
            case 2:
                Aplicacion_201709362.contadorEnemigosTipo2--;
                if (Aplicacion_201709362.contadorEnemigosTipo2==0) {
                    Aplicacion_201709362.hiloMovimientoEnemigos.cambioEnLaVelocidadDeEnemigos(20);
                    VentanaJuego_201709362.lblVelocidad.setText("x2");
                }
                break;
        }
    }

    private void añadirPuntos(int tipo) {
        switch(tipo){
            case 1:
                Aplicacion_201709362.puntos=Aplicacion_201709362.puntos+10;
                break;
            case 2:
                Aplicacion_201709362.puntos=Aplicacion_201709362.puntos+20;
                break;
            case 3:
                Aplicacion_201709362.puntos=Aplicacion_201709362.puntos+30;
                break;
        }
        VentanaJuego_201709362.lblPuntos.setText(""+Aplicacion_201709362.puntos);
    }
    
    public void pausarTimerDisparos(){
        timer.stop();
    }
    
    public void reanudarTimerDisparos(){
        timer.start();
    }
}
