package net.ariane.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level3 extends Level{

	public Level3(){
		super(3, "Niveau 3");     
		//Première vague à 1 ennemi : 1 SlimeVert
		this.vagues[0]=new Ennemi[1];
		this.vagues[0][0]=new SlimeVert(100,700);

		//Deuxième Vague : 1 Pillard et 1 Slime Vert
		this.vagues[1]=new Ennemi[2];
		this.vagues[1][0]=new Pillard(150,650);
		this.vagues[1][1]=new SlimeVert(750,650);

		//Troisième vague : 1 Wither et 2 Pillards
		this.vagues[2]=new Ennemi[3];
		this.vagues[2][0]=new Wither(400,700);
		this.vagues[2][1]=new Pillard(100,600);
		this.vagues[2][2]=new Pillard(700,600);
	}

	public void draw(ShapeRenderer shape, BitmapFont font, SpriteBatch batch){
		afficherNom(font, batch);
	}

}
