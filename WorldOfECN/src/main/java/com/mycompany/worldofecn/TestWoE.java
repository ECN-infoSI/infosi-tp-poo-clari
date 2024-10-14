/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int nbArcher , nbPaysan , nbGuerrier , nbLapin, nbLoup , nbEpee, nbPotion;
        
        /**Essai d'un jeu**/
        
        //Creation d'un monde
        World monMonde = new World();
        
        Joueur moi = new Joueur();
        moi.choixPersonnage();
        
        monMonde.tourDeJeu();
        moi.choixTourDeJeu();
        
        //tourDeJeu: deplacer tous les personnages, demander a l'humain ce qu'il veut faire, executer l'action, fin
        
        
        //Illustrez le bon fonctionnement de votre solution en créant un nombre tiré
        //aléatoirement (nombre différent pour chaque « type » de Personnage) de :
        
        Random generateurAleatoire = new Random();
        
        nbArcher = 20;
        nbPaysan = 20;
        nbGuerrier = 20;
        nbLapin = 1000;
        nbLoup = 0;
        nbEpee = 5;
        nbPotion = 5;
       
        /*
        System.out.println("nbArcher = " + nbArcher);
        System.out.println("nbPaysan = " + nbPaysan);
        System.out.println("nbGuerrier = " + nbGuerrier);
        System.out.println("nbLapin = " + nbLapin);
        System.out.println("nbLoup = " + nbLoup);
        System.out.println("nbEpees = " + nbEpee);
        System.out.println("nbPotions = " + nbPotion);
        */
        monMonde.creerMondeAlea(nbArcher, nbPaysan, nbGuerrier, nbLapin, nbLoup, nbEpee, nbPotion);
        
        /*
        ArrayList<Personnage> person = monMonde.getPersonnages();
        int ptVieTotal = 0;
        for (int i = 0; i < person.size(); i++) {
            System.out.println("ptVie du Personnage " + i + " = "+ person.get(i).getPtVie());
            ptVieTotal += person.get(i).getPtVie();
            
        }
        System.out.println("-----");
        System.out.println("ptVieTotal pour "+ (person.size()) + " personnages = "+ ptVieTotal);
        */
      
        //Tester les differents iterateurs 
        long debutN = System.nanoTime();
        
        ArrayList<Monstre> monsterArray;
        monsterArray = monMonde.getMonstres();
        
        //test parcours de liste par size()
        for(int i = 0; i < monsterArray.size(); i++){
            Monstre p;
            p = (monsterArray.get(i));
        }
        
        //test parcours de liste par l'iterateur()
        Iterator<Monstre> listIt = monsterArray.iterator();
        while(listIt.hasNext()) {
            Monstre p = listIt.next();
        }
        
        long finN = System.nanoTime();
        System.out.println("Temps ecoule en ns: " + (finN - debutN));
        
        /*
        //Test setters
        monMonde.peon.setPtVie(10);
        
        //Set guerrier
        monMonde.grosBill.setPageAtt(40); //baisse percentage de reussite d'attaque
        monMonde.grosBill.setDegAtt(75); //haut degat d'attaque
        monMonde.grosBill.setDistAttMax(0); //combat corps a corps seulement
        monMonde.grosBill.setPtVie(100);
        monMonde.grosBill.setPagePar(80); //haute percentage de defense
        monMonde.grosBill.setPtPar(50); //haut degat fait en cas de defense

        //Set archer
        monMonde.robin.setPageAtt(80); //haute percentage de reussite d'attaque
        monMonde.robin.setDegAtt(40); //baisse degat d'attaque
        monMonde.robin.setDistAttMax(6); //peut se combattre a distance
        monMonde.robin.setPtVie(100); 
        monMonde.robin.setPagePar(80); //haute percentage de defense
        monMonde.robin.setPtPar(40); //baisse degat fait en cas de defense
        monMonde.robin.setNbFleches(10);
        
        monMonde.guillaumeT.setPageAtt(80); //haute percentage de reussite d'attaque
        monMonde.guillaumeT.setDegAtt(40); //baisse degat d'attaque
        monMonde.guillaumeT.setDistAttMax(6); //peut se combattre a distance
        monMonde.guillaumeT.setPtVie(100); 
        monMonde.guillaumeT.setPagePar(80); //haute percentage de defense
        monMonde.guillaumeT.setPtPar(40); //baisse degat fait en cas de defense
        monMonde.guillaumeT.setNbFleches(10);
        
        //Set loup
        monMonde.wolfie.setPageAtt(50); //moyenne percentage de reussite d'attaque
        monMonde.wolfie.setDegAtt(85); //haute degat d'attaque
        monMonde.wolfie.setPtVie(100);
        monMonde.wolfie.setPagePar(40); //baisse percentage de defense
        monMonde.wolfie.setPtPar(85); //haut degat fait en cas de defense
        
        
        monMonde.bugs1.setPtPar(5);
        
        monMonde.afficheWorld();
        
        //Afficher le monde apres un deplacement
        System.out.println("Allez-y! Déplacez-vous!");
        monMonde.robin.deplace();
        monMonde.bugs1.deplace();
        monMonde.afficheWorld();

        System.out.println(monMonde.peon.getPos());
        System.out.println(monMonde.wolfie.getPos());
        //Tests avec la nouvelle classe Creature
        //monMonde.robin.affiche();
        //monMonde.bugs1.affiche();
       
        
        monMonde.robin.affiche();
        monMonde.bugs1.affiche();
        monMonde.bugs2.affiche();
        monMonde.peon.affiche();
        monMonde.grosBill.affiche();
        monMonde.wolfie.affiche();
        monMonde.guillaumeT.affiche();
        
        System.out.println("Distance entre Wolfie et Paysan: "+ monMonde.peon.getPos().distance(monMonde.wolfie.getPos()));
        
        
        //Tests combattre
        System.out.println("Il va commencer les combats !");
        
        //Combat corps a corps
   
        //Loup x Guerrier
        System.out.println("--Wolfie vs Gros Bill--");
        monMonde.wolfie.getPos().setPosition(10,10);
        monMonde.grosBill.getPos().setPosition(10,11);
        System.out.println("Distance entre Wolfie et Guerrier: "+ monMonde.grosBill.getPos().distance(monMonde.wolfie.getPos()));
        monMonde.wolfie.combattre(monMonde.grosBill);
        System.out.println("--");
        
        //Guerrier x Loup
        System.out.println("--Gros Bill vs Wolfie--");
        System.out.println("Distance entre Wolfie et Guerrier: "+ monMonde.grosBill.getPos().distance(monMonde.wolfie.getPos()));
        monMonde.grosBill.combattre(monMonde.wolfie);
        System.out.println("--");
        
        //Loup x Archer
        System.out.println("--Wolfie vs Robin--");
        monMonde.robin.getPos().setPosition(9,10);
        System.out.println("Distance entre Wolfie et Archer: "+ monMonde.robin.getPos().distance(monMonde.wolfie.getPos()));
        monMonde.wolfie.combattre(monMonde.robin);
        System.out.println("--");
        
        
        //Archer x Loup
        System.out.println("--Robin vs Wolfie--");
        monMonde.robin.combattre(monMonde.wolfie);
        System.out.println("--");
        
        //Guerrier x Archer
        //monMonde.grosBill.combattre(monMonde.robin);
        
        //Archer x Guerrier - combat a distance
        System.out.println("--Robin vs GrosBill--");
        System.out.println("Distance entre Guerrier et Archer: "+ monMonde.robin.getPos().distance(monMonde.grosBill.getPos()));
        monMonde.robin.combattre(monMonde.grosBill);
        System.out.println("--");
        
        //Archer x Loup -- combat a distance
        System.out.println("--Robin vs Wolfie--");
        monMonde.robin.getPos().setPosition(13,13);
        System.out.println("Distance entre Wolfie et Archer: "+ monMonde.robin.getPos().distance(monMonde.wolfie.getPos()));
        monMonde.robin.combattre(monMonde.wolfie);
        System.out.println("--");
        
        //Essai de faire un combat a distance avec Wolfie
        System.out.println("--Wolfie vs Robin--");
        monMonde.wolfie.combattre(monMonde.robin);
        System.out.println("--");
        
        System.out.println("--Robin vs GuillaumeT--");
        monMonde.guillaumeT.getPos().setPosition(14,14);
        System.out.println("Distance entre GuillaumeT et Robin: "+ monMonde.robin.getPos().distance(monMonde.guillaumeT.getPos()));
        monMonde.robin.combattre(monMonde.guillaumeT);
        System.out.println("--");
 
        
        
        //Test d'objets
        System.out.println("-----");
        System.out.println("Test d'objets");
        System.out.println("-----");
        
        Point2D positionPotion = new Point2D(13,14);
        monMonde.guillaumeT.setPos(new Point2D(positionPotion.getX(), positionPotion.getY()-1));
        monMonde.potion1.setPos(positionPotion);
        
        
        monMonde.afficheWorld();
        System.out.print("Position de la potion: ");
        monMonde.potion1.getPos().affiche();
        System.out.print("Position de GuillaumeT: ");
        monMonde.guillaumeT.getPos().affiche();
        System.out.println("Pts de vie de GuillaumeT: " + monMonde.guillaumeT.getPtVie());
        System.out.println("-----");
        
        System.out.println("GuillaumeT se deplace!");
        monMonde.guillaumeT.setPos(positionPotion);
        monMonde.afficheWorld();

        System.out.print("Position de GuillaumeT: ");
        monMonde.guillaumeT.getPos().affiche();
        System.out.println("Pts de vie de GuillaumeT: " + monMonde.guillaumeT.getPtVie());
        
        monMonde.afficheWorld();
        System.out.println("-----");
        
        
        
        //Afficher le monde avec des potions soin
*/
        System.out.println("Monde initiaux: ");
        monMonde.afficheWorld();
        System.out.println("-----");
        
        ArrayList<Personnage> person = monMonde.getPersonnages();
        for (int i = 0; i < person.size(); i++) {
            person.get(i).deplace();
        }
        
        System.out.println("Monde après le déplacement de tous les protagonistes: ");
        monMonde.afficheWorld();
        System.out.println("-----");
        
        ArrayList<Monstre> monstres = monMonde.getMonstres();
        for (int i = 0; i < monstres.size(); i++) {
            monstres.get(i).deplace();
        }
        
        System.out.println("Monde après le déplacement de tous les montres: ");
        monMonde.afficheWorld();
        System.out.println("-----");
        
    } 
}
