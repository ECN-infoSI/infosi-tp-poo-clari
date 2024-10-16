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

    /**
     *
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param p
     * @param monde
     */
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
    }
    
    /**
     *
     * @param l
     */
    public Lapin(Lapin l){
        this(l.getPtVie(),
             l.getDegAtt(),
             l.getPtPar(),
             l.getPageAtt(),
             l.getPagePar(),
             new Point2D(l.getPos()),
             l.getMonde()
        );
    }
    
    /**
     *
     */
    public Lapin(){
        super();
    }
    
    
}
    
