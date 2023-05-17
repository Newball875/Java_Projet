package net.ariane.levels;

import java.util.ArrayList;
import java.util.HashSet;

import net.ariane.mobs.Ennemi;

public class Level {
	public HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	protected Ennemi[][] vagues;
	private int nombre;		//Nombre de vagues
	private int actuel;	//Vague actuelle

	public Level(int nombre){
		setNombre(nombre);
		this.vagues=new Ennemi[nombre][];
		this.actuel=-1;
	}

	public void setNombre(int nombre){this.nombre=nombre;}
	public int getNombre(){return this.nombre;}

	public int getNombreEnnemis(){
		ArrayList<Ennemi> mechant=new ArrayList<>(this.ennemis);
		return mechant.size();
	}

	public int getVagueActuelle(){return this.actuel;}

	public boolean vagueSuivante(){
		this.actuel=this.actuel+1;
		if(this.actuel<this.nombre){
			envoyerVague(actuel);
			return true;	
		}
		return false;
	}

	public void envoyerVague(int vague){
		int i=0;
		ennemis.clear();
		while(i<vagues[vague].length){
			ennemis.add(vagues[vague][i]);
			i=i+1;
		}
	}

	public void update(){
		if(ennemis.isEmpty()){
			envoyerVague(this.actuel);
		}
	}
}
