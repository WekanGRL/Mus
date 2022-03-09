package com.montaury.mus;

import com.montaury.mus.jeu.Partie;
import com.montaury.mus.console.AffichageEvenements;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.Opposants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JeuDeMus {
  public static void main(String[] args) {
    System.out.print("Entrez votre nom: ");
    var nomJoueur = new Scanner(System.in).next();

      System.out.print("Entrez votre nom d'équipe: ");
      var nomEquipe = new Scanner(System.in).next();

      var equipeHumain = Equipe.humain(nomEquipe);

      var equipeOrdi=Equipe.ordinateur();

      equipeOrdi.getJoueurUn().setNom("Ordinateur ennemi 1");
      equipeOrdi.getJoueurDeux().setNom("Ordinateur ennemi 2");

      equipeHumain.getJoueurUn().setNom(nomJoueur);
      equipeHumain.getJoueurDeux().setNom("Ordinateur Allie");

      var partie = new Partie(new AffichageEvenements(equipeHumain.getJoueurUn()));
      var resultat = partie.jouer(new Opposants(equipeHumain, equipeOrdi));

      System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
    }





  }

