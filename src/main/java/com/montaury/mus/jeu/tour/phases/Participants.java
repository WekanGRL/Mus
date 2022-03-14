package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Choix;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.TypeChoix;

import java.util.ArrayList;
import java.util.List;

public class  Participants {
  private final List<Joueur> dansLOrdre;

  public Participants(List<Joueur> dansLOrdre) {
    this.dansLOrdre = dansLOrdre;
  }

  public boolean aucun() {
    return dansLOrdre.isEmpty();
  }

  public boolean estUnique() {
    return dansLOrdre.size() == 1;
  }

  public boolean equipeEstUnique(){
    var uneEquipe = dansLOrdre.get(0).getEquipe();
    for(int i = 1; i < dansLOrdre.size(); i++){
      if(dansLOrdre.get(i).getEquipe() != uneEquipe){
        return false;
      }
    }
    return true;
  }

  public Joueur premier() {
    return dansLOrdre.get(0);
  }




  public Joueur adversaireDe(Joueur joueurParlant) {
    Joueur adversaire = null;
    if(dansLOrdre.get(0).getEquipe() == joueurParlant.getEquipe())
      adversaire = dansLOrdre.get(1);
    else{
      adversaire = dansLOrdre.get(0);
    }
    return adversaire;
  }




  public Iterable<Joueur> dansLOrdre() {
    return dansLOrdre;
  }

  public Participants retirer(Joueur joueur) {
    var joueurs = new ArrayList<>(dansLOrdre);
    joueurs.remove(joueur);
    return new Participants(joueurs);
  }


}

