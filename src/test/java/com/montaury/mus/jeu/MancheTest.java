package com.montaury.mus.jeu;

import com.montaury.mus.jeu.evenements.Evenements;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurFaisantChoix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class MancheTest {

  @BeforeEach
  void setUp() {
    manche = new Manche(mock(Evenements.class));
  }


  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////Test 1V1\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  @Test
  void devrait_terminer_la_manche_si_hordago_au_grand_1v1() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago());
    var joueurZaku = unJoueurFaisantChoix(new Kanta());
    var opposants = new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku));

    var resultat = manche.jouer(opposants);

    assertThat(resultat.vainqueur()).isNotNull();
    assertThat(resultat.pointsVaincu()).isZero();
  }




  @Test
  void devrait_terminer_la_manche_si_un_joueur_a_40_points1v1() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Imido(), new Gehiago(2));
    var joueurZaku = unJoueurFaisantChoix(new Gehiago(40), new Tira());
    var opposants = new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku));


    var resultat = manche.jouer(opposants);

    assertThat(resultat.vainqueur()).isEqualTo(joueurEsku.getEquipe());
    assertThat(resultat.pointsVaincu()).isZero();
  }

  @Test
  void devrait_changer_l_ordre_des_opposants_a_la_fin_du_tour1v1() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago());
    var joueurZaku = unJoueurFaisantChoix(new Kanta());
    var opposants = new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku));

    manche.jouer(opposants);

    assertThat(opposants.dansLOrdre()).containsExactly(joueurZaku, joueurEsku);
  }



  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////Test 2V2\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  @Test
  void devrait_terminer_la_manche_si_hordago_au_grand_2v2() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago());
    var joueurApresEsku = unJoueurFaisantChoix(new Kanta());
    var joueurAvantZaku = unJoueurFaisantChoix(new Kanta());
    var joueurZaku = unJoueurFaisantChoix(new Kanta());

    var opposants = new Opposants(new Equipe(joueurEsku,joueurAvantZaku), new Equipe(joueurApresEsku,joueurZaku));

    var resultat = manche.jouer(opposants);

    assertThat(resultat.vainqueur()).isNotNull();
    assertThat(resultat.pointsVaincu()).isZero();
  }

  @Test
  void devrait_terminer_la_manche_si_une_equipe_a_40_points2v2() {

    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Imido(), new Gehiago(2));
    var joueurApresEsku = unJoueurFaisantChoix(new Gehiago(40), new Tira());
    var joueurAvantZaku = unJoueurFaisantChoix(new Paso());
    var joueurZaku = unJoueurFaisantChoix(new Tira());

    var opposants = new Opposants(new Equipe(joueurEsku,joueurAvantZaku), new Equipe(joueurApresEsku,joueurZaku));


    var resultat = manche.jouer(opposants);

    assertThat(resultat.vainqueur()).isEqualTo(joueurEsku.getEquipe());
    assertThat(resultat.pointsVaincu()).isZero();
  }

  @Test
  void devrait_changer_l_ordre_des_opposants_a_la_fin_du_tour2v2() {

    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago());
    var joueurApresEsku = unJoueurFaisantChoix( new Kanta());
    var joueurAvantZaku = unJoueurFaisantChoix(new Paso());
    var joueurZaku = unJoueurFaisantChoix(new Kanta());

    var opposants = new Opposants(new Equipe(joueurEsku,joueurAvantZaku), new Equipe(joueurApresEsku,joueurZaku));


    manche.jouer(opposants);

    assertThat(opposants.dansLOrdre()).containsExactly(joueurApresEsku, joueurAvantZaku,joueurZaku,joueurEsku);
  }

  private Manche manche;
}
