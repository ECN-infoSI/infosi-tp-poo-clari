/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author User
 */
public class TestWoE {
    public static void main(String[] args) {
        World monMonde = new World();
        monMonde.creerMondeAlea();
                        
        //Test setters
        monMonde.peon.setPtVie(10);
        monMonde.robin.setPageAtt(20);
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
       
        /*
        monMonde.robin.affiche();
        monMonde.bugs1.affiche();
        monMonde.bugs2.affiche();
        monMonde.peon.affiche();
        monMonde.grosBill.affiche();
        monMonde.wolfie.affiche();
        monMonde.guillaumeT.affiche();
        */
        System.out.println("Distance entre Wolfie et Paysan: "+ monMonde.peon.getPos().distance(monMonde.wolfie.getPos()));
        
    } 
}
