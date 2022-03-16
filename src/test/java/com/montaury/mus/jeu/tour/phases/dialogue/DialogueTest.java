package com.montaury.mus.jeu.tour.phases.dialogue;

import com.montaury.mus.jeu.evenements.Evenements;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.tour.phases.Participants;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Hordago;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Idoki;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Imido;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Kanta;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Paso;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Tira;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurFaisantChoix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class DialogueTest {

  @BeforeEach
  void setUp() {
    dialogue = new Dialogue(mock(Evenements.class));
  }

  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////Test 1V1\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  @Test
  void engage_un_point_si_les_2_participants_sont_paso1v1() {
    Joueur joueurEsku = unJoueurFaisantChoix(new Paso());
    Joueur joueurZaku = unJoueurFaisantChoix(new Paso());

    var equipeEsku = new Equipe(joueurEsku);
    var equipeZaku = new Equipe(joueurZaku);

    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(), equipeZaku.getJoueurUn())));

    assertThat(recapitulatif.pointsEngages()).isOne();
  }


  @Test
  void est_termine_si_le_dernier_choix_est_tira1v1() {
    Joueur joueurEsku = unJoueurFaisantChoix(new Paso(), new Tira());
    Joueur joueurZaku = unJoueurFaisantChoix(new Imido());

    var equipeEsku = new Equipe(joueurEsku);
    var equipeZaku = new Equipe(joueurZaku);


    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(), equipeZaku.getJoueurUn())));

    assertThat(recapitulatif.pointsEngages()).isOne();
  }


  @Test
  void est_termine_si_le_dernier_choix_est_idoki1v1() {
    Joueur joueurEsku = unJoueurFaisantChoix(new Paso(), new Idoki());
    Joueur joueurZaku = unJoueurFaisantChoix(new Imido());

    var equipeEsku = new Equipe(joueurEsku);
    var equipeZaku = new Equipe(joueurZaku);

    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(), equipeZaku.getJoueurUn())));

    assertThat(recapitulatif.pointsEngages()).isEqualTo(2);
  }

  @Test
  void est_termine_si_le_dernier_choix_est_kanta1v1() {
    Joueur joueurEsku = unJoueurFaisantChoix(new Paso(), new Kanta());
    Joueur joueurZaku = unJoueurFaisantChoix(new Hordago());

    var equipeEsku = new Equipe(joueurEsku);
    var equipeZaku = new Equipe(joueurZaku);

    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(), equipeZaku.getJoueurUn())));

    assertThat(recapitulatif.pointsEngages()).isEqualTo(40);
  }


  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////Test 2V2\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  /////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  @Test
  void engage_un_point_si_les_2_equipe_sont_paso2v2() {
    Joueur joueurEsku = unJoueurFaisantChoix(new Paso());
    Joueur joueurApresEsku = unJoueurFaisantChoix(new Paso());
    Joueur joueurAvantZaku = unJoueurFaisantChoix(new Paso());
    Joueur joueurZaku = unJoueurFaisantChoix(new Paso());

    var equipeEsku = new Equipe(joueurEsku,joueurAvantZaku);
    var equipeZaku = new Equipe(joueurApresEsku,joueurZaku);

    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(),equipeEsku.getJoueurDeux(), equipeZaku.getJoueurUn(),equipeZaku.getJoueurDeux())));


    assertThat(recapitulatif.pointsEngages()).isOne();
  }


  @Test
  void est_termine_si_le_dernier_choix_est_tira2v2() {

    Joueur joueurEsku = unJoueurFaisantChoix(new Paso(), new Tira());
    Joueur joueurApresEsku = unJoueurFaisantChoix(new Imido());
    Joueur joueurAvantZaku = unJoueurFaisantChoix(new Paso(), new Tira());
    Joueur joueurZaku = unJoueurFaisantChoix(new Paso(), new Tira());

    var equipeEsku = new Equipe(joueurEsku,joueurAvantZaku);
    var equipeZaku = new Equipe(joueurApresEsku,joueurZaku);

    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(),equipeEsku.getJoueurDeux(), equipeZaku.getJoueurUn(),equipeZaku.getJoueurDeux())));

    assertThat(recapitulatif.pointsEngages()).isOne();
  }


  @Test
  void est_termine_si_le_dernier_choix_est_idoki2v2() {
    Joueur joueurEsku = unJoueurFaisantChoix(new Paso(),new Idoki());
    Joueur joueurApresEsku = unJoueurFaisantChoix(new Imido());
    Joueur joueurAvantZaku = unJoueurFaisantChoix(new Paso());
    Joueur joueurZaku = unJoueurFaisantChoix(new Paso());

    var equipeEsku = new Equipe(joueurEsku,joueurAvantZaku);
    var equipeZaku = new Equipe(joueurApresEsku,joueurZaku);

    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(),equipeEsku.getJoueurDeux(), equipeZaku.getJoueurUn(),equipeZaku.getJoueurDeux())));

    assertThat(recapitulatif.pointsEngages()).isEqualTo(2);
  }


  @Test
  void est_termine_si_le_dernier_choix_est_kanta2v2() {

    Joueur joueurEsku = unJoueurFaisantChoix(new Paso(), new Kanta());
    Joueur joueurApresEsku = unJoueurFaisantChoix(new Hordago());
    Joueur joueurAvantZaku = unJoueurFaisantChoix(new Paso());
    Joueur joueurZaku = unJoueurFaisantChoix(new Paso());

    var equipeEsku = new Equipe(joueurEsku,joueurAvantZaku);
    var equipeZaku = new Equipe(joueurApresEsku,joueurZaku);

    Dialogue.Recapitulatif recapitulatif = dialogue.derouler(new Participants(List.of(equipeEsku.getJoueurUn(),equipeEsku.getJoueurDeux(), equipeZaku.getJoueurUn(),equipeZaku.getJoueurDeux())));

    assertThat(recapitulatif.pointsEngages()).isEqualTo(40);
  }
  private Dialogue dialogue;

}
