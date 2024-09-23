/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara
 */
public class Paysan extends Personnage {
    
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, World monde) {
       super(n, pV, dA, pPar, paAtt, paPar, dMax, p, monde) ;
    }
    
    public Paysan (Paysan p) {
        this(p.getNom(), p.getPtVie(), p.getDegAtt(), p.getPtPar(), p.getPageAtt(), p.getPagePar(), p.getDistAttMax(), new Point2D(p.getPos()), p.getMonde());
    }
    
    public Paysan(){
        super();
    }
    
    @Override
    public void setPos(Point2D pos) {
        super.setPos(pos);
        if (this.getMonde() != null){
            this.getMonde().monde[pos.getX()][pos.getY()]= 'P';}
    }
    
    @Override
    public void deplace() {
        super.deplace();
        this.getMonde().monde[this.getPos().getX()][this.getPos().getY()]= 'P';
    }
    
}
