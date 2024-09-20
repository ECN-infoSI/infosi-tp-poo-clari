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
        monMonde.peon.setNom("Peon");
        
        monMonde.robin.setNom("Robin");
        monMonde.robin.setPageAtt(20);
        
        monMonde.bugs.setPtPar(5);
        
        monMonde.afficheMonde();
        System.out.println("Position de Robin ------ x: " + monMonde.robin.getPos().getX() + ", Y: "+ monMonde.robin.getPos().getY());
        System.out.println("Position de GuillaumeT ------ x: " + monMonde.guillaumeT.getPos().getX() + ", Y: "+ monMonde.guillaumeT.getPos().getY());

        //Afficher le monde apres un deplacement
        System.out.println("Allez-y! Déplacez-vous!");
        monMonde.robin.deplace();
        monMonde.afficheMonde();

        System.out.println("Position de Robin ------ x: " + monMonde.robin.getPos().getX() + ", Y: "+ monMonde.robin.getPos().getY());
        System.out.println("Position de GuillaumeT ------ x: " + monMonde.guillaumeT.getPos().getX() + ", Y: "+ monMonde.guillaumeT.getPos().getY());
        
        
        monMonde.robin.affiche();
        monMonde.bugs.affiche();

    } 
}
