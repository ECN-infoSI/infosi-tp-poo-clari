/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Larissa ALBUQUERQUE NOGUEIRA et Clara MATTOS MEDEIROS
 */
public class Monstre extends Creature {
    
    /**
     *
     * 
     * @param pV Points de Vie
     * @param dA Degats d'Attaque
     * @param pPar Points de Parade
     * @param paAtt Pourcentage d'Attaque
     * @param paPar Pourcentage de Parade
     * @param p Objet du type Point2D pour la position du Personnage dans le monde
     * @param monde La carte avec toutes les positions de tous les personnages du jeu
     */
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
    }
    
    //Methodes

    /**
     *
     * @param m
     */
    
    public Monstre(Monstre m){
        this(m.getPtVie(), m.getDegAtt(), m.getPtPar(), m.getPageAtt(), m.getPagePar(), new Point2D(m.getPos()), m.getMonde());
    }
    
    /**
     * Constructeur par défaut
     */
    public Monstre(){
        super();
    }
    
}
