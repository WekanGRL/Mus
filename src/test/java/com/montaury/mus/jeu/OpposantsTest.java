package com.montaury.mus.jeu;

import com.montaury.mus.jeu.evenements.Evenements;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurFaisantChoix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class OpposantsTest {






  @Test
  void devrait_tourner_dans_lordre_en2v2() {

    Equipe equipeH =  Equipe.humain("EquipeHumainOrdi",2);

    Equipe equipeO =  Equipe.ordinateur(2);

    Opposants opposition = new Opposants(equipeH,equipeO);

    opposition.tourner();

    //Apres T1, Joueur Humain devrait etre Zaku
    //Apres T1, Joueur Ordi dans equipe Humain devrait etre RANDOM
    //Apres T1, Joueur 1 dans equipe Ordi devrait etre Esku
    //Apres T1, Joueur 2 dans equipe Ordi devrait etre RANDOM

    assertThat(opposition.isZaku(equipeH.getJoueurUn())).isTrue();
    assertThat(opposition.isZaku(equipeH.getJoueurDeux())).isFalse();
    assertThat(opposition.isZaku(equipeO.getJoueurUn())).isFalse();
    assertThat(opposition.isZaku(equipeO.getJoueurDeux())).isFalse();

    assertThat(opposition.isEsku(equipeH.getJoueurUn())).isFalse();
    assertThat(opposition.isEsku(equipeH.getJoueurDeux())).isFalse();
    assertThat(opposition.isEsku(equipeO.getJoueurUn())).isTrue();
    assertThat(opposition.isEsku(equipeO.getJoueurDeux())).isFalse();



    opposition.tourner();

    //Apres T2, Joueur Humain devrait etre RANDOM
    //Apres T2, Joueur Ordi dans equipe Humain devrait etre Esku
    //Apres T2, Joueur 1 dans equipe Ordi devrait etre Zaku
    //Apres T2, Joueur 2 dans equipe Ordi devrait etre RANDOM

    assertThat(opposition.isZaku(equipeH.getJoueurUn())).isFalse();
    assertThat(opposition.isZaku(equipeH.getJoueurDeux())).isFalse();
    assertThat(opposition.isZaku(equipeO.getJoueurUn())).isTrue();
    assertThat(opposition.isZaku(equipeO.getJoueurDeux())).isFalse();

    assertThat(opposition.isEsku(equipeH.getJoueurUn())).isFalse();
    assertThat(opposition.isEsku(equipeH.getJoueurDeux())).isTrue();
    assertThat(opposition.isEsku(equipeO.getJoueurUn())).isFalse();
    assertThat(opposition.isEsku(equipeO.getJoueurDeux())).isFalse();

  }

  @Test
  void devrait_tourner_dans_lordre_en1v1() {

    Equipe equipeH =  Equipe.humain("EquipeHumain",1);

    Equipe equipeO =  Equipe.ordinateur(1);

    Opposants opposition = new Opposants(equipeH,equipeO);

    opposition.tourner();

    //Apres T1, Joueur Humain devrait etre Zaku
    //Apres T1, Joueur 1 dans equipe Ordi devrait etre Esku

    assertThat(opposition.isZaku(equipeH.getJoueurUn())).isTrue();
    assertThat(opposition.isZaku(equipeO.getJoueurUn())).isFalse();

    assertThat(opposition.isEsku(equipeH.getJoueurUn())).isFalse();
    assertThat(opposition.isEsku(equipeO.getJoueurUn())).isTrue();


    opposition.tourner();

    //Apres T2, Joueur Humain devrait etre Esku
    //Apres T2, Joueur 1 dans equipe Ordi devrait etre Zaku

    assertThat(opposition.isZaku(equipeH.getJoueurUn())).isFalse();
    assertThat(opposition.isZaku(equipeO.getJoueurUn())).isTrue();

    assertThat(opposition.isEsku(equipeH.getJoueurUn())).isTrue();
    assertThat(opposition.isEsku(equipeO.getJoueurUn())).isFalse();


  }




}
