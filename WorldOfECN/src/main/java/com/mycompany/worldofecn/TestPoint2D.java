/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

import com.mycompany.worldofecn.Point2D;

/**
 * @author User
 */
public class TestPoint2D {
    
    public static void main(String[] args){
        //Creation des objets
        Point2D p1 = new Point2D();
        p1.affiche(); 
        
        Point2D p2 = new Point2D(4,3);
        p2.affiche();
        
        Point2D p3 = new Point2D(p2);
        p3.affiche();
        
        System.out.println("P2 = P3? " + (p2 == p3));
        
        //Test setters et getters
        p3.setX(5);
        p3.setY(10);
        p3.affiche();
        
        System.out.println("P2 X : "+ p2.getX());
        System.out.println("P2 Y : "+ p2.getY());
        
       //Test setPosition
       p1.setPosition(6,3);
       p1.affiche();
       
       //Test translate
       p1.translate(1, 0);
       p1.affiche();
       
       //Test distance
       System.out.println("Distance entre p2 et p3: " + p2.distance(p3));

    }
}
