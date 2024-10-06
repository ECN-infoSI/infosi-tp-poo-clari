package com.mycompany.worldofecn;

import java.util.Random;

/**
 *
 * @author Clara et Larissa
 */
public class Archer extends Personnage implements Combattant {
    private int nbFleches;
    
    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     * @param nbFleches
     * @param monde
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches, World monde){
       super(n, pV, dA, pPar, paAtt, paPar, dMax, p, monde) ;
       this.nbFleches = 0;
    }

    /**
     *
     * @param A
     */
    public Archer (Archer A) {
       this(A.getNom(), A.getPtVie(), A.getDegAtt(), A.getPtPar(), A.getPageAtt(), 
               A.getPagePar(), A.getDistAttMax(), new Point2D(A.getPos()), A.getNbFleches(), A.getMonde());
    }
    
    /**
     *
     */
    public Archer() {
        super();
        this.nbFleches = 0;
    }

    /**
     *
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }
    
    /**
     *
     * @param pos
     */
    @Override
    public void setPos(Point2D pos) {
        super.setPos(pos);
        this.getMonde().monde[pos.getX()][pos.getY()]= 'A';
    }

    /**
     * Deplace l'archer dans le monde et mets un 'A' dans sa position à la carte du monde
     */
    @Override
    public void deplace() {
        super.deplace();
        this.getMonde().monde[this.getPos().getX()][this.getPos().getY()]= 'A';
    }
    
    /**
     *
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    /**
     * Traite le combat corps à corps et à distance entre deux Personnages ou deux creatures.
     * Si le combat est corps à corps, l'attaquant fait son attaque avec une percentage de réussite pageAtt.
     * Si l'attaquant réussi, le défenseur a une perte de degAtt dans ses points de vie. Dans ce type de combat,
     * le defenseur a droit a une réponse, qui a percentage de réussite de pagePar. S'il réussit son parade,
     * il perd le total de points de dégat - points de parade (pPar) de ses points de vie.
     * 
     * Si le combat est à distance, seulement l'attaquant a le droit d'attaque, qui marche de la même façon que
     * le combat corps à corps.
     *
     * @param c Creature qui va défendre l'attaque.
     */
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
