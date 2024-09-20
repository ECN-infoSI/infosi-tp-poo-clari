/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author User
 */
public class Loup extends Monstre {
    
    //Constructeurs
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
    }
    
    public Loup(Loup p){
        this(p.getPtVie(), p.getDegAtt(),
                p.getPtPar(), p.getPageAtt(),
                p.getPagePar(), new Point2D(p.getPos()), p.getMonde());
    }
    
    public Loup(){
        super();
    }
    
    //Methodes
    public void combattre(Creature c){
        
    }
}
