/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara
 */
public class Archer extends Personnage {
    private int nbFleches;
    
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches){
       super(n, pV, dA, pPar, paAtt, paPar, dMax, p) ;
       this.nbFleches = 0;
    }
    public Archer (Archer A) {
       this(A.getNom(), A.getPtVie(), A.getDegAtt(), A.getPtPar(), A.getPageAtt(), A.getPagePar(), A.getDistAttMax(), A.getPos(), A.getNbFleches());
    }
    
    public Archer() {
        this("", 0, 0, 0, 0, 0,0, null,0);
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    
}
