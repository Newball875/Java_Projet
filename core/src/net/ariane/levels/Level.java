package net.ariane.levels;

import java.util.ArrayList;
import java.util.HashSet;

import net.ariane.mobs.Ennemi;

public class Level {
	public HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	protected Ennemi[][] vagues;
	private int nombre;		//Nombre de vagues
	private int actuel=0;	//Vague actuelle

	public Level(int nombre){
		setNombre(nombre);
		this.vagues=new Ennemi[nombre][];
	}

	public void setNombre(int nombre){this.nombre=nombre;}
	public int getNombre(){return this.nombre;}

	public int getNombreEnnemis(){
		ArrayList<Ennemi> mechant=new ArrayList<>(this.ennemis);
		return mechant.size();
	}
}
