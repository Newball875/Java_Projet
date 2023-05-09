package net.ariane;

import net.ariane.mobs.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.HashSet;

public class ArianeGame extends ApplicationAdapter {
	Joueur zac;
	HashSet<Ennemi>ennemis=new HashSet<Ennemi>();
	ShapeRenderer shape;
	int i=0;
	
	@Override
	public void create () {
		shape=new ShapeRenderer();
		zac=new Joueur();
		createEnnemi();
	}

	public void createEnnemi () {
		Ennemi ennemi=new Ennemi(100,100);
		ennemis.add(ennemi);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		if(i==0){
			System.out.println(Gdx.graphics.getWidth());
			i=i+1;
		}
		zac.update();
		zac.draw(shape);
		shape.end();
	}
}
