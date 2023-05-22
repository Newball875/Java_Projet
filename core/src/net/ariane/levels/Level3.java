package net.ariane.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level3 extends Level{

	public Level3(){
		super(2, "Niveau 3");     
		//Première vague à 3 ennemis : 2 Slimes Verts et 1 Pillard
		this.vagues[0]=new Ennemi[3];
		this.vagues[0][0]=new SlimeVert(100,700);
		this.vagues[0][1]=new SlimeVert(700,750);
		this.vagues[0][2]=new Pillard(400,400);

		//Seconde Vague : 1 Mother et 1 Ywing
		this.vagues[1]=new Ennemi[2];
		this.vagues[1][0]=new Wither(100,700);
		this.vagues[1][1]=new Pillard(150,650);
	}

	public void draw(ShapeRenderer shape, BitmapFont font, SpriteBatch batch){
		afficherNom(font, batch);
	}

}
