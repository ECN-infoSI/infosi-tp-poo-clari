/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author User
 */
public class Monstre {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    
    //Methodes
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        ptVie = pV;
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
        pos = p;
    }
    
    public Monstre(Monstre m){
        this(m.getPtVie(), m.getDegAtt(), m.getPtPar(), m.getPageAtt(), m.getPagePar(), m.getPos());
    }
    
    public Monstre(){
        ptVie = 0;
        degAtt = 0;
        ptPar = 0;
        pageAtt = 0;
        pagePar = 0;
        pos = null;
    }
    
    //Getters et setters
    public int getPtVie(){
        return ptVie;
    }
    
    public void setPtVie(int pv){
        this.ptVie = pv;
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
        this.pos = pos;
    }
    
   //Autres fonctions
    public void deplace(){
        pos.translate(1,1);
    }
    
    @Override
    public String toString() {
        return "Monstre{" + "ptVie=" + ptVie + ", degAtt=" + degAtt + ", ptPar=" + ptPar + ", pageAtt=" + pageAtt + ", pagePar=" + pagePar + ", pos=" + pos + '}';
    }
    
    public void affiche(){
        System.out.println(toString());
    }

}
