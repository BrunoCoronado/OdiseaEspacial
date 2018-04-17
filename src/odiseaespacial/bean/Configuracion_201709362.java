/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.bean;

/**
 *
 * @author TrexT
 */
public class Configuracion_201709362 {
    //configuracion items
    private boolean aumentoTiempo;
    private boolean puntosExtra;
    private boolean aumentoVelocidad;
    private boolean disminucionTiempo;
    private boolean penalizacion;
    private boolean congelacion;
    private int frecuenciaItems;
    private int contadorItems;
    //configuracion velocidad
    private int nivelVelocidad;
    //configuracion duracion partida
    private int duracionPartida;

    public int getContadorItems() {
        return contadorItems;
    }

    public void setContadorItems(int contadorItems) {
        this.contadorItems = contadorItems;
    }
    
    public boolean isAumentoTiempo() {
        return aumentoTiempo;
    }

    public void setAumentoTiempo(boolean aumentoTiempo) {
        this.aumentoTiempo = aumentoTiempo;
    }

    public boolean isPuntosExtra() {
        return puntosExtra;
    }

    public void setPuntosExtra(boolean puntosExtra) {
        this.puntosExtra = puntosExtra;
    }

    public boolean isAumentoVelocidad() {
        return aumentoVelocidad;
    }

    public void setAumentoVelocidad(boolean aumentoVelocidad) {
        this.aumentoVelocidad = aumentoVelocidad;
    }

    public boolean isDisminucionTiempo() {
        return disminucionTiempo;
    }

    public void setDisminucionTiempo(boolean disminucionTiempo) {
        this.disminucionTiempo = disminucionTiempo;
    }

    public boolean isPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(boolean penalizacion) {
        this.penalizacion = penalizacion;
    }

    public boolean isCongelacion() {
        return congelacion;
    }

    public void setCongelacion(boolean congelacion) {
        this.congelacion = congelacion;
    }

    public int getFrecuenciaItems() {
        return frecuenciaItems;
    }

    public void setFrecuenciaItems(int frecuenciaItems) {
        this.frecuenciaItems = frecuenciaItems;
    }

    public int getNivelVelocidad() {
        return nivelVelocidad;
    }

    public void setNivelVelocidad(int nivelVelocidad) {
        this.nivelVelocidad = nivelVelocidad;
    }

    public int getDuracionPartida() {
        return duracionPartida;
    }

    public void setDuracionPartida(int duracionPartida) {
        this.duracionPartida = duracionPartida;
    }

    //al instanciar la configuracion, se crea una configuracion por defecto
    public Configuracion_201709362() {
        this.aumentoTiempo = true;
        this.puntosExtra = true;
        this.aumentoVelocidad = true;
        this.disminucionTiempo = true;
        this.penalizacion = true;
        this.congelacion = true;
        this.frecuenciaItems = 5000;
        this.nivelVelocidad = 750;
        this.duracionPartida = 90;
        this.contadorItems = 1;
    }

    public Configuracion_201709362(boolean aumentoTiempo, boolean puntosExtra, boolean aumentoVelocidad, boolean disminucionTiempo, boolean penalizacion, boolean congelacion, int frecuenciaItems, int nivelVelocidad, int duracionPartida) {
        this.aumentoTiempo = aumentoTiempo;
        this.puntosExtra = puntosExtra;
        this.aumentoVelocidad = aumentoVelocidad;
        this.disminucionTiempo = disminucionTiempo;
        this.penalizacion = penalizacion;
        this.congelacion = congelacion;
        this.frecuenciaItems = frecuenciaItems;
        this.nivelVelocidad = nivelVelocidad;
        this.duracionPartida = duracionPartida;
    }
}
