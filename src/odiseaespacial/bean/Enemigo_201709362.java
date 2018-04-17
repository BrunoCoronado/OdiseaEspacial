/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.bean;

import javax.swing.JLabel;

/**
 *
 * @author TrexT
 */
public class Enemigo_201709362 {
    private JLabel lblEnemigo;
    private int tipo;
    private int posicionX;
    private int posicionY;
    private int salud;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
    
    public JLabel getLblEnemigo() {
        return lblEnemigo;
    }

    public void setLblEnemigo(JLabel lblEnemigo) {
        this.lblEnemigo = lblEnemigo;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public Enemigo_201709362(JLabel lblEnemigo, int tipo, int posicionX, int posicionY, int salud) {
        this.lblEnemigo = lblEnemigo;
        this.tipo = tipo;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.salud = salud;
    }
    
    public Enemigo_201709362() {
    }
}
