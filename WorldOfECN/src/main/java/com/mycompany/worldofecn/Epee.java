/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara et Larissa
 */
public class Epee extends Objet implements Utilisable {
    private int duree;
    
    public Epee(Point2D pos, World monde, int duree) {
        super(pos, monde);
        this.duree = duree;
    }

    public Epee() {
        super();
        duree = 0;
    }

    public Epee(Epee p) {
        super( (Objet) p);
        duree = p.getDuree();
    }
    
    @Override
    public void MiseAJourDuree(){
        duree = duree - 1;
    }
    
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    

    @Override
    public String toString() {
        return "Epee {duree =" + this.duree + "}" + super.toString();
    }
    
    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println(this.toString());
    }
    
    @Override
    public String returnString(){
        return this.toString();
    }
    
    
}
