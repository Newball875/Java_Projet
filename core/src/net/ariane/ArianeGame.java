package net.ariane;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import net.ariane.mobs.ennemis.*;

public class ArianeGame extends Zaq {
	Joueur zac;
	HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	HashSet<Bullet>balles_alliees=new HashSet<Bullet>();
	HashSet<Bullet>balles_ennemies=new HashSet<Bullet>();
	ShapeRenderer shape;
	boolean niveau[];
	
	@Override
	public void create () {
		shape=new ShapeRenderer();
		zac=new Joueur();
		createClassique(100, 700);
	}

	public void createClassique (int X, int Y) {
		Ennemi ennemi=new Classique(X,Y);
		ennemis.add(ennemi);
	}
	public void createNavar (int X, int Y) {
		Ennemi ennemi=new Navar(X,Y);
		ennemis.add(ennemi);
	}

	public void niveau1() throws InterruptedException {
		for(int i=0;i<10;i++) {
			createClassique(i*10+5,100);
			java.util.concurrent.TimeUnit.SECONDS.sleep(2);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		int i=0;

		//MAJ du héros
		if(zac.update(balles_alliees)){
			//Dire que c'est la fin
			System.out.println("TU AS PERDU, T'ES TROP NUL !");
			balles_alliees.clear();
			balles_ennemies.clear();
			ennemis.clear();
			System.exit(1);
		}

		//MAJ de ses balles
		ArrayList<Bullet> allies = new ArrayList<>(balles_alliees);
		while(i<allies.size()){
			Bullet balle=allies.get(i);
			if(balle.update() || balle.checkCollision(ennemis)){
				allies.remove(i);
			}else{
				i=i+1;
			}
		}
		balles_alliees.clear();
		balles_alliees=new HashSet<>(allies);
		i=0;

		//MAJ des méchants
		ArrayList<Ennemi> mechant=new ArrayList<>(ennemis);
		while(i<mechant.size()){
			Ennemi bad=mechant.get(i);
			bad.update(balles_ennemies,zac);
			if(bad.dead){
				mechant.remove(i);
			}else{
				i=i+1;
			}
		}
		ennemis.clear();
		ennemis=new HashSet<>(mechant);
		i=0;

		//MAJ des balles des ennemis
		ArrayList<Bullet> adverse= new ArrayList<>(balles_ennemies);
		while(i<adverse.size()){
			Bullet balle=adverse.get(i);
			if(balle.update() || balle.checkCollision(zac)){
				adverse.remove(i);
			}else{
				i=i+1;
			}
		}
		balles_ennemies.clear();
		balles_ennemies=new HashSet<>(adverse);
		i=0;
		//On draw tout dans le même ordre
		zac.draw(shape);
		while(i<allies.size()){
			Bullet balle=allies.get(i);
			balle.draw(shape);
			i=i+1;
		}
		i=0;
		while(i<adverse.size()){
			Bullet balle=adverse.get(i);
			balle.draw(shape);
			i=i+1;
		}
		for(Ennemi bad:ennemis){
			bad.draw(shape);
		}
		if(ennemis.isEmpty()){
			System.out.println("BIEN JOUE ! TU AS GAGNE !");
			ennemis.clear();
			balles_ennemies.clear();
		}

		shape.end();
	}

	private void end(){
		
	}
}
