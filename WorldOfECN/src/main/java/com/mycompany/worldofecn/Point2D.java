/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 * @author Larissa ALBUQUERQUE NOGUEIRA
 */
//represente un point a coordonnees entieres en 2 dimensions
public class Point2D {
    private int x;
    private int y;
 
    /**
     *
     * @param x
     * @param y
     */
    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     *
     * @param p
     */
    public Point2D(Point2D p){
        x = p.getX();
        y = p.getY();
    }
    
    /**
     *
     */
    public Point2D(){
        x = 10;
        y = 5;
    }
    
    /**
     *
     * @param x
     */
    public void setX (int x){
        this.x = x;
    }
    
    /**
     *
     * @param y
     */
    public void setY (int y){
        this.y = y;
    }
    
    /**
     *
     * @return
     */
    public int getX (){
        return x;
    }

    /**
     *
     * @return
     */
    public int getY (){
        return y;
    }
    
    /**
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     *
     * @param dx
     * @param dy
     * @return
     */
    public boolean translate(int dx, int dy){
        if (x+ dx < 50 && y + dy < 50 && y + dy >= 0 && x+ dx>=0) {
            x = x+ dx;
            y = y + dy;
            return true;
        }
        return false;
    }
    
    public Point2D translate(int dx, int dy, int test){
        if (x+ dx < 50 && y + dy < 50 && y + dy >= 0 && x+ dx>=0) {
            return new Point2D(x+ dx, y + dy);
        }
        return null;
    }
    
    /**
     *
     */
    public void affiche(){
        System.out.println("Valeur de x: " + x + ", Valeur de y: " + y);
    }
    
    /**
     *
     * @param p
     * @return
     */
    public float distance(Point2D p){
        float dist;
        int px = p.getX();
        int py = p.getY();
        dist = (float)Math.pow(Math.pow((x-px), 2)+Math.pow((y-py),2),0.5); 
        
        return dist;
    }
         
}
