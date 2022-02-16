package com.montaury.mus.jeu.joueur;

import com.montaury.mus.console.InterfaceJoueurHumain;
import com.montaury.mus.jeu.carte.Carte;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    public static Equipe humain(String nom) {
        return new Equipe( Joueur.humain(nom),Joueur.ordinateur());
    }

    public static Equipe ordinateur() {
        return new Equipe(Joueur.ordinateur(),Joueur.ordinateur());
    }

    private final String nom;
    private final Main main = Main.vide();

    private Joueur joueurUn;
    private Joueur joueurDeux;

    public Equipe(Joueur joueur1, Joueur joueur2) {
        this.nom = joueur1.nom();
        this.joueurUn = joueur1;
        this.joueurDeux = joueur2;
        this.joueurUn.setEquipe(this);
        this.joueurDeux.setEquipe(this);
    }

    public Joueur getJoueurUn() {
        return joueurUn;
    }

    public Joueur getJoueurDeux() {
        return joueurDeux;
    }

    public String nom() {
        return nom;
    }

    public Main main() {
        return main;
    }

}
