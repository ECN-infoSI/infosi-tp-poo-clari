/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 * Decrive un objet dans le jeu
 * @author Clara et Larissa
 */
public abstract class Objet extends ElementDeJeu {
    private Point2D pos;
    private World monde;
   
    /**
     *
     * @param pos Position de l'objet dans le monde 
     * @param monde Carte de tous les personnages et objets du jeu
     */
    public Objet(Point2D pos, World monde) {
        this.pos = pos;
        this.monde = monde;
    }
    
    /**
     * Constructeur par défaut 
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
     * @return monde
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
     * @return pos
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
     * Efface l'objet de la carte du monde
     */
    public void disparaitre() {
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
