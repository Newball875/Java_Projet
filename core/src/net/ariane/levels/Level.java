package net.ariane.levels;

import java.util.HashSet;

import net.ariane.mobs.Ennemi;

public class Level {
	private HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	protected HashSet<Ennemi>[]vagues;
	private int nombre;		//Nombre de vagues
	private int actuel=0;	//Vague actuelle

	public Level(int nombre){
		setNombre(nombre);
	}

	public void setNombre(int nombre){this.nombre=nombre;}
	public int getNombre(){return this.nombre;}
}
