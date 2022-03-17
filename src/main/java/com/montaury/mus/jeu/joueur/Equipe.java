package com.montaury.mus.jeu.joueur;

import java.util.List;

public class Equipe {

    private final String nom;
    private final Main main = Main.vide();
    private Joueur joueurUn;
    private Joueur joueurDeux;
    private int nbJoueursEquipe;

    public Equipe(Joueur joueur1, Joueur joueur2) {
        this.nom = joueur1.getNom();
        this.joueurUn = joueur1;
        this.joueurDeux = joueur2;
        this.joueurUn.setEquipe(this);
        this.joueurDeux.setEquipe(this);
        this.nbJoueursEquipe=2;
    }

    public Equipe(Joueur joueur1) {
        this.nom = joueur1.getNom();
        this.joueurUn = joueur1;
        joueur1.setEquipe(this);
        this.nbJoueursEquipe=1;
    }



    public Joueur getJoueurUn() {
        return joueurUn;
    }

    public Joueur getJoueurDeux() {
        return joueurDeux;
    }

    public int getNombreJoueurs() {
        return nbJoueursEquipe;
    }

    public String getNom() {
        return nom;
    }

    public Main main() {
        return main;
    }


    public static Equipe humain(String nom ,int nombreJoueurs) {
        Equipe resultat=null;
        if (nombreJoueurs==2)
        {
            resultat= new Equipe(Joueur.humain(nom), Joueur.ordinateur());
        }
        else if (nombreJoueurs==1) {
            resultat= new Equipe(Joueur.humain(nom));
        }
        return resultat;
    }


    public static Equipe ordinateur(int nombreJoueurs) {
        Equipe resultat=null;
        if (nombreJoueurs==2)
        {
            resultat= new Equipe(Joueur.ordinateur(), Joueur.ordinateur());
        }
        else if (nombreJoueurs==1) {
            resultat= new Equipe(Joueur.ordinateur());
        }
        return resultat;
    }

}
