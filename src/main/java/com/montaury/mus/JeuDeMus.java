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
    Equipe equipeHumain;
    Equipe equipeOrdi;
    Partie partie;
    Partie.Resultat resultat;

    System.out.print("Entrez votre nom: ");
    var nomJoueur = new Scanner(System.in).next();

    System.out.print("Voulez-vous jouer en 1v1(tapez 1) ou 2v2(tapez 2): ");
    var typeDeJeu=Integer.parseInt(new Scanner(System.in).next());

    while((!(typeDeJeu==1))&&(!(typeDeJeu==2)))
    {
      System.out.print("Voulez-vous jouer en 1v1(tapez 1) ou 2v2(tapez 2): ");
      typeDeJeu=Integer.parseInt(new Scanner(System.in).next());
    }

    equipeOrdi=Equipe.ordinateur(typeDeJeu);


    if(typeDeJeu==1)
    {
      equipeHumain = Equipe.humain(nomJoueur,typeDeJeu);
    }
    else
    {
      System.out.print("Entrez votre nom d'équipe: ");
      var nomEquipe = new Scanner(System.in).next();

      equipeHumain = Equipe.humain(nomEquipe,typeDeJeu);

      equipeOrdi.getJoueurUn().setNom("Ordinateur ennemi 1");
      equipeOrdi.getJoueurDeux().setNom("Ordinateur ennemi 2");
      equipeHumain.getJoueurUn().setNom(nomJoueur);
      equipeHumain.getJoueurDeux().setNom("Ordinateur Allie");
    }

    partie = new Partie(new AffichageEvenements(equipeHumain.getJoueurUn()));
    resultat = partie.jouer(new Opposants(equipeHumain, equipeOrdi));
    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
  }
}

