package com.mycompany.worldofecn;

import java.util.Random;

/**
 *
 * @author Clara 
 */
public class Archer extends Personnage {
    private int nbFleches;
    
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches, World monde){
       super(n, pV, dA, pPar, paAtt, paPar, dMax, p, monde) ;
       this.nbFleches = 0;
    }
    public Archer (Archer A) {
       this(A.getNom(), A.getPtVie(), A.getDegAtt(), A.getPtPar(), A.getPageAtt(), 
               A.getPagePar(), A.getDistAttMax(), new Point2D(A.getPos()), A.getNbFleches(), A.getMonde());
    }
    
    public Archer() {
        super();
        this.nbFleches = 0;
    }

    public int getNbFleches() {
        return nbFleches;
    }
    
    @Override
    public void setPos(Point2D pos) {
        super.setPos(pos);
        if (this.getMonde() != null){
            this.getMonde().monde[pos.getX()][pos.getY()]= 'A';}
    }

    @Override
    public void deplace() {
        super.deplace();
        this.getMonde().monde[this.getPos().getX()][this.getPos().getY()]= 'A';
    }
    
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
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
            
            if(c instanceof Archer){
                int numFleches;
                numFleches = ((Archer)c).getNbFleches() - 1;
                System.out.println("Nombre de fleches defenseur: " + numFleches);
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
        this.nbFleches = this.nbFleches - 1;
                
        System.out.println("Points de Vie attaquant: " + this.getPtVie() );
        System.out.println("Points de Vie defenseur: " + c.getPtVie() );
        System.out.println("Nombre de fleches attaquant: " + (this.nbFleches-1));
        
    }
}
