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
 
    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Point2D(Point2D p){
        x = p.getX();
        y = p.getY();
    }
    
    public Point2D(){
        x = 10;
        y = 5;
    }
    
    public void setX (int x){
        this.x = x;
    }
    
    public void setY (int y){
        this.y = y;
    }
    
    public int getX (){
        return x;
    }

    public int getY (){
        return y;
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void translate(int dx, int dy){
        x = x+ dx;
        y = y + dy;
    }
    
    public void affiche(){
        System.out.println("Valeur de x: " + x + "\n Valeur de y: " + y);
    }
    
    public float distance(Point2D p){
        float dist;
        int px = p.getX();
        int py = p.getY();
        dist = (float)Math.pow(Math.pow((x-px), 2)+Math.pow((y-py),2),0.5); 
        
        return dist;
    }
         
}
