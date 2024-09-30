/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

import java.util.Random;

/**
 *
 * @author 
 */
public abstract class Creature {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    private World monde;
    
    //Constructeurs
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.pos = p;
        this.monde = monde;
    }
    
    public Creature(Creature c){
        this(c.getPtVie(),
             c.getDegAtt(), c.getPtPar(),
             c.getPageAtt(), c.getPagePar(),
             new Point2D(c.getPos()),
             c.getMonde()
        );
    }
    
    public Creature(){
        this(0,0,0,0,0,null,null);
    }
    
    //Getters and setters
    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        if (this.pos != null) {
            monde.monde[this.pos.getX()][this.pos.getY()]= '0';
            this.monde.getCreatures()[this.pos.getX()][this.pos.getY()] = null;  } 
        this.pos = pos;
        this.monde.getCreatures()[this.pos.getX()][this.pos.getY()] = this;
    }

    public World getMonde() {
        return monde;
    }

    public void setMonde(World monde) {
        this.monde = monde;
    }
    
    
    public void deplace(){
        Random randomise = new Random();
        int mouvement;
        boolean bouge = false;
        monde.monde[pos.getX()][pos.getY()]= '0';
        this.monde.getCreatures()[this.pos.getX()][this.pos.getY()] = null;
        
        while (bouge == false) {
            mouvement = randomise.nextInt(8);
            switch (mouvement) {
                case 0:
                    bouge = pos.translate(0, 1);
                    break;
                case 1:
                    bouge = pos.translate(0, -1);
                    break;
                case 2:
                    bouge = pos.translate(1, 0);
                    break;
                case 3:
                    bouge = pos.translate(-1, 0);
                    break;
                case 4:
                    bouge = pos.translate(1, 1);
                    break;
                case 5:
                    bouge = pos.translate(1, -1);
                    break;
                case 6:
                    bouge = pos.translate(-1, 1);
                    break;
                case 7:
                    bouge = pos.translate(-1, -1);
                    break;
                default:
                    pos.translate(0,0);
            }
            this.monde.getCreatures()[this.pos.getX()][this.pos.getY()] = this;
        }
    }
    
    @Override
    public String toString() {
        return "Creature{" + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + ", monde=" + monde + '}';
    }
    
    public void affiche(){
        System.out.println(this.toString());
    }
    
   
}
