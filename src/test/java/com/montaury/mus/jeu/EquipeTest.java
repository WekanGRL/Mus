package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Equipe;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EquipeTest {



  @Test
  void devrait_avoir_deux_joueurs() {

    Equipe equipeH =  Equipe.humain("EquipeHumainOrdi",2);

    assertThat(equipeH.getNombreJoueurs()==2).isTrue();
  }

  @Test
  void devrait_avoir_un_joueur() {

    Equipe equipeH =  Equipe.humain("EquipeHumainOrdi",1);

    assertThat(equipeH.getNombreJoueurs()==1).isTrue();
  }



}
