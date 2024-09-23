package com.mycompany.worldofecn;

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
    public void deplace() {
        super.deplace();
        this.getMonde().monde[this.getPos().getX()][this.getPos().getY()]= 'A';
    }
    
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    public void combattre(Creature c){
        
    }
}
