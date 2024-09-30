/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara
 */
public class Personnage extends Creature{
    private String nom;
    private int distAttMax;
    
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
    public Personnage (String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
        this.nom = n;
        this.distAttMax = dMax;
    }
    
    /**
     *
     * @param p
     */
    public Personnage (Personnage p) {
       this(p.getNom(),
               p.getPtVie(), p.getDegAtt(),
               p.getPtPar(), p.getPageAtt(),
               p.getPagePar(), p.getDistAttMax(),
               new Point2D(p.getPos()), p.getMonde());
    }
    
    /**
     *
     */
    public Personnage () {
        super();
        this.nom = "";
        this.distAttMax = 0;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }
   
    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }         

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "Personnage{" + "nom=" + nom + ", distAttMax=" + distAttMax + '}';
    }
    
    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println(this.toString() + super.toString());
    }
    
    /**
     *
     */
    public void boireSoin() {
        if (this.getMonde() != null) {
            if (this.getMonde().getObjetMap()[this.getPos().getX()][this.getPos().getY()] instanceof PotionSoin) {
                PotionSoin p = (PotionSoin)this.getMonde().getObjetMap()[this.getPos().getX()][this.getPos().getY()];
                this.setPtVie(this.getPtVie()+p.getForce());
                p.disparaitre();
                System.out.println("!!!!Le personnage a bu la potion!!!!!");
            }
        }
    }

    /**
     *
     */
    @Override
    public void deplace() {
        super.deplace();
        boireSoin();
    }
    
    /**
     *
     * @param pos
     */
    @Override 
    public void setPos(Point2D pos) {
        super.setPos(pos);
        boireSoin();
    }
}
