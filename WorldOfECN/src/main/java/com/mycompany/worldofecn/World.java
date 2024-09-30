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
    public PotionSoin potion1;
    public PotionSoin potion2;
    public PotionSoin potion3;
    public Objet[][] objets;
    public Creature[][] creatures;

    
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
        objets = new Objet[20][20];
        creatures = new Creature[20][20];
        potion1 = new PotionSoin();
        potion2 = new PotionSoin();
        potion3 = new PotionSoin();
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
        this.setCreatures(c);
        
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
    
    public void creerObjet(Objet o) {
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
        
        o.setPos(position);
        o.setMonde(this);
        
        if (o instanceof PotionSoin) {
            monde[entierAleaX][entierAleaY] = 'X';            
        } else if (o instanceof Epee) {
            monde[entierAleaX][entierAleaY] = 'E';
        }             
        objets[entierAleaX][entierAleaY] = o;
    }
    
    public void creerObjet(PotionSoin o, int force) {
        creerObjet(o);
        o.setForce(force);
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
        
        // Création potions
        creerObjet(potion1, 10);
        creerObjet(potion2, 20);
        creerObjet(potion3, 30);
        
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
    
    public Objet[][] getObjets() {
        return objets;
    }

    public void setObjets(Objet o, int x, int y) {
        this.objets[x][y] = o;
    }
    
    public Creature[][] getCreatures() {
        return creatures;
    }

    public void setCreatures(Creature c) {
        this.creatures[c.getPos().getX()][c.getPos().getY()] = c;
    }
}
    
