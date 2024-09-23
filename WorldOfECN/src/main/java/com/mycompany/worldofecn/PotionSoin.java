/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara
 */
public class PotionSoin extends Objet {
    private int force;
    private Point2D pos;
    private World monde;

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void disparaitre() {
        //this.monde.getMonde()[pos.getX()][pos.getY()] = '0'; //precisa? Ou vai ter o heroi em cima ja?
        this.pos = null;
        this.force = 0;
    }
    
    public void PotionSoin (int force) {
        this.force = force;
    }
    
    public void PotionSoin (PotionSoin potion) {
        this.force = potion.getForce();
    }
    
    public void PotionSoin () {
        this.force = 0;
    }
    
    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
    
}
