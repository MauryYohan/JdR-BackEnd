package com.jdr.entity;

public interface Views {
	public static interface Common{}
	
	public interface Utilisateur extends Common{}
	public interface UtilisateurWithPartie extends Utilisateur{}
	public interface UtilisateurWithPersonnage extends Utilisateur{}
	public interface UtilisateurWithEverything extends UtilisateurWithPersonnage, UtilisateurWithPartie{}
	
	public interface Partie extends Common{}
	public interface PartieWithImage extends Image{}
	public interface PartieWithUtilisateur extends Partie{}
	public interface PartieWithPersonnage extends Partie{} 
	public interface PartieWithEverything extends PartieWithImage, PartieWithUtilisateur, PartieWithPersonnage {} 
	
	public interface Personnage extends Common{}
	public interface PersonnageWithPartie extends Personnage{}
	public interface PersonnageWithUtilisateur extends Personnage{}
	public interface PersonnageWithEverything extends PersonnageWithPartie, PersonnageWithUtilisateur{}
	
	public interface Image extends Common{}
	public interface ImageWithPartie extends Partie{}
}
