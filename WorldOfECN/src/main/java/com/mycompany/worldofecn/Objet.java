/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 * Decrive un objet dans le jeu
 * @author Clara et Larissa
 */
public abstract class Objet extends ElementDeJeu{
    /**
     *
     * @param pos Position de l'objet dans le monde 
     * @param monde Carte de tous les personnages et objets du jeu
     */
    public Objet(Point2D pos, World monde) {
        super(pos, monde);
    }
    
    /**
     * Constructeur par défaut 
     */
    public Objet() {
        super();
    }
    
    /**
     *
     * @param o
     */
    public Objet(Objet o) {
        super(o);
    }
    
    /**
     * Efface l'objet de la carte du monde
     */
    public void disparaitre() {
        super.getMonde().getObjetMap()[getPos().getX()][getPos().getY()] = null;
    }
    
    @Override
    public String toString() {
        return "Objet {" + super.toString();
    }
    
    @Override
    public void affiche(){
        System.out.println(this.toString());
    }

   
}
