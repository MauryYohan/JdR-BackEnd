package com.jdr.entity;

public interface Views {
	public static interface Common{}

	
	public interface Joueur extends Common{}
	public interface JoueurWithPartie extends Joueur{}
	public interface JoueurWithPersonnage extends Joueur{}
	public interface JoueurWithEverything extends JoueurWithPersonnage, JoueurWithPartie{}

	public interface MJ extends Common{}
	public interface MJWithPartie extends MJ{}
	
	public interface Utilisateur extends Common{}
	
	public interface Partie extends Common{}
	public interface PartieWithImage extends Image{}
	public interface PartieWithMJ extends Partie{}
	public interface PartieWithJoueur extends Partie{}
	public interface PartieWithPersonnage extends Partie{} 
	public interface PartieWithEverything extends PartieWithPersonnage,PartieWithImage, PartieWithMJ, PartieWithJoueur {} 
	
	public interface Personnage extends Common{}
	public interface PersonnageWithPartie extends Personnage{}
	public interface PersonnageWithJoueur extends Personnage{}
	public interface PersonnageWithEverything extends PersonnageWithJoueur, PersonnageWithPartie{}
	
	public interface Image extends Common{}
	public interface ImageWithPartie extends Partie{}
}
