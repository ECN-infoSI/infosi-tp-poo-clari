/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.worldofecn;

/**
 *
 * @author Clara MATTOS MEDEIROS et Larissa ALBUQUERQUE NOGUEIRA
 */
public class Personnage extends Creature{
    private String nom;
    private int distAttMax;
    
    /**
     *
     * @param n Nom du Personnage
     * @param pV Points de Vie
     * @param dA Degats d'Attaque
     * @param pPar Points de Parade
     * @param paAtt Pourcentage d'Attaque
     * @param paPar Pourcentage de Parade
     * @param dMax Distance maximale d'attaque
     * @param p Objet du type Point2D pour la position du Personnage dans le monde
     * @param monde La carte avec toutes les personnages du jeu
     */
    public Personnage (String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, World monde){
        super(pV, dA, pPar, paAtt, paPar, p, monde);
        this.nom = n;
        this.distAttMax = dMax;
    }
    
    /**
     *
     * @param p
     */
    public Personnage (Personnage p) {
       this(p.getNom(),
               p.getPtVie(), p.getDegAtt(),
               p.getPtPar(), p.getPageAtt(),
               p.getPagePar(), p.getDistAttMax(),
               new Point2D(p.getPos()), p.getMonde());
    }
    
    /**
     * Constructeur par défaut de Personnage
     */
    public Personnage () {
        super();
        this.nom = "";
        this.distAttMax = 0;
    }

    /**
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }
   
    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return distAttMax
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }         

    /**
     *
     * Retour de tous les attributs du Personnage
     */
    @Override
    public String toString() {
        return super.toString() + "Personnage{" + "nom=" + nom + ", distAttMax=" + distAttMax + '}';
    }
    
    /**
     * Afficher les informations du personnage
     */
    @Override
    public void affiche() {
        System.out.println(this.toString());
    }
    
    /**
     * Fonction qui verifie s'il y a une potion, et que traite le cas s'il y en a une.
     * Dans le cas où il y en a, le personnage bois la potion,
     * la force de la potion est sommé à ses points de vie et après la potion disparait. 
     * Une message est affiché.
     */
    public void boireSoin() {
        if (this.getMonde() != null) {
            if (this.getMonde().getObjetMap()[this.getPos().getX()][this.getPos().getY()] instanceof PotionSoin) {
                PotionSoin p = (PotionSoin)this.getMonde().getObjetMap()[this.getPos().getX()][this.getPos().getY()];
                this.setPtVie(this.getPtVie()+p.getForce());
                p.disparaitre();
                System.out.println("!!!!Le personnage a bu la potion!!!!!");
            }
        }
    }

    /**
     * Déplace un personnage dans le monde
     */
    @Override
    public void deplace() {
        super.deplace();
        boireSoin();
    }
    
    /**
     *
     * @param pos
     */
    @Override 
    public void setPos(Point2D pos) {
        super.setPos(pos);
        boireSoin();
    }
}
