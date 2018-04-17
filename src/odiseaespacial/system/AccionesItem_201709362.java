/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.system;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import odiseaespacial.bean.Item_201709362;

/**
 *
 * @author TrexT
 */
public class AccionesItem_201709362 extends Thread{
    
    private ArrayList<Item_201709362> items = new ArrayList<Item_201709362>();
    
    private Timer timerGenerarItems;
    private Timer timerMoverItems;
    
    //tamaño item
    private final int ALTO_ITEM=25;
    private final int ANCHO_ITEM=25;
    
    private Random numeroAleatorio = new Random();
    
    @Override
    public void run() {
        //generar objetos en posiciones aleatorias cada x timepo
        generarItem();
        //mover objetos generados
        moverItem();
    }
    
    private void generarItem(){
        timerGenerarItems = new Timer(Aplicacion_201709362.configuracion.getFrecuenciaItems(), (ae) -> {
            try {
                //generar item
                int tipo = validarGenerarItem( 1+numeroAleatorio.nextInt(6));
                int posicionX = (200+numeroAleatorio.nextInt(Aplicacion_201709362.ANCHO_PANEL_ESPACIO-500));
                int posicionY = (10+numeroAleatorio.nextInt(Aplicacion_201709362.ALTO_PANEL_ESPACIO-10));
                JLabel lblItem = new JLabel(""+tipo);
                lblItem.setBackground(Color.ORANGE);
                lblItem.setOpaque(true);
                lblItem.setBounds(posicionX, posicionY, ANCHO_ITEM, ALTO_ITEM);
                items.add(new Item_201709362(lblItem, posicionX, posicionY, tipo));
                Aplicacion_201709362.panelJuego.add(items.get(items.size()-1).getLblItem()); 
                
            } catch (Exception e) {
                System.out.println("error al crear item");
            }
        });
        timerGenerarItems.start();
    }
    
    private int validarGenerarItem(int tipo){
        switch(tipo){
            case 1:
                if (Aplicacion_201709362.configuracion.isAumentoTiempo()) {
                    return 1;
                }else{
                    return validarGenerarItem( 1+numeroAleatorio.nextInt(6));
                }
            case 2:
                if (Aplicacion_201709362.configuracion.isPuntosExtra()) {
                    return 2;
                }else{
                    return  validarGenerarItem( 1+numeroAleatorio.nextInt(6));
                }
            case 3:
                if (Aplicacion_201709362.configuracion.isAumentoVelocidad()) {
                    return 3;
                }else{
                    return validarGenerarItem( 1+numeroAleatorio.nextInt(6));
                }
            case 4:
                if (Aplicacion_201709362.configuracion.isDisminucionTiempo()) {
                    return 4;
                }else{
                    return validarGenerarItem( 1+numeroAleatorio.nextInt(6));
                }
            case 5:
                if (Aplicacion_201709362.configuracion.isPenalizacion()) {
                    return 5;
                }else{
                    return validarGenerarItem( 1+numeroAleatorio.nextInt(6));
                }
            case 6:
                if (Aplicacion_201709362.configuracion.isCongelacion()) {
                    return 6;
                }else{
                    return validarGenerarItem( 1+numeroAleatorio.nextInt(6));
                }
        }
        return 0;
    }
    
    private void moverItem(){
        timerMoverItems = new Timer(50, (ae) -> {
            try {
                if (!items.isEmpty()) {
                    for (int i = 0; i < items.size(); i++) {
                        //verificar golpe
                        //mover item
                        if(!verificarGolpe(items.get(i).getPosicionX(),items.get(i).getPosicionY(),i)) {
                            items.get(i).setPosicionX(items.get(i).getPosicionX()-5);
                            items.get(i).getLblItem().setBounds(items.get(i).getPosicionX(), items.get(i).getPosicionY(), ANCHO_ITEM, ALTO_ITEM);
                            //en caso se salga de panel, se elimina
                            if ((items.get(i).getPosicionX()+ANCHO_ITEM) <= 0) {
                                items.remove(i);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("error al mover item");
            }
        });
        timerMoverItems.start();
    }
    
    private boolean verificarGolpe(int posicionX, int posicionY, int index){
        int a = Aplicacion_201709362.posicionYNave;
        int b = Aplicacion_201709362.posicionYNave + Aplicacion_201709362.ALTO_NAVE;
        int c = posicionY; 
        int d = posicionY + ALTO_ITEM;
        if (posicionX<=Aplicacion_201709362.ANCHO_NAVE) {
            if (c<=b) {
                if(d>=a) {
                    try {
                        aplicarEfecto(items.get(index).getTipo());
                        Aplicacion_201709362.panelJuego.remove(items.get(index).getLblItem());
                        items.remove(index);
                        Aplicacion_201709362.panelJuego.repaint();
                        return true;
                    } catch (Exception e) {
                        System.out.println("error al colisionar item");
                    }
                }
            }
        }
        return false;
    }
    
    //tipos de item:1-aumento tiempo,2-puntos extra, 3-aumento velocidad
    //              4-disminucion tiempo, 5-penalizacion, 6-congelacion
    private void aplicarEfecto(int tipo){
        try {
            switch(tipo){
               case 1:
                   System.out.println("aumentados 10s");
                   Aplicacion_201709362.segundos = Aplicacion_201709362.segundos+10;
                   VentanaJuego_201709362.lblTiempo.setText(Aplicacion_201709362.segundos+" s");
                   break;
               case 2:
                   System.out.println("puntos +10");
                   Aplicacion_201709362.puntos = Aplicacion_201709362.puntos+10;
                   VentanaJuego_201709362.lblPuntos.setText(""+Aplicacion_201709362.puntos);
                   break;
               case 3:
                   System.out.println("velocidad nave x2");
                   Aplicacion_201709362.boostVelocidadNave = true;
                   Aplicacion_201709362.tiempoBoostVelocidadNave = 10;
                   Aplicacion_201709362.hiloMovimientoNave.cambioEnLaVelocidadDeEnemigos(50);
                   break;
               case 4:
                   System.out.println("restados 10s");
                   Aplicacion_201709362.segundos = Aplicacion_201709362.segundos-10;
                   VentanaJuego_201709362.lblTiempo.setText(Aplicacion_201709362.segundos+" s");
                   break;
               case 5:
                   System.out.println("puntos -10");
                   Aplicacion_201709362.puntos = Aplicacion_201709362.puntos-10;
                   VentanaJuego_201709362.lblPuntos.setText(""+Aplicacion_201709362.puntos);
                   break;
               case 6:
                   System.out.println("congelacion 5s");
                   Aplicacion_201709362.congelacion=true;
                   Aplicacion_201709362.tiempoCongelacion = 5;
                   break;
           }   
        } catch (Exception e) {
            System.out.println("erro al añadir efecto");
        }
    }
    
    public void pausarTimerAccionesItem(){
        timerGenerarItems.stop();
        timerMoverItems.stop();
    }
    
    public void reanudarTimerAccionesItem(){
        timerGenerarItems.restart();
        timerMoverItems.restart();
    }
}
