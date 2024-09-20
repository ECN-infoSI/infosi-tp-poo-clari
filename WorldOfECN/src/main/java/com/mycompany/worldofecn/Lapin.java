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
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
    
    public Lapin(Lapin l){
        this(l.getPtVie(),
             l.getDegAtt(),
             l.getPtPar(),
             l.getPageAtt(),
             l.getPagePar(),
             l.getPos()
        );
    }
    
    public Lapin(){
        super();
    }
}
    
