package net.ariane;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.*;

import java.util.HashMap;
import java.util.HashSet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.ennemis.*;

public class ArianeGame extends ApplicationAdapter {
	Joueur zac;
	HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	HashMap<Ennemi,Bullet>balles_ennemies=new HashMap<Ennemi,Bullet>();
	HashSet<Bullet>balles_alliees=new HashSet<Bullet>();
	ShapeRenderer shape;
	
	@Override
	public void create () {
		shape=new ShapeRenderer();
		zac=new Joueur();
		createClassique(100,100);
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
		shape=new ShapeRenderer();
		zac=new Joueur();
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
		zac.update(balles_alliees);
		zac.draw(shape);
		for(Ennemi mechant:ennemis){
			mechant.update(balle_ennemies);
			mechant.draw(shape);
		}






		for(Bullet balle:balles_alliees){
			balle.update();
			balle.draw(shape);
			
			i=i+1;
		}
		for(Bullet balle:balles_ennemies){
			balle.update();
			balle.draw(shape);
		}
		shape.end();
		System.out.println(i);
	}
}
