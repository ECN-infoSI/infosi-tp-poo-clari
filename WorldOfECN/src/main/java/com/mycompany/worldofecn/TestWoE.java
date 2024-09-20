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
        monMonde.afficheMonde();
        
        System.out.println(monMonde.peon);
        System.out.println(monMonde.bugs);
        System.out.println(monMonde.robin);
        
        //Test setters
        monMonde.peon.setPtVie(10);
        monMonde.peon.setNom("Peon");
        
        monMonde.robin.setNom("Robin");
        monMonde.robin.setPageAtt(20);
        
        monMonde.bugs.setPtPar(5);
        
        //Test getters
        System.out.println(monMonde.peon.getNom());
        System.out.println(monMonde.peon.getPtVie());
        
        monMonde.robin.affiche();
        
        monMonde.bugs.getPos().affiche();
        
        //Test deplace
        monMonde.bugs.deplace();
        monMonde.bugs.affiche();
        monMonde.bugs.getPos().affiche();
        
        //Afficher le monde apres un deplacement
        monMonde.afficheMonde();
  
    }
    
}
