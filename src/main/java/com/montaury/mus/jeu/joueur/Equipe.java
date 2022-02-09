package com.montaury.mus.jeu.joueur;

import com.montaury.mus.console.InterfaceJoueurHumain;
import com.montaury.mus.jeu.carte.Carte;
import java.util.List;

public class Equipe {
    public static Equipe humain(String nom) {
        return new Equipe(nom, Joueur.humain(nom));
    }

    public static Equipe ordinateur() {
        return new Equipe("Ordinateur",Joueur.ordinateur());
    }

    private final String nom;
    public final Joueur joueur;
    private final Main main = Main.vide();

    public Equipe(String nom, Joueur joueur) {
        this.nom = nom;
        this.joueur = joueur;
    }

    public String nom() {
        return nom;
    }

    public Main main() {
        return main;
    }

    public void donnerCartes(List<Carte> cartes) {
        this.joueur.donnerCartes(cartes);
    }
}
