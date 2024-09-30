/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author User
 * @param
 */
public class World {
    public char[][] monde;
    public Objet[][] objetMap;
    
    public Creature[][] creatures;
    public ArrayList<Personnage> personnages;
    public ArrayList<Monstre> monstres;
    public ArrayList<Objet> objets;

    //methodes
    public World(){
        monde = new char [20][20];
        objetMap = new Objet[20][20];
        creatures = new Creature[20][20];
        
        personnages = new ArrayList<>();
        monstres = new ArrayList<>();
        objets = new ArrayList<>();
        
    }

    //positionne les personnages de maniere aleatoire

    /**
     * Etant donne une creature, la assigne une position aleatoire dans le monde
     * @param c
     */
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
        
        c.setMonde(this);
        c.setPos(position);
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
        
        o.setMonde(this);
        o.setPos(position);
        this.setObjetMap(o, entierAleaX, entierAleaY);
        
        if (o instanceof PotionSoin) {
            monde[entierAleaX][entierAleaY] = 'X';            
        } else if (o instanceof Epee) {
            monde[entierAleaX][entierAleaY] = 'E';
        }             
    }
    
    public void creerObjet(PotionSoin o, int force) {
        creerObjet(o);
        o.setForce(force);
    }
    
    /**
     *Cree la matrice du monde vide et apres la remplis avec des personnages
     * @param nbArcher nombre d'Archers dans le jeu
     * @param nbPaysan nombre de Paysans dans le jeu
     * @param nbGuerrier nombre de Guerriers dans le jeu
     * @param nbLapin nombre de Lapins dans le jeu
     * @param nbLoup nombre de Loups dans le jeu
     * @param nbEpees nombre d'Epees dans le jeu
     * @param nbPotions nombre de Potions dans le jeu
     */
    public void creerMondeAlea(int nbArcher, int nbPaysan, int nbGuerrier, int nbLapin, int nbLoup, int nbEpee, int nbPotion){
        
        //Creer la matrix vide
        for(int i = 0; i<20; i++){
            for (int j = 0 ; j<20; j++){
                monde[i][j] = '0';
            }
        }
        
        //Creer les objets du type personnage et les placer dans le array
        for(int i = 0; i < nbArcher; i++){
            Archer nouvelArcher = new Archer();
            creerCreature(nouvelArcher);
            personnages.add(nouvelArcher);
            
        }
        
        for(int i = 0; i < nbPaysan; i++){
            Paysan nouveauPaysan = new Paysan();
            creerCreature(nouveauPaysan);
            personnages.add(nouveauPaysan);
            
        }
        
        for(int i = 0; i < nbGuerrier; i++){
            Guerrier nouveauGuerrier = new Guerrier();
            creerCreature(nouveauGuerrier);
            personnages.add(nouveauGuerrier);
            
        }
        
        //Creer les objets du type Monstre et les placer dans le array
        for (int i = 0; i < nbLapin; i++){
            Lapin nouveauLapin = new Lapin();
            creerCreature(nouveauLapin);
            monstres.add(nouveauLapin);
        }
        
        for (int i = 0; i < nbLoup; i++){
            Loup nouveauLoup = new Loup();
            creerCreature(nouveauLoup);
            monstres.add(nouveauLoup);
        }
        
        //Creer les objets du type Objet et les placer dans le array
        for (int i = 0; i < nbEpee; i++){
            Epee nouvelEpee = new Epee();
            creerObjet(nouvelEpee);
            objets.add(nouvelEpee);
        }
        
        for (int i = 0; i < nbPotion; i++){
            PotionSoin nouvellePotion = new PotionSoin();
            creerObjet(nouvellePotion);
            objets.add(nouvellePotion);
        }
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
    
    public Objet[][] getObjetMap() {
        return objetMap;
    }

    public void setObjetMap(Objet o, int x, int y) {
        this.objetMap[x][y] = o;
    }
    
    public Creature[][] getCreatures() {
        return creatures;
    }

    public void setCreatures(Creature c) {
        this.creatures[c.getPos().getX()][c.getPos().getY()] = c;
    }

    public ArrayList<Personnage> getPersonnages() {
        return personnages;
    }

    public void setPersonnages(ArrayList<Personnage> personnages) {
        this.personnages = personnages;
    }

    public ArrayList<Monstre> getMonstres() {
        return monstres;
    }

    public void setMonstres(ArrayList<Monstre> monstres) {
        this.monstres = monstres;
    }

    public ArrayList<Objet> getObjets() {
        return objets;
    }

    public void setObjets(ArrayList<Objet> objets) {
        this.objets = objets;
    }
    
    public void afficheListePersonnage(){
        System.out.println("Liste de personnages : ");
        for(int i = 0; i < personnages.size(); i++){
            personnages.get(i).affiche();
        }
    }
    
    public void afficheListeMonstre(){
        System.out.println("Liste de Monstres : ");
        for(int i = 0; i < monstres.size(); i++){
            monstres.get(i).affiche();
        }
    }
    
    
}
    
    
    
