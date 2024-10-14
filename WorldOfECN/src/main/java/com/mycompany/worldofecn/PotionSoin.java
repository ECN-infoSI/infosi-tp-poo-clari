/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara
 */
public class PotionSoin extends Objet implements Utilisable{
    private int force;
    private int duree;

    /**
     *
     * @param p Position de la potion
     * @param m 
     * @param force Force que la potion rend au personnage qui la bois
     * @param duree Duree de l'effet sur le joueur une fois activé
     */
    public PotionSoin (Point2D p, World m, int force, int duree) {
        super(p, m);
        this.force = force;
        this.duree = duree;
    }
    
    /**
     *
     * @param p
     */
    public PotionSoin (PotionSoin p) {
        super(p);
        this.force = p.getForce();
        this.duree = p.getDuree();
    }
    
    /**
     *
     */
    public PotionSoin () {
        super();
        this.force = 0;
        this.duree = 0;
    }
    
    
    @Override
    public void MiseAJourDuree(){
        duree = duree - 1;
    }
        
    /**
     *
     * @return
     */
    public int getForce() {
        return force;
    }

    /**
     *
     * @param force
     */
    public void setForce(int force) {
        this.force = force;
    }
    
    /**
     *
     * @param pos
     */
    @Override
    public void setPos(Point2D pos) {
        super.setPos(pos);
        if (this.getMonde() != null) {
            this.getMonde().getMonde()[this.getPos().getX()][this.getPos().getY()] = 'X';
            this.getMonde().getObjetMap()[this.getPos().getX()][this.getPos().getY()] = this;
        }
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "PotionSoin{" + "force=" + force + ", duree=" + duree + '}';
    }
    
    
    @Override
    public void affiche() {
        System.out.println(this.toString());
    }
    
    @Override
    public String returnString(){
        return this.toString();
    }

}
