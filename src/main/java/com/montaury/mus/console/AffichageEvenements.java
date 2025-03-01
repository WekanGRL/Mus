package com.montaury.mus.console;

import com.montaury.mus.jeu.Manche;
import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.Partie;
import com.montaury.mus.jeu.evenements.Evenements;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.tour.phases.Phase;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Choix;
import java.util.stream.Collectors;

public class AffichageEvenements implements Evenements {
  private final Joueur joueurCourant;

  public AffichageEvenements(Joueur courant) {
    this.joueurCourant = courant;
  }

  @Override
  public void nouvellePartie() {
    afficher("Nouvelle partie");
  }

  @Override
  public void nouvelleManche() {
    afficher("-------------------------------------------------");
    afficher("Nouvelle Manche");
    afficher("-------------------------------------------------");
  }

  @Override
  public void mancheTerminee(Partie.Score score) {
    afficher("Manche terminée");
    score.resultatManches().forEach(manche -> afficher("Vainqueur : " + manche.vainqueur().getNom() + ", score du perdant : " + manche.pointsVaincu()));
  }

  @Override
  public void nouveauTour(Opposants opposants) {
    afficher(opposants.joueurEsku().getNom() + " est esku");
  }

  @Override
  public void tourTermine(Opposants opposants, Manche.Score score) {
    afficher("Tour terminé");
    opposants.dansLOrdre().forEach(this::afficherMain);
    score.scoreParEquipe().forEach((key, value) -> afficher("Score " + key.getNom() + ": " + value));
    sautLigne();
  }

  @Override
  public void choixFait(Joueur joueur, Choix choix) {
    afficher(joueur.getNom() + ": " + description(choix));
  }

  private static String description(Choix choix) {
    return choix.type().nom();
  }

  @Override
  public void nouvelleMain(Joueur joueur) {
    if (joueur == joueurCourant) {
      afficher("Votre main est: ");
      afficherMain(joueur);
      sautLigne();
    }
  }

  private void afficherMain(Joueur joueur) {
    afficher(joueur.getNom() + ": " + joueur.main().cartesDuPlusGrandAuPlusPetit().stream().map(carte -> carte.valeur() + " " + carte.type()).collect(Collectors.joining(" | ")));
  }

  @Override
  public void nouvellePhase(Phase phase) {
    afficher("-------------------------------------------------");
    afficher("Nouvelle phase: " + phase.nom());
    afficher("-------------------------------------------------");
  }

  @Override
  public void partieTerminee(Partie.Resultat resultat) {
    afficher("La partie est terminée !");
    afficher("Vainqueur: " + resultat.vainqueur());
  }

  private void afficher(String string) {
    System.out.println(string);
  }

  private void sautLigne() {
    System.out.println();
  }
}
