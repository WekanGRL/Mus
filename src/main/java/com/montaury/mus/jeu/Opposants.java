package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;

import java.util.*;

public class Opposants {
  private Equipe equipeUn;
  private Equipe equipeDeux;
  Deque<Joueur> fileJoueur = new ArrayDeque<>() {};

  public Opposants(Equipe equipeUn, Equipe equipeDeux) {
    this.equipeUn = equipeUn;
    this.equipeDeux = equipeDeux;

    // On considère que l'équipe 1 commence :
    fileJoueur.add(equipeUn.getJoueurUn());
    fileJoueur.add(equipeDeux.getJoueurUn());
    fileJoueur.add(equipeUn.getJoueurDeux());
    fileJoueur.add(equipeDeux.getJoueurDeux());
  }

  public void tourner() {
    var tmp=fileJoueur.remove();
    fileJoueur.add(tmp);

  }


  public Joueur joueurEsku() {
    return fileJoueur.getFirst();
  }

  public Joueur joueurZaku() {
    return fileJoueur.getLast();
  }

  public List<Joueur> dansLOrdre() {
    var pos1 = fileJoueur.remove();
    var pos2 = fileJoueur.remove();
    var pos3 = fileJoueur.remove();
    var pos4 = fileJoueur.remove();

    fileJoueur.add(pos1);
    fileJoueur.add(pos2);
    fileJoueur.add(pos3);
    fileJoueur.add(pos4);
    return List.of(pos1,pos2,pos3,pos4);
  }
}
