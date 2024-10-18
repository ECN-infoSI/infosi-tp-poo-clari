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
    * @param degAtt Degats d'Attaque
    **/
    int degAtt;

    public NuageToxique(int degAtt, Point2D pos, World monde) {
        super(pos, monde);
        this.degAtt = degAtt;
    }
    
    public NuageToxique(NuageToxique n) {
        this(n.getDegAtt(),
             n.getPos(),
             n.getMonde()
        );
    }
    
    public NuageToxique() {
        this(0, null, null);
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
    * Implemente le combat entre un nuage et un personnage: Le combat se passe seulement si le nuage est dans la meme case qu'un
    * personnage, le cas ou le combat se fait automatiquement
    * @param c Creature defenseur
    **/
    @Override
    public void combattre(Creature c){
  
        int nouveauPtVie = c.getPtVie() - this.degAtt;
        
        System.out.println("Attaque par nuage toxique!");
        c.setPtVie(nouveauPtVie);

        System.out.println("Points de Vie restants: " + c.getPtVie());
    }
    
   /**
    *
    *Deplace un nuage dans le jeu
    **/
   @Override
    public void deplace(){
        Random randomise = new Random();
        Point2D pos = super.getPos();
        int dx = 0;
        int dy = 0;
        boolean bouge = false;
        
        //effacer la derniere position du nuage
        super.getMonde().getObjetMap()[pos.getX()][pos.getY()] = null;
        
        //Bouge s'il la position est dans la taille du monde et il n'y a pas d'objet dans la case
        while (bouge == false) {
            dx = randomise.nextInt(3) - 1;
            dy = randomise.nextInt(3)- 1;
            
            bouge = (pos.translate(dx, dy, 0) != null)
                    && (super.getMonde().getObjets(super.getPos().translate(dx, dy, 0)) == null); 
        }
        
        //seta uma nova posicao para a nuage 
        this.setPos(pos.translate(dx, dy, 0)); 
        super.getMonde().getObjetMap()[super.getPos().getX()][super.getPos().getY()] = this;
        
        
        //S'il y a une creature combattant dans la case, on la combat
        Creature c = super.getMonde().getCreatures(super.getPos());
        if( c != null && c instanceof Combattant){
            this.combattre(c);
        }
    }
}
