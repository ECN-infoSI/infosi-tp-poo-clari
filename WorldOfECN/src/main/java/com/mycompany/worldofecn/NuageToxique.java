/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

import java.util.Random;

/**
 * Implements une Nuage Toxique
 * @author Larissa
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    /**
    * @param dA Degats d'Attaque
    **/
    int dA;

    public NuageToxique(int dA, Point2D pos, World monde) {
        super(pos, monde);
        this.dA = dA;
    }

    public NuageToxique(int dA) {
        this.dA = dA;
    }

    public NuageToxique(int dA, Objet o) {
        super(o);
        this.dA = dA;
    }
    
    /**
    *
    *
    **/
   @Override
    public void deplace(){ 
       Random randomise = new Random();
       int dx = 0;
       int dy = 0;
       boolean bouge = false;
       
       World monde = super.getMonde();
       Point2D pos = super.getPos();
       
       //set the position in O
       monde[pos.getX()][pos.getY()] = '0';
       
       this.monde.getCreatures()[this.pos.getX()][this.pos.getY()] = null;

       while (bouge == false) {
           dx = randomise.nextInt(3) - 1;
           dy = randomise.nextInt(3) - 1;
           bouge = (pos.translate(dx, dy, 0) != null) && this.monde.getCreatures(pos.translate(dx, dy, 0)) == null; //si creature hors le monde et il n'y a pas de creature dans la case on bouge   
       }
       this.setPos(pos.translate(dx, dy, 0)); //seta uma nova posicao
       this.monde.getCreatures()[this.pos.getX()][this.pos.getY()] = this;
        
    }
    
    @Override
    public void combattre(Creature c){
        
    }
}
