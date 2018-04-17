/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odiseaespacial.bean;

import javax.swing.JLabel;

/**
 *
 * @author bruno
 */
public class Item_201709362 {
    private JLabel lblItem;
    private int posicionX;
    private int posicionY;
    private int tipo;

    public JLabel getLblItem() {
        return lblItem;
    }

    public void setLblItem(JLabel lblItem) {
        this.lblItem = lblItem;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Item_201709362(JLabel lblItem, int posicionX, int posicionY, int tipo) {
        this.lblItem = lblItem;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tipo = tipo;
    }

    public Item_201709362() {
    }
}
