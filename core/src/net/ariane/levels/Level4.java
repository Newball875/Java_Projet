package net.ariane.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level4 extends Level{

	public Level4(){
		super(4, "Niveau 4");     
		//Première vague à 1 ennemi : 1 Pillard
		this.vagues[0]=new Ennemi[1];
		this.vagues[0][0]=new SlimeVert(100,700);

		//Deuxième Vague : 2 Pillards
		this.vagues[1]=new Ennemi[2];
		this.vagues[1][0]=new Pillard(100,700);
		this.vagues[1][1]=new Pillard(150,650);

		//Troisième vague : 3 Slimes Verts
		this.vagues[2]=new Ennemi[3];
		this.vagues[2][0]=new SlimeVert(100,700);
		this.vagues[2][1]=new SlimeVert(700,700);
		this.vagues[2][2]=new SlimeVert(400,600);

		//Quatrième vague : 2 Withers et 2 Pillards
		this.vagues[3]=new Ennemi[4];
		this.vagues[3][0]=new Wither(400,700);
		this.vagues[3][1]=new Wither(400,100);
		Ennemi ennemi=new Pillard(100,600);
		ennemi.setSpeedX(-ennemi.getSpeedX());
		this.vagues[3][2]=ennemi;
		this.vagues[3][3]=new Pillard(700,600);
	}

	public void draw(ShapeRenderer shape, BitmapFont font, SpriteBatch batch){
		afficherNom(font, batch);
	}

}
