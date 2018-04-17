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
public class Bala_201709362 {
    private JLabel lblDisparo;
    private int posicionX;
    private int posicionY;

    public JLabel getLblDisparo() {
        return lblDisparo;
    }

    public void setLblDisparo(JLabel lblDisparo) {
        this.lblDisparo = lblDisparo;
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

    public Bala_201709362() {
    }

    public Bala_201709362(JLabel lblDisparo, int posicionX, int posicionY) {
        this.lblDisparo = lblDisparo;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
}
