/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Larissa
 */
public class ChampignonMagique extends Nourriture{

    public ChampignonMagique(Point2D pos, World monde, int energie, int duree) {
        super(pos, monde, energie, duree);
    }

    public ChampignonMagique() {
    }

    public ChampignonMagique(Nourriture n) {
        super(n);
    }
    
}
