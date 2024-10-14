/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author User
 */
public class Nourriture extends Objet implements Utilisable{
    int energie;
    int duree;

    public Nourriture(Point2D pos, World monde, int energie, int duree) {
        super(pos, monde);
        this.energie = energie;
        this.duree = duree;
    }

    public Nourriture() {
        this(null, null, 0, 0);
    }

    public Nourriture(Nourriture n) {
       super(n.getPos(), n.getMonde());
       this.energie = n.getEnergie();
       this.duree = n.getDuree();
    }

    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    
    @Override
    public void MiseAJourDuree(){
        duree = duree - 1;
    }

    @Override
    public String toString() {
        return "Nourriture{" + "energie=" + energie + ", duree=" + duree + '}';
    }
    
    @Override
    public void affiche(){
        System.out.println(toString());
    }
    
    @Override
    public String returnString(){
        return this.toString();
    }
    
}
