package com.montaury.mus.jeu.joueur;

import com.montaury.mus.console.InterfaceJoueurHumain;
import com.montaury.mus.jeu.carte.Carte;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    public static Equipe humain(String nom) {
        return new Equipe(nom, Joueur.humain(nom));
    }

    public static Equipe ordinateur() {
        return new Equipe("Ordinateur",Joueur.ordinateur());
    }

    private final String nom;
    private final Main main = Main.vide();

    public List<Joueur> listeJoueurs = new ArrayList<>();

    public Equipe(String nom, Joueur joueur) {
        this.nom = nom;
        listeJoueurs.add(joueur);
    }

    public String nom() {
        return nom;
    }

    public Main main() {
        return main;
    }

    public void donnerCartes(List<Carte> cartes) {
        this.listeJoueurs.get(0).donnerCartes(cartes);
    }

}
