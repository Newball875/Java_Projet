package net.ariane.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level2 extends Level{

	public Level2(){
		super(2,"Niveau 2");     
		//Première vague à 2 ennemis : 1 Slime vert et 1 Pillard
		this.vagues[0]=new Ennemi[2];
		this.vagues[0][0]=new SlimeVert(100,600);
		this.vagues[0][1]=new Pillard(700,700);

		//Deuxième Vague : 3 Pillards
		this.vagues[1]=new Ennemi[3];
		this.vagues[1][0]=new Pillard(100,700);
		this.vagues[1][1]=new Pillard(150,650);
		this.vagues[1][2]=new Pillard(700,700);
	}

	public void draw(ShapeRenderer shape, BitmapFont font, SpriteBatch batch){
		afficherNom(font, batch);
	}

}
