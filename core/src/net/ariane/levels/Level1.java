package net.ariane.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level1 extends Level{

	public Level1(){
		super(2,"Niveau 1");
		//Première vague à 2 ennemis : 2 Slimes Verts
		this.vagues[0]=new Ennemi[2];
		this.vagues[0][0]=new SlimeVert(100,700);
		Ennemi ennemi=new SlimeVert(700,700);
		ennemi.setSpeedX(-ennemi.getSpeedX());
		this.vagues[0][1]=ennemi;
	}

	public void draw(ShapeRenderer shape, BitmapFont font, SpriteBatch batch){
		afficherNom(font, batch);
	}
}
