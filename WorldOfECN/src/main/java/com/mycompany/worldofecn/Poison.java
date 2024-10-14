/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author User
 */
public class Poison extends Nourriture{

    public Poison(Point2D pos, World monde, int energie, int duree) {
        super(pos, monde, energie, duree);
    }

    public Poison() {
    }

    public Poison(Nourriture n) {
        super(n);
    }
    
}
