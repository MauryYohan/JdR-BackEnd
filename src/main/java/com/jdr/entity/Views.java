package com.jdr.entity;

public interface Views {
	public static interface Common{}

	
	public interface Joueur extends Common{}
	public interface JoueurWithPartie extends Joueur{}
	
	public interface MJ extends Common{}
	public interface MJWithPartie extends MJ{}
	
	public interface Partie extends Common{}
	public interface PartieWithMJ extends Partie{}
	public interface PartieWithJoueur extends Partie{}
	public interface PartieWithPersonnage extends Partie{} 
	
	public interface Personnage extends Common{}
	public interface PersonnageWithPartie extends Personnage{}
	
	public interface Image extends Common{}
	public interface ImageWithPartie extends Partie{}
}
