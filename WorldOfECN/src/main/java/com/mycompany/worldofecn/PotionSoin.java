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

    public PotionSoin (Point2D p, World m, int force) {
        super(p, m);
        this.force = force;
    }
    
    public PotionSoin (PotionSoin p) {
        super(p);
        this.force = p.getForce();
    }
    
    public PotionSoin () {
        super();
        this.force = 0;
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
    
    @Override
    public void setPos(Point2D pos) {
        super.setPos(pos);
        if (this.getMonde() != null) {
            this.getMonde().getMonde()[this.getPos().getX()][this.getPos().getY()] = 'X';
            this.getMonde().getObjets()[this.getPos().getX()][this.getPos().getY()] = this;
        }
    }
}
