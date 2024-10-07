/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

import java.util.Random;

/**
 *
 * @author Larissa et Clara
 */
public abstract class Creature extends ElementDeJeu implements Deplacable {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    
    //Constructeurs

    /**
     *
     * 
     * @param pV Points de Vie
     * @param dA Degats d'Attaque
     * @param pPar Points de Parade
     * @param paAtt Pourcentage d'Attaque
     * @param paPar Pourcentage de Parade
     * @param p Objet du type Point2D pour la position du Personnage dans le monde
     * @param monde La carte avec toutes les positions de tous les personnages du jeu
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        super(p, monde);
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        
    }
    
    /**
     *
     * @param c
     */
    public Creature(Creature c){
        this(c.getPtVie(),
             c.getDegAtt(), c.getPtPar(),
             c.getPageAtt(), c.getPagePar(),
             new Point2D(c.getPos()),
             c.getMonde()
        );
    }
    
    /**
     * Constructeur par défaut
     */
    public Creature(){
        this(0,0,0,0,0,null,null);
    }
    
    //Getters and setters

    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     * Deplace une creature dans le monde
     * 
     */
    @Override
    public void deplace(){
        Random randomise = new Random();
        Point2D pos = super.getPos();
        int dx = 0;
        int dy = 0;
        boolean bouge = false;
        super.getMonde().monde[pos.getX()][pos.getY()]= '0';
        super.getMonde().getCreatures()[pos.getX()][pos.getY()] = null;
        
        while (bouge == false) {
            dx = randomise.nextInt(3) - 1;
            dy = randomise.nextInt(3)- 1;
            bouge = (pos.translate(dx, dy, 0) != null) && super.getMonde().getCreatures(pos.translate(dx, dy, 0)) == null; //si creature hors le monde et il n'y a pas de creature dans la case on bouge   
        }
        this.setPos(pos.translate(dx, dy, 0)); //seta uma nova posicao
        super.getMonde().getCreatures()[pos.getX()][pos.getY()] = this;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Creature{" + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + '}' + super.toString();
    }
    
    /**
     * Affiche les attributs de la creature à l'écran
     */
    @Override
    public void affiche(){
        System.out.println(this.toString());
    }
    
   
}
