/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Larissa et Clara
 * @param
 */
public class World {

    /**
     * Carte utilisée pour l'affichage à l'utilisateur
     */

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
     * Le joueur
     */
    public Joueur joueur;
   
    /**
     * Taille du monde carré
     */
    public  static  final  int taille =  50; 

    public static int getTaille() {
        return taille;
    }
    
    //methodes

    /**
     *
     */
    public World(){
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
        }while(creatures[entierAleaX][entierAleaY] != null);
        
        Point2D position = new Point2D();
        position.setX(entierAleaX);
        position.setY(entierAleaY);
        
        AleaPtVie = generateurAleatoire.nextInt(100);
        
        c.setMonde(this);
        c.setPos(position);
        c.setPtVie(AleaPtVie);
        this.setCreatures(c);

            
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
        }while(creatures[entierAleaX][entierAleaY] != null || objetMap[entierAleaX][entierAleaY] != null);
        
        Point2D position = new Point2D();
        position.setX(entierAleaX);
        position.setY(entierAleaY);
        
        o.setMonde(this);
        o.setPos(position);
        this.setObjetMap(o, entierAleaX, entierAleaY);
                  
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
    

    /**
     * Gère le tour de jeu: mise à jour de tous les positions de tous les creatures et objets.
     * 
     */
    public void tourDeJeu() {
        //Deplace tous les creatures
        Iterator<Monstre> itMonstre = monstres.iterator();
        while (itMonstre.hasNext()) {
            Monstre m = itMonstre.next();
            m.deplace();
        }
        
        //Deplace tous les personnages
        Iterator<Personnage> itPersonnage = personnages.iterator();
        while (itPersonnage.hasNext()) {
            Personnage p = itPersonnage.next();
            p.deplace();
        }
        
        //Deplace les objets deplacables
        Iterator<Objet> itObjet = objets.iterator();
        while (itObjet.hasNext()) {
            Objet o = itObjet.next();
            if (o instanceof Deplacable){
                NuageToxique n = (NuageToxique)o;
                n.deplace();
            }
        }
        
        //Afficher la carte du monde apres les changements
        this.afficheWorld();
        this.joueur.choixTourDeJeu();
    }
    
    /**
     * Affiche à l'écran la carte du jeu pour l'utilisateur, avec la position des objets, personnages et monstres
     */
    public void afficheWorld() { //completar com instancia de cada perso
        
        char[][] monde = new char[taille][taille];

        for(int i = 0; i<taille; i++){
            for (int j = 0 ; j<taille; j++){
                monde[i][j] = '-';
            }
        }
        
        for (Objet item : this.getObjets()) {
            if (item instanceof Nourriture) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'o';
            }
            else if (item instanceof Epee) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'E';
            }
            else if (item instanceof NuageToxique) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'X';
            }
            else if (item instanceof PotionSoin) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'S';
            }
        } 
        
        for (Creature item : this.getPersonnages()) {
            if (item instanceof Archer) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'A';
            }
            else if (item instanceof Guerrier) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'G';
            }
            else if (item instanceof Paysan) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'P';
            }
        }  
        
        for (Creature item : this.getMonstres()) {
            if (item instanceof Lapin) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'L';
            }
            else if (item instanceof Loup) {
                monde[item.getPos().getX()][item.getPos().getY()] = 'W';
            }
        } 
        
        // le joueur est representée par un J
        monde[joueur.getPerso().getPos().getX()][joueur.getPerso().getPos().getY()] = 'J';
        
        //affiche le matrice avec les objets et creatures
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
    
    public Objet getObjets(Point2D p){
        return objetMap[p.getX()][p.getY()];
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
    
    public Creature getCreatures(int x, int y) {
        return creatures[x][y];
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
    
    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
    
