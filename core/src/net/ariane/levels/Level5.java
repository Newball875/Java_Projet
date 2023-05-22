package net.ariane.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.hud.BarreBoss;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level5 extends Level{

	BarreBoss barreBoss ;
	Ennemi ennemi;
	public Level5(){
		super(1,"Niveau BOSS");
		int i=0;

		while(i<this.getNombre()){
			barreBoss = new BarreBoss();
			ennemi=new Boss(200,600);
			Ennemi ennemi2=new Ywing(200,500);
			Ennemi ennemi3=new Ywing(400,400);
			Ennemi ennemi4=new Ywing(600,500);


			this.vagues[i]=new Ennemi[4];
			this.vagues[i][0]=ennemi;
			this.vagues[i][1]=ennemi2;
			this.vagues[i][2]=ennemi3;
			this.vagues[i][3]=ennemi4;

			this.ennemis.add(ennemi);
			this.ennemis.add(ennemi2);
			this.ennemis.add(ennemi3);
			this.ennemis.add(ennemi4);

			i=i+1;
		}
	}
	public void update(){
		if(ennemis.isEmpty()){
			envoyerVague(this.actuel);
		}
	}

	public void draw(ShapeRenderer shape, BitmapFont font, SpriteBatch batch){
		afficherNom(font, batch);
		barreBoss.draw(shape, ennemi.getLife(), ennemi.getMaxlife());
	}
}
