/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara objet
 */
public abstract class Objet {
    private Point2D pos;
    private World monde;
   
    /**
     *
     * @param pos
     * @param monde
     */
    public Objet(Point2D pos, World monde) {
        this.pos = pos;
        this.monde = monde;
    }
    
    /**
     *
     */
    public Objet() {
        this.pos = null;
        this.monde = null;
    }
    
    /**
     *
     * @param o
     */
    public Objet(Objet o) {
        this.pos = new Point2D(o.getPos());
        this.monde = o.getMonde();
    }
    
    /**
     *
     * @return
     */
    public World getMonde() {
        return monde;
    }

    /**
     *
     * @param monde
     */
    public void setMonde(World monde) {
        this.monde = monde;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        if ((this.getMonde() != null) && (this.pos != null)) {
            this.monde.getMonde()[this.pos.getX()][this.pos.getY()] = '0';
            this.getMonde().getObjetMap()[this.getPos().getX()][this.getPos().getY()] = null;
        }
        this.pos = pos;
    }

    /**
     *
     */
    public void disparaitre() {
        //this.monde.getMonde()[pos.getX()][pos.getY()] = '0'; //precisa? Ou vai ter o heroi em cima ja?
        this.monde.getObjetMap()[pos.getX()][pos.getY()] = null;
    }
    
    @Override
    public String toString() {
        return "Objet{" + "pos=" + pos + ", monde=" + monde + '}';
    }
    
    public void affiche(){
        System.out.println(this.toString());
    }

   
}
