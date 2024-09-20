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
    
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
       super(n, pV, dA, pPar, paAtt, paPar, dMax, p) ;
    }
    
    public Paysan (Paysan p) {
        this(p.getNom(), p.getPtVie(), p.getDegAtt(), p.getPtPar(), p.getPageAtt(), p.getPagePar(), p.getDistAttMax(), p.getPos());
    }
    
    public Paysan(){
        this("", 0, 0, 0, 0, 0,0, null);
    }
}
