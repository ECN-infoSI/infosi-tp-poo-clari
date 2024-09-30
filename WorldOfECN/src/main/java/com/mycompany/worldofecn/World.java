/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Larissa et Clara
 * @param
 */
public class World {

    /**
     * Carte utilisée pour l'affichage à l'utilisateur
     */
    public char[][] monde;

    /**
     * Carte des objets du jeu
     */
    public Objet[][] objetMap;
    
    /**
     * Carte des creatures du jeu
     */
    public Creature[][] creatures;

    /**
     * Liste de tous les personnages du jeu - humanoides seulement
     */
    public ArrayList<Personnage> personnages;

    /**
     * Liste de tous les monstres du jeu
     */
    public ArrayList<Monstre> monstres;

    /**
     * Liste de tous les objets du jeu
     */
    public ArrayList<Objet> objets;
    
    /**
     * Taille du monde carré
     */
    public  static  final  int taille =  50; 
    
    //methodes

    /**
     *
     */
    public World(){
        monde = new char [taille][taille];
        objetMap = new Objet[taille][taille];
        creatures = new Creature[taille][taille];
        
        personnages = new ArrayList<>();
        monstres = new ArrayList<>();
        objets = new ArrayList<>();
        
    }

    /**
     * Etant donnée une creature, la assigne une position aleatoire dans le monde
     * @param c
     */
    public void creerCreature(Creature c) {
        Random generateurAleatoire = new Random();
        int entierAleaX = 0;
        int entierAleaY = 0;
        int AleaPtVie = 0;
        
        do{
            entierAleaX = generateurAleatoire.nextInt(taille);
            entierAleaY = generateurAleatoire.nextInt(taille);
        }while(monde[entierAleaX][entierAleaY] != '0');
        
        Point2D position = new Point2D();
        position.setX(entierAleaX);
        position.setY(entierAleaY);
        
        AleaPtVie = generateurAleatoire.nextInt(100);
        
        c.setMonde(this);
        c.setPos(position);
        c.setPtVie(AleaPtVie);
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
    
    /**
     *Étant donné un objet, le positionne aleatoirement dans le monde 
     * @param o Objet
     */
    public void creerObjet(Objet o) {
        Random generateurAleatoire = new Random();
        int entierAleaX = 0;
        int entierAleaY = 0;
        
        do{
            entierAleaX = generateurAleatoire.nextInt(taille);
            entierAleaY = generateurAleatoire.nextInt(taille);
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
    
    /**
     * Cree un objet et parametre sa force
     * @param o
     * @param force
     */
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
     * @param nbEpee nombre d'Epees dans le jeu
     * @param nbPotion nombre de Potions dans le jeu
     */
    public void creerMondeAlea(int nbArcher, int nbPaysan, int nbGuerrier, int nbLapin, int nbLoup, int nbEpee, int nbPotion){
        
        //Creer la matrix vide
        for(int i = 0; i<taille; i++){
            for (int j = 0 ; j<taille; j++){
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

    /**
     *
     * @return
     */
    public char[][] getMonde() {
        return monde;
    }

    /**
     * Gère le tour de jeu pour les joueurs
     */
    public void tourDeJeu() {
    }
    
    /**
     * Affiche à l'écran la carte du jeu pour l'utilisateur, avec la position des objets, personnages et monstres
     */
    public void afficheWorld() {
        for(int i = 0; i<taille; i++){
            for (int j = 0 ; j<taille; j++){
                System.out.print(monde[i][j] + " ");
            }
            System.out.println();
        } 
    }
    
    /**
     *
     * @return
     */
    public Objet[][] getObjetMap() {
        return objetMap;
    }

    /**
     *
     * @param o
     * @param x
     * @param y
     */
    public void setObjetMap(Objet o, int x, int y) {
        this.objetMap[x][y] = o;
    }
    
    /**
     *
     * @return
     */
    public Creature[][] getCreatures() {
        return creatures;
    }

    public Creature getCreatures(Point2D p) {
        return creatures[p.getX()][p.getY()];
    }
    /**
     *
     * @param c
     */
    public void setCreatures(Creature c) {
        this.creatures[c.getPos().getX()][c.getPos().getY()] = c;
    }

    /**
     *
     * @return
     */
    public ArrayList<Personnage> getPersonnages() {
        return personnages;
    }

    /**
     *
     * @param personnages
     */
    public void setPersonnages(ArrayList<Personnage> personnages) {
        this.personnages = personnages;
    }

    /**
     *
     * @return
     */
    public ArrayList<Monstre> getMonstres() {
        return monstres;
    }

    /**
     *
     * @param monstres
     */
    public void setMonstres(ArrayList<Monstre> monstres) {
        this.monstres = monstres;
    }

    /**
     *
     * @return
     */
    public ArrayList<Objet> getObjets() {
        return objets;
    }

    /**
     *
     * @param objets
     */
    public void setObjets(ArrayList<Objet> objets) {
        this.objets = objets;
    }
    
    /**
     *
     */
    public void afficheListePersonnage(){
        System.out.println("Liste de personnages : ");
        for(int i = 0; i < personnages.size(); i++){
            personnages.get(i).affiche();
        }
    }
    
    /**
     *
     */
    public void afficheListeMonstre(){
        System.out.println("Liste de Monstres : ");
        for(int i = 0; i < monstres.size(); i++){
            monstres.get(i).affiche();
        }
    }
    
    public void afficheListeObjet(){
        System.out.println("Liste de Objets : ");
        for(int i = 0; i < objets.size(); i++){
            objets.get(i).affiche();
        }
    }
    
}
    
    
    
