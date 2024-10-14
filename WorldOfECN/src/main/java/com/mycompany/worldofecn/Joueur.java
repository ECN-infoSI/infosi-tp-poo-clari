/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *  Implements la classe du joueur humain
 * @author Larissa et Clara
 */
public class Joueur{
    private Personnage perso;
    private ArrayList<Utilisable> effets;
    private ArrayList<Utilisable> inventaire;

    public Joueur() {
        this.perso = null;
        effets = new ArrayList<>();
        inventaire = new ArrayList<>();
    }
    
    /**
     * Permet au joueur humain de choisir son personnage pour le jeu
     */
    public void choixPersonnage(){
        int choix = 0;
        String nom;
        Scanner keyboard = new Scanner(System.in);

        while(choix != 1 || choix != 2) {
        System.out.println("Inserez le numéro du personnage que vous voulez jouer avec: ");
        System.out.println("1. Guerrier");
        System.out.println("2. Archer");

        choix = keyboard.nextInt();

            if(choix != 1 || choix != 2){
            System.out.println("Svp selectionnez une option valide.");
            }
        }
        
        System.out.println("Inserez le nom de votre personnage: ");
        nom = keyboard.nextLine();
        
        if (choix == 1){
            perso = new Guerrier();
        } else{
            perso = new Archer();
            
        }
        
        perso.setNom(nom);
        
    }
    
    
    /**
     * Permet au joueur de faire ses choix: deplacement, combattre ou activer effet, à chaque tour de jeu.
    */
    public void choixTourDeJeu(){
        int choix = 0;
        Scanner keyboard = new Scanner(System.in);
        
        miseAJourEffets();
        afficheEffets();

        while(choix != 1 || choix != 2) {
            
            System.out.println("Choississez l'option souhaitee: ");
            System.out.println("1. Se deplacer");
            System.out.println("2. Combattre");
            System.out.println("3. Activer effet");

            choix = keyboard.nextInt();

            if(choix != 1 || choix != 2 || choix != 3){
                System.out.println("Svp selectionnez une option valide.");
            }
        }
        
        // Deplacer le personnage
        switch (choix) {
            case 1:
                //Le joueur doit pouvoir choisir son deplacement
                deplace();
                ramasserObjet();
                break;
                
            case 2:
                //Combattre un personnage
                //afficher la liste des personnages a combattre
                //Afficher tous les monstres les plus proches du joueur
                System.out.println("Choississez la creature a combattre: ");
                choixCombattants();
                break;
            
            case 3:
                System.out.println("Choississez l'effet a activer: ");
                afficheInventaire();
                
                int choixInv = keyboard.nextInt();
                        
                while(choixInv < 0 || choixInv >= inventaire.size()){
                    
                    System.out.println("Svp selectionnez une option valide.");
                    choixInv = keyboard.nextInt();
                }
                
                activerEffet(choixInv);
                break;
                
            default:
                break;
        }
    }
    
    /**
     * Demande au joueur la direction où il veut se déplacer et déplace son personnage.
     */
    public void deplace(){
        //La carte du monde est deja affichee pour le joueur a chaque tour de jeu
        //Il faut donc juste choisir son deplacement, 1 case par tour
        System.out.println("Choississez la direction: ");
        System.out.println("Z: Direction Nord");
        System.out.println("Q: Direction Ouest");
        System.out.println("D: Direction Est");
        System.out.println("S: Direction Sud");
        
        Scanner keyboard = new Scanner(System.in);
        Point2D pos = perso.getPos();
        boolean bouge = false;
        int dx = 0, dy = 0;
        
        
        String choix = keyboard.nextLine();
        boolean bienEcrit = "D".equals(choix) || "Q".equals(choix) || "Z".equals(choix) || "S".equals(choix);
        
        //Verifie si le joueur a bien ecrit et si la position est valide
        while (!bienEcrit || !bouge){
        
            //Si il a bien ecrit, mais la position est invalide
            if(bienEcrit){
                switch (choix) {
                case "Z": //nord
                    dx = 0;
                    dy = 1;
                    break;
                case "Q": //ouest
                    dx = -1;
                    dy = 0;
                    break;
                case "D": //est
                    dx = 1;
                    dy = 0;
                    break;
                case "S":
                    dx = 0;
                    dy = -1;
                    break;
                default:
                    dx = 0;
                    dy = 0;
                    break;
                }
                bouge = (pos.translate(dx, dy, 0) != null) && perso.getMonde().getCreatures(pos.translate(dx, dy, 0)) == null;
                
                //Si bouge est vrai, alors deplace le personnage
                if (bouge){
                   break;
                } 
                //Sinon, demander au joueur d'ecrire de nouveau
                else{
                  System.out.println("Svp selectionnez une option valide.");
                  choix = keyboard.nextLine();  
                }
                
            } else{ //Sinon, le joueur a mal ecrit son choix
              System.out.println("Svp selectionnez une option valide.");
              choix = keyboard.nextLine();
            }
        }
        
        //efface son ancienne position
        perso.getMonde().monde[pos.getX()][pos.getY()] = '0';
        
        //efface de la positions dans la matrice de creatures
        perso.getMonde().getCreatures()[pos.getX()][pos.getY()] = null;
        
        //deplace le perso
        perso.setPos(pos.translate(dx, dy, 0));
        
        //met un * dans la carte
        perso.getMonde().monde[pos.getX()][pos.getY()] = '*'; 
        
        //ajout le personnage dans la nouvelle position dans la matrice
        perso.getMonde().getCreatures()[pos.getX()][pos.getY()] = (Creature)perso;
    }
    
    /**
     * Active l'effet du joueur et l'efface de son inventaire.
     * @param indexEffet index de l'effet dans l'ArrayList de l'inventaire
     */
    public void activerEffet(int indexEffet){
        effets.add( inventaire.get(indexEffet) );
        inventaire.remove(indexEffet);
        System.out.println("Effet active.");
    }
    
    /**
     * Met à jour la liste d'effets du joueur.
     */
    public void miseAJourEffets(){
        Iterator<Utilisable> itEffets = effets.iterator();
        int index = 0;
        
        while (itEffets.hasNext()) {
            Utilisable outil = itEffets.next();
            outil.MiseAJourDuree();
         
            if(outil.getDuree() == 0){
                effets.remove(index);
            }
            
            index++;
        }
    }
    
    /**
     * Fonction qui verifie s'il y a un objet et si oui, le stocke dans l'inventaire.
     */
    public void ramasserObjet() {
        if (perso.getMonde() != null) {
            Objet o = perso.getMonde().getObjetMap()[perso.getPos().getX()][perso.getPos().getY()];
            
            if (o instanceof Utilisable utilisable) {
                
                if (o instanceof PotionSoin p){
                    perso.setPtVie(perso.getPtVie()+p.getForce());
                } 
                if (o instanceof Nourriture n){
                    perso.setPtVie(perso.getPtVie()+n.getEnergie());
                }
                
                //Inserer dans l'ArrayList
                ajoutInventaire(utilisable);
                
                //Supprime l'objet de la carte du jeu
                o.disparaitre();
                
                System.out.println("!!!!Vous avez ramasse "+ o.getClass().getName() +"!!!!!");
            }
        }
    }
    
    /**
    * Ajout un objet dans l'inventaire du joueur
    * @param u Objet utilisable a ajouter
    */
    public void ajoutInventaire(Utilisable u){
        inventaire.add(u);
    }
    
    /**
    * Ajout un objet dans la liste d'effets du joueur
    * @param u Effet utilisable a ajouter
    */
    public void ajoutEffet(Utilisable u){
        effets.add(u);
        
        Iterator<Utilisable> itEffets = effets.iterator();
        int index = 0;
        
        while (itEffets.hasNext()) {
            Utilisable outil = itEffets.next();
            outil.MiseAJourDuree();
         
            if(outil.getDuree() == 0){
                effets.remove(index);
            }
            
            index++;
        }
        
        System.out.println("Objet ajoute´, inventaire mis a jour.");
    }
    
    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    public ArrayList<Utilisable> getEffets() {
        return effets;
    }

    public void setEffets(ArrayList<Utilisable> effets) {
        this.effets = effets;
    }
    
    /**
     * Affiche l'inventaire à l'écran.
     */
    public void afficheInventaire(){
        Iterator<Utilisable> itOutils = inventaire.iterator();
        int index = 0;
        
        while (itOutils.hasNext()) {
            Utilisable outils = itOutils.next();
            
            System.out.print(index + outils.returnString());
            index++;
        }
    }
    
    /**
     * Affiche les effets actifs du joueur à l'écran.
     */
    public void afficheEffets(){
        Iterator<Utilisable> itOutils = effets.iterator();
        int index = 0;
        
        while (itOutils.hasNext()) {
            Utilisable outils = itOutils.next();
            
            System.out.print(index + outils.returnString());
            index++;
        }
    }
    
    /**
     * Implements le choix des Combattants pour que le joueur combatte; Affiche tous les creatures dans un rayon de distAttMax et combat la creature que le joueur choisis.
     */
    public void choixCombattants(){
        int dist = perso.getDistAttMax();
        int x = perso.getPos().getX();
        int y = perso.getPos().getY();
        ArrayList<Creature> creat = new ArrayList<>(); //stocker les creatures qui le joueur peut combattre
        
        //Ici, on: 
        //- stocke dans un ArrayList tous les creatures que le joueur peut combattre
        //- affiche au joueur tous ses possibles combattants
        for (int i = 0 ; i <= dist; i++){
            //verifier si on ne sort pas des limites du monde
            //creatures au nord
            if( y+i <= perso.getMonde().taille ){
                if(perso.getMonde().getCreatures(x,y+i) instanceof Combattant){
                    System.out.println(i + perso.getMonde().getCreatures(x,y+i).toString());
                    creat.add(perso.getMonde().getCreatures(x,y+i));
                }
            }
            //creatures a l'ouest
            if( x-i <= perso.getMonde().taille ){
                if(perso.getMonde().getCreatures(x-i,y) instanceof Combattant){
                    System.out.println(i + perso.getMonde().getCreatures(x-i,y).toString());
                    creat.add(perso.getMonde().getCreatures(x-i,y));
                }
            }
            //creatures a l'est
            if( x+i <= perso.getMonde().taille ){
                if(perso.getMonde().getCreatures(x+i,y) instanceof Combattant){
                    System.out.println(i + perso.getMonde().getCreatures(x+i,y).toString()); 
                    creat.add(perso.getMonde().getCreatures(x+i,y));
                }
            }
            //creatures au sud
            if( y-i <= perso.getMonde().taille ){
                if(perso.getMonde().getCreatures(x,y-i) instanceof Combattant){
                    System.out.println(i + perso.getMonde().getCreatures(x,y-i).toString()); 
                    creat.add(perso.getMonde().getCreatures(x,y-i));
                }
            }
    }
        
    //Ici, on attend le choix du joueur et appelle la fonction combattre
    Scanner keyboard = new Scanner(System.in);
    int choixCombat = keyboard.nextInt();
       
    while(choixCombat > creat.size() || choixCombat <= 0) {
        System.out.println("Svp selectionnez une option valide.");
        choixCombat = keyboard.nextInt();
    }
    
    ((Combattant)perso).combattre(creat.get(choixCombat));
    
}
}
