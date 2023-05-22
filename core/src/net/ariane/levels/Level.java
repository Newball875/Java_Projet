package net.ariane.levels;

import java.util.ArrayList;
import java.util.HashSet;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Shape;

import net.ariane.mobs.Ennemi;

public class Level {
	public HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	protected Ennemi[][] vagues;
	private int nombre;		//Nombre de vagues
	protected int actuel;	//Vague actuelle
	private String nom;

	public Level(int nombre, String nom){
		setNombre(nombre);
		setNom(nom);
		this.vagues=new Ennemi[nombre][];
		this.actuel=-1;
	}

	public void setNom(String nom){this.nom=nom;}
	public String getNom(){return this.nom;}

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

	public void afficherNom(BitmapFont font){
		
	}
}
