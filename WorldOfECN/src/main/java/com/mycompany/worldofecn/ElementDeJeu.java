/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author User
 */
public abstract class ElementDeJeu {
    private Point2D pos;
    private World monde;

    public ElementDeJeu(Point2D pos, World monde) {
        this.pos = pos;
        this.monde = monde;
    }
    
    /**
     *
     * @param e ElementDeJeu
     */
    public ElementDeJeu(ElementDeJeu e) {
        this(new Point2D(e.getPos()),
             e.getMonde());
    }

    /**
     * Constructeur par défaut
     */
    public ElementDeJeu() {
        this(null, null);
    }

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

    public World getMonde() {
        return monde;
    }

    public void setMonde(World monde) {
        this.monde = monde;
    }
    
    @Override
    public String toString() {
        return "ElementDeJeu{" + "pos=" + pos + ", monde=" + monde + '}';
    }
    
    public void affiche(){
        System.out.println(this.toString());
    }
    
}
