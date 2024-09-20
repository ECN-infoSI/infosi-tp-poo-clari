/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Larissa ALBUQUERQUE NOGUEIRA
 */
public class Lapin extends Monstre {
    //constructeurs
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
    }
    
    public Lapin(Lapin l){
        this(l.getPtVie(),
             l.getDegAtt(),
             l.getPtPar(),
             l.getPageAtt(),
             l.getPagePar(),
             l.getPos(),
             l.getMonde()
        );
    }
    
    @Override
    public void deplace() {
        super.deplace();
        this.getMonde().monde[this.getPos().getX()][this.getPos().getY()]= 'L';
    }
    
    public Lapin(){
        super();
    }
}
    
