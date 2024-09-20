/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author User
 */
public class Monstre extends Creature {
    
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
    }
    
    //Methodes
    
    public Monstre(Monstre m){
        this(m.getPtVie(), m.getDegAtt(), m.getPtPar(), m.getPageAtt(), m.getPagePar(), new Point2D(m.getPos()), m.getMonde());
    }
    
    public Monstre(){
        super();
    }
    
}
