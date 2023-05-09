package net.ariane;

import net.ariane.mobs.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ArianeGame extends ApplicationAdapter {
	Joueur zac;
	ShapeRenderer shape;
	Texture img;
	int i=0;
	
	@Override
	public void create () {
		shape=new ShapeRenderer();
		zac=new Joueur();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.setWindowedMode(800, 800);
		Gdx.graphics.setTitle("Zaq");
		if(i==0){
			System.out.println(Gdx.graphics.getWidth());
			i=i+1;
		}
		shape.begin(ShapeRenderer.ShapeType.Filled);
		zac.update();
		zac.draw(shape);
	}
	
}
