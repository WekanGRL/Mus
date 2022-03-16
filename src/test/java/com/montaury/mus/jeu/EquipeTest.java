package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Equipe;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EquipeTest {



  @Test
  void devrait_avoir_un_joueur() {

    Equipe equipeH =  Equipe.humain("EquipeHumainOrdi",1);

    assertThat(equipeH.getNombreJoueurs()==1).isTrue();
  }


  @Test
  void devrait_avoir_deux_joueurs() {

    Equipe equipeH =  Equipe.humain("EquipeHumainOrdi",2);

    assertThat(equipeH.getNombreJoueurs()==2).isTrue();
  }


  @Test
  void devrait_creer_1_joueur_humain_et_un_joueur_ordinateur()
  {
    Equipe equipeHumain =Equipe.humain("equipeTest",2);

    assertThat(equipeHumain.getJoueurUn().getNom()=="equipeTest" && equipeHumain.getJoueurDeux().getNom()=="Ordinateur").isTrue();

  }

  @Test
  void devrait_creer_2_joueurs_qui_sont_des_joueurs_ordinateurs()
  {
    Equipe equipeOrdinateur =Equipe.ordinateur(2);

    assertThat(equipeOrdinateur.getJoueurUn().getNom()=="Ordinateur" && equipeOrdinateur.getJoueurDeux().getNom()=="Ordinateur").isTrue();

  }



}
