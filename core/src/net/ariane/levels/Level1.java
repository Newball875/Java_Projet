package net.ariane.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level1 extends Level{

	public Level1(){
		super(1,"Niveau 1");
		//Première vague à 1 ennemi : 1 Slime Vert
		this.vagues[0]=new Ennemi[1];
		this.vagues[0][0]=new SlimeVert(100,700);
	}

	public void draw(ShapeRenderer shape, BitmapFont font, SpriteBatch batch){
		afficherNom(font, batch);
	}
}
