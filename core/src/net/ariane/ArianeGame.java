package net.ariane;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.ennemis.*;

import java.util.HashSet;

public class ArianeGame extends ApplicationAdapter {
	Joueur zac;
	HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	HashSet<Bullet>balles_ennemies=new HashSet<Bullet>();
	HashSet<Bullet>balles_alliees=new HashSet<Bullet>();
	ShapeRenderer shape;
	int i=0;
	
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
		if(i==0){
			System.out.println(Gdx.graphics.getWidth());
			i=i+1;
		}
		zac.update(balles_alliees);
		zac.draw(shape);
		shape.end();
	}
}
