/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;
import java.util.Random;

/**
 *
 * @author Clara
 */
public class Personnage {
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;
    private World monde;

    
    public Personnage (String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, World monde){
        this.nom = n;
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.distAttMax = dMax;
        this.pos = p;
        this.monde = monde;
    }
    
    public Personnage (Personnage p) {
       this(p.getNom(), p.getPtVie(), p.getDegAtt(), p.getPtPar(), p.getPageAtt(), p.getPagePar(), p.getDistAttMax(), p.getPos(), p.getMonde());
    }

    public String getNom() {
        return nom;
    }
    
    public Personnage () {
        this("",0,0,0,0,0,0,null, null);
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public World getMonde() {
        return monde;
    }

    public void setMonde(World monde) {
        this.monde = monde;
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

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void deplace(){
        Random randomise = new Random();
        int mouvement = randomise.nextInt(8);
        monde.monde[pos.getX()][pos.getY()]= '0';
        switch (mouvement) {
            case 0 -> pos.translate(0, 1);
            case 1 -> pos.translate(0, -1);
            case 2 -> pos.translate(1, 0);
            case 3 -> pos.translate(-1, 0);
            case 4 -> pos.translate(1, 1);
            case 5 -> pos.translate(1, -1);
            case 6 -> pos.translate(-1, 1);
            case 7 -> pos.translate(-1, -1);
            default -> pos.translate(0,0);
        }           
}

    @Override
    public String toString() {
        return "Personnage{" + "nom=" + nom + ", ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", distAttMax=" + distAttMax + ", pos=" + pos + '}';
    }
    
    public void affiche() {
        System.out.println(toString());
    }
          
}
