/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

import java.util.Random;

/**
 *
 * @author User
 */
public class Loup extends Monstre {
    
    //Constructeurs

    /**
     *
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param p
     * @param monde
     */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
    }
    
    /**
     *
     * @param p
     */
    public Loup(Loup p){
        this(p.getPtVie(), p.getDegAtt(),
                p.getPtPar(), p.getPageAtt(),
                p.getPagePar(), new Point2D(p.getPos()), p.getMonde());
    }
    
    /**
     *
     */
    public Loup(){
        super();
    }
    
    /**
     * Deplace le loup dans le monde et mets un 'W' dans sa place pour l'affichage de la carte du monde
     */
    @Override
    public void deplace() {
        super.deplace();
        this.getMonde().monde[this.getPos().getX()][this.getPos().getY()]= 'W';
    }
    
    /**
     *
     * @param pos
     */
    @Override
    public void setPos(Point2D pos) {
        super.setPos(pos);
        if (this.getMonde() != null)
            this.getMonde().monde[pos.getX()][pos.getY()]= 'W';
    }
    
    //Autres methodes

     /**
     * Traite le combat corps à corps entre deux protagonistes.
     * Si le combat est corps à corps, l'attaquant fait son attaque avec une percentage de réussite pageAtt.
     * Si l'attaquant réussi, le défenseur a une perte de degAtt dans ses points de vie. Dans ce type de combat,
     * le defenseur a droit a une réponse, qui a percentage de réussite de pagePar. S'il réussit son parade,
     * il perd le total de points de dégat - points de parade (pPar) de ses points de vie.
     *
     * @param c Creature qui va défendre l'attaque.
     */
    public void combattre(Creature c){
      //Creature c est le defenseur
        //Qui appelle la methode est l'ataquant
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
                //ni l'attaquant ni le defenseur subient des degats

            }
            
            if(c instanceof Archer){
                int numFleches;
                numFleches = ((Archer)c).getNbFleches() - 1;
                System.out.println("Nombre de fleches defenseur: " + numFleches);
            }
            
            if(nouveauPtVie > 100){
                nouveauPtVie = 100;
            }
            c.setPtVie(nouveauPtVie);
            
            System.out.println("Points de Vie attaquant: " + this.getPtVie() );
            System.out.println("Points de Vie defenseur: " + c.getPtVie() );
        } else{
            System.out.println("Trop loin pour se combattre.");
        }  
    }
}
