/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

import java.util.Random;

/**
 *
 * @author Clara
 */
public class Guerrier extends Personnage {
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, World monde) {
       super(n, pV, dA, pPar, paAtt, paPar, dMax, p, monde) ;
    }
    
    public Guerrier (Guerrier g) {
        this(g.getNom(), g.getPtVie(), g.getDegAtt(), g.getPtPar(), g.getPageAtt(), g.getPagePar(), g.getDistAttMax(), new Point2D(g.getPos()), g.getMonde());
    }
    
    @Override
    public void deplace() {
        super.deplace();
        this.getMonde().monde[this.getPos().getX()][this.getPos().getY()]= 'G';
    }
    
    public Guerrier(){
        super();
    }
    public void combattre(Creature c){
        int tirage, nouveauPtVie;
        float distance;
        
        distance = this.getPos().distance(c.getPos());
        Random gen = new Random();
        tirage = gen.nextInt(100);
        nouveauPtVie = c.getPtVie();
        
        //Combat corps a corps
        if ( distance <= 1 ){
            //Attaque reussie
            if(tirage <= this.getPageAtt() ){
                System.out.println("Attaque reussie!");
                //Le defenseur a droit a une reponse
                tirage = gen.nextInt(100);
                
                if (tirage > c.getPagePar()){ //Defense ratee
                    System.out.println("Defense ratee!");
                    nouveauPtVie = c.getPtVie() - this.getDegAtt(); 
                }
                else{ //Defense reussie
                    System.out.println("Defense reussie!");
                    nouveauPtVie = c.getPtVie() - (this.getDegAtt() - c.getPtPar());
                }
                
            } else{
                System.out.println("Attaque ratee!");
                //ni l'attaquant ni le defenseur subissent des degats
            }
         
        }
        
        //Combat a distance
        else if (distance > 1 && distance < this.getDistAttMax()){
            
            //Attaque reussie
            if(tirage <= this.getPageAtt() ){ 
                System.out.println("Attaque reussie!");
                nouveauPtVie = c.getPtVie() - this.getDegAtt(); 
            } 
            //Attaque ratee
            else{
                System.out.println("Attaque ratee!"); 
                //ni l'attaquant ni le defenseur subissent des degats
            }    
        }
        
        if(nouveauPtVie > 100){
            nouveauPtVie = 100;
        }
        c.setPtVie(nouveauPtVie);
     
        System.out.println("Points de Vie attaquant: " + this.getPtVie() );
        System.out.println("Points de Vie defenseur: " + c.getPtVie() );
    }
}
