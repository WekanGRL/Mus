package com.montaury.mus.jeu.joueur;

public class Equipe {
    public static Equipe humain(String nom ,String nombreJoueurs) {
        if(nombreJoueurs.equals("1"))
        {
            return new Equipe( Joueur.humain(nom),  Joueur.ordinateur());
        }
        else
        {
            return new Equipe( Joueur.humain(nom));
        }

    }



    public static Equipe ordinateur() {
        return new Equipe(Joueur.ordinateur(),Joueur.ordinateur());
    }



    private final String nom;
    private final Main main = Main.vide();

    private Joueur joueurUn;
    private Joueur joueurDeux;

    public Equipe(Joueur joueur1, Joueur joueur2) {
        this.nom = joueur1.getNom();
        this.joueurUn = joueur1;
        this.joueurDeux = joueur2;
        this.joueurUn.setEquipe(this);
        this.joueurDeux.setEquipe(this);
    }

    public Equipe(Joueur joueur1) {
        this.nom = joueur1.getNom();
        joueur1.setEquipe(this);
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
