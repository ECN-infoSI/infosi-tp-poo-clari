/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara MATTOS MEDEIROS et Larissa ALBUQUERQUE NOGUEIRA
 */
public class Paysan extends Personnage {
    
    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     * @param monde
     */
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, World monde) {
       super(n, pV, dA, pPar, paAtt, paPar, dMax, p, monde) ;
    }
    
    /**
     *
     * @param p
     */
    public Paysan (Paysan p) {
        this(p.getNom(), p.getPtVie(), p.getDegAtt(), p.getPtPar(), p.getPageAtt(), p.getPagePar(), p.getDistAttMax(), new Point2D(p.getPos()), p.getMonde());
    }
    
    /**
     *
     */
    public Paysan(){
        super();
    }
    
    /**
     *
     * @param pos
     */
    @Override
    public void setPos(Point2D pos) {
        super.setPos(pos);
        
    }
    
    /**
     * Deplace le personnage dans le monde et mets un 'P' pour l'affichage de la carte du monde
     */
    @Override
    public void deplace() {
        super.deplace();
    }
    
}
