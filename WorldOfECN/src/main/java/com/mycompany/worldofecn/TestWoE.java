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
        
        Random generateurAleatoire = new Random();
        
        nbArcher = 5 + generateurAleatoire.nextInt(10);
        nbPaysan = 5 + generateurAleatoire.nextInt(10);
        nbGuerrier = 5 + generateurAleatoire.nextInt(10);
        nbLapin = 5 + generateurAleatoire.nextInt(10);
        nbLoup = 5 + generateurAleatoire.nextInt(10);
        nbEpee = 5 + generateurAleatoire.nextInt(10);
        nbPotion = 5 + generateurAleatoire.nextInt(10);

        monMonde.creerMondeAlea(nbArcher, nbPaysan, nbGuerrier, nbLapin, nbLoup, nbEpee, nbPotion);

        Joueur moi = new Joueur(monMonde);
        moi.choixPersonnage();
        
        monMonde.setJoueur(moi);
        
        //tourDeJeu: deplacer tous les personnages, demander a l'humain ce qu'il veut faire, executer l'action, fin
        monMonde.tourDeJeu();
        
     
    } 
}
