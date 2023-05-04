package net.ariane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ArianeGame extends ApplicationAdapter {
	ShapeRenderer shape;
	Texture img;
	
	@Override
	public void create () {
		shape=new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//shape.begin(ShapeRenderer.ShapeType.Filled);
	}
	
}
