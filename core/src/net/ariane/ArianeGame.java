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
import net.ariane.mobs.ennemis.*;

public class ArianeGame extends ApplicationAdapter {
	Joueur zac;
	HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	HashSet<Bullet>balles_alliees=new HashSet<Bullet>();
	HashSet<Bullet>balles_ennemies=new HashSet<Bullet>();
	ShapeRenderer shape;
	
	@Override
	public void create () {
		shape=new ShapeRenderer();
		zac=new Joueur();
		int i=0;
		while(i<1){
			createClassique(100+i*100,700);
			i=i+1;
		}
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

		ArrayList<Bullet> allies = new ArrayList<>(balles_alliees);
		while(i<allies.size()){
			Bullet balle=allies.get(i);
			if(balle.update()){
				System.out.println("COUCU"+i);
				allies.remove(i);
			}else{
				i=i+1;
			}
		}
		balles_alliees.clear();
		balles_alliees=new HashSet<>(allies);
		i=0;

		ArrayList<Bullet>
		for(Ennemi mechant:ennemis){
			int j=0;
			mechant.update(balles_ennemies,zac);
			mechant.draw(shape);
			for(Bullet balle:balles_ennemies){
				if(balle.update()){
					balle=null;
				}else{
					balle.draw(shape);
				}
			}

			//toarray
		}

		zac.draw(shape);
		while(i<allies.size()){
			Bullet balle=allies.get(i);
			balle.draw(shape);
			i=i+1;
		}
		System.out.println("BALLES : "+balles_alliees.size()+"\nALLIES : "+allies.size());
		shape.end();
	}
}
