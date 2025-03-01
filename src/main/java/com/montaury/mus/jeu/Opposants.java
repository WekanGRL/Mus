package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;

import java.util.*;

public class Opposants {
  private Equipe equipeEsku;
  private Equipe equipeZaku;
  Deque<Joueur> fileJoueur = new ArrayDeque<>() {};

  public Opposants(Equipe equipeUn, Equipe equipeDeux) {
    this.equipeEsku = equipeUn;
    this.equipeZaku = equipeDeux;

    if (equipeUn.getNombreJoueurs() == 2 && equipeDeux.getNombreJoueurs() == 2) {
      // On considère que l'équipe 1 commence :
      fileJoueur.add(equipeUn.getJoueurUn());
      fileJoueur.add(equipeDeux.getJoueurUn());
      fileJoueur.add(equipeUn.getJoueurDeux());
      fileJoueur.add(equipeDeux.getJoueurDeux());
    }
    else
    {
      if(equipeUn.getNombreJoueurs() == 1 && equipeDeux.getNombreJoueurs() == 1)
      {
        fileJoueur.add(equipeUn.getJoueurUn());
        fileJoueur.add(equipeDeux.getJoueurUn());
      }
    }
  }

  public Opposants(Joueur joueurUn, Joueur joueurDeux){
    fileJoueur.add(joueurUn);
    fileJoueur.add(joueurDeux);
  }



  public void tourner() {
    var tmp=fileJoueur.remove();
    fileJoueur.add(tmp);
  }



  public Equipe equipeEsku() {
    return this.equipeEsku;
  }

  public Equipe equipeZaku(){
    return this.equipeZaku;
  }

  public Joueur joueurEsku() {
    return fileJoueur.getFirst();
  }

  public boolean isEsku(Joueur joueur){
    return joueur == fileJoueur.getFirst();
  }

  public boolean isZaku(Joueur joueur){
    return joueur == fileJoueur.getLast();
  }

  public List<Joueur> dansLOrdre() {
    List<Joueur> maListe;
    if(fileJoueur.size() > 2){

      //On remove car impossible de selectionner un joueur en particulier dans un Deque (uniquement le premier et le dernier)
      var pos1 = fileJoueur.remove();
      var pos2 = fileJoueur.remove();
      var pos3 = fileJoueur.remove();
      var pos4 = fileJoueur.remove();
      maListe = List.of(pos1,pos2,pos3,pos4);

      fileJoueur.add(pos1);
      fileJoueur.add(pos2);
      fileJoueur.add(pos3);
      fileJoueur.add(pos4);
    }
    else{
      var pos1=fileJoueur.remove();
      var pos2 = fileJoueur.remove();
      maListe = List.of(pos1,pos2);

      fileJoueur.add(pos1);
      fileJoueur.add(pos2);
    }

    return maListe;
  }
}
