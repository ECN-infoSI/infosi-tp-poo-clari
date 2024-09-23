/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

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
        
    }
}
