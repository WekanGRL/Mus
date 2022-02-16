package com.montaury.mus;

import com.montaury.mus.jeu.Partie;
import com.montaury.mus.console.AffichageEvenements;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.Opposants;
import java.util.Scanner;

public class JeuDeMus {
  public static void main(String[] args) {
    System.out.print("Entrez votre nom d'équipe: ");
    var nomJoueur = new Scanner(System.in).next();
    var equipeHumain = Equipe.humain(nomJoueur);

    var partie = new Partie(new AffichageEvenements(equipeHumain.getJoueurUn()));
    var resultat = partie.jouer(new Opposants(new Equipe(Joueur.humain(nomJoueur),Joueur.ordinateur()), Equipe.ordinateur()));

    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
  }
}
