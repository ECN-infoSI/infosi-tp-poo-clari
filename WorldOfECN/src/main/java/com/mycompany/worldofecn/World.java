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
    public Lapin bugs1;
    public Lapin bugs2;
    public Archer guillaumeT;
    public Guerrier grosBill;
    public Loup wolfie;
    public char[][] monde;
    
    //methodes
    public World(){
        robin = new Archer();
        peon = new Paysan();
        bugs1 = new Lapin();
        bugs2 = new Lapin();
        guillaumeT = new Archer();
        grosBill = new Guerrier();
        wolfie = new Loup();
        monde = new char [20][20];
    }
    
    //positionne les personnages de maniere aleatoire
    public void creerCreature(Creature c) {
        Random generateurAleatoire = new Random();
        int entierAleaX = 0;
        int entierAleaY = 0;
        
        do{
            entierAleaX = generateurAleatoire.nextInt(20);
            entierAleaY = generateurAleatoire.nextInt(20);
        }while(monde[entierAleaX][entierAleaY] != '0');
        
        Point2D position = new Point2D();
        position.setX(entierAleaX);
        position.setY(entierAleaY);
        
        c.setPos(position);
        c.setMonde(this);
        
        if (c instanceof Archer) {
            monde[entierAleaX][entierAleaY] = 'A';
        } else if (c instanceof Paysan) {
            monde[entierAleaX][entierAleaY] = 'P';
        } else if (c instanceof Lapin) {
            monde[entierAleaX][entierAleaY] = 'L';
        } else if (c instanceof Guerrier) {
            monde[entierAleaX][entierAleaY] = 'G';
        } else if (c instanceof Loup) {
            monde[entierAleaX][entierAleaY] = 'W';
        }
            
    }
        
    public void creerMondeAlea(){
        
        for(int i = 0; i<20; i++){
            for (int j = 0 ; j<20; j++){
                monde[i][j] = '0';
            }
        }
        
        // Création robin
        creerCreature(robin);
        robin.setNom("robin");
        
        // Création peon
        creerCreature(peon);
        peon.setNom("peon");
        
        // Création bugs1
        creerCreature(bugs1);

        // Création bugs2
        creerCreature(bugs2);
        
        // Création guillaumeT
        creerCreature(guillaumeT);
        guillaumeT.setNom("guillaumeT");
        
        // Création grosBill
        creerCreature(grosBill);
        
        // Création wolfie
        creerCreature(wolfie);
        
    }

    public char[][] getMonde() {
        return monde;
    }

    public void tourDeJeu() {
        
    }
    
    public void afficheWorld() {
        for(int i = 0; i<20; i++){
            for (int j = 0 ; j<20; j++){
                System.out.print(monde[i][j] + " ");
            }
            System.out.println();
        } 
    }
    
    
}
    
