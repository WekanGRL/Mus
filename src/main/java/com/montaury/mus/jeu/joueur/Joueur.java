package com.montaury.mus.jeu.joueur;

import com.montaury.mus.console.InterfaceJoueurHumain;
import com.montaury.mus.jeu.carte.Carte;
import java.util.List;

public class Joueur {
  public static Joueur humain(String nom) {
    return new Joueur(nom, new InterfaceJoueurHumain());
  }

  public static Joueur ordinateur() {
    return new Joueur("Ordinateur", new InterfaceJoueurOrdinateur());
  }

  private  String nom;
  public final InterfaceJoueur interfaceJoueur;
  private final Main main = Main.vide();
  private Equipe equipe;

  public Joueur(String nom, InterfaceJoueur interfaceJoueur) {
    this.nom = nom;
    this.interfaceJoueur = interfaceJoueur;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom=nom;
  }

  public Main main() {
    return main;
  }

  public Equipe getEquipe(){
    return this.equipe;
  }

  public void setEquipe(Equipe equipe){
    this.equipe=equipe;
  }

  public void donnerCartes(List<Carte> cartes) {
    main.ajouter(cartes);
    interfaceJoueur.nouvelleMain(main);
  }
}
