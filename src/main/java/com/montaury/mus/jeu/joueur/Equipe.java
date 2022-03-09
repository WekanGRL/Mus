package com.montaury.mus.jeu.joueur;

public class Equipe {


    public static Equipe humain(String nom ,int nombreJoueurs) {
        Equipe resultat=null;
        if (nombreJoueurs==2)
        {
            resultat= new Equipe(Joueur.humain(nom), Joueur.ordinateur());
            resultat.setNombreJoueurs(2);
        }
        else if (nombreJoueurs==1) {
             resultat= new Equipe(Joueur.humain(nom));
            resultat.setNombreJoueurs(1);
        }
        return resultat;
    }



    public static Equipe ordinateur(int nombreJoueurs) {
        Equipe resultat=null;
        if (nombreJoueurs==2)
        {
            resultat= new Equipe(Joueur.ordinateur(), Joueur.ordinateur());
            resultat.setNombreJoueurs(2);
        }
        else if (nombreJoueurs==1) {
            resultat= new Equipe(Joueur.ordinateur());
            resultat.setNombreJoueurs(1);
        }
        return resultat;
    }



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

    public void setNombreJoueurs( int nombreJoueurs) {
        nbJoueursEquipe=nombreJoueurs;
    }

    public String nom() {
        return nom;
    }

    public Main main() {
        return main;
    }

}
