/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;
import java.util.Random;

/**
 *
 * @author User
 */
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs;
    public char[][] monde;
    
    //methodes
    public World(){
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin();
        monde = new char [20][20];
    }
    
    //positionne les personnages de maniere aleatoire
    public void creerMondeAlea(){
        Random generateurAleatoire = new Random();
        int entierAleaX = 0;
        int entierAleaY = 0;
        
        for(int i = 0; i<20; i++){
            for (int j = 0 ; j<20; j++){
                monde[i][j] = '0';
            }
        }
        
        do{
            entierAleaX = generateurAleatoire.nextInt(20);
            entierAleaY = generateurAleatoire.nextInt(20);
        }while(monde[entierAleaX][entierAleaY] != '0');
        
        Point2D position_robin = new Point2D();
        position_robin.setX(entierAleaX);
        position_robin.setY(entierAleaY);
        
        robin.setPos(position_robin);
        robin.setMonde(this);
        
        monde[entierAleaX][entierAleaY] = 'A';
        
        do{
            entierAleaX = generateurAleatoire.nextInt(20);
            entierAleaY = generateurAleatoire.nextInt(20);
        }while(monde[entierAleaX][entierAleaY] != '0');
        
        Point2D position_peon = new Point2D();
        position_peon.setX(entierAleaX);
        position_peon.setY(entierAleaY);
        peon.setPos(position_peon);
        peon.setMonde(this);
        monde[entierAleaX][entierAleaY] = 'P';
        
        do{
            entierAleaX = generateurAleatoire.nextInt(20);
            entierAleaY = generateurAleatoire.nextInt(20);
        }while(monde[entierAleaX][entierAleaY] != '0');
        
        Point2D position_bugs = new Point2D();
        position_bugs.setX(entierAleaX);
        position_bugs.setY(entierAleaY);
        bugs.setPos(position_bugs);
        bugs.setMonde(this);
        
        monde[entierAleaX][entierAleaY] = 'L';

    }

    public char[][] getMonde() {
        return monde;
    }

    public void afficheMonde() {
        for(int i = 0; i<20; i++){
            for (int j = 0 ; j<20; j++){
                System.out.print(monde[i][j] + " ");
            }
            System.out.println();
        } 
    }
    
    
}
    
