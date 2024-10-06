/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;
import java.util.Scanner;

/**
 *  Implements la classe du joueur humain
 * @author Larissa et Clara
 */
public class Joueur{
    Personnage perso;
    World monde;

    

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

}
