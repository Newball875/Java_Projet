package net.ariane;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.ariane.bullet.Bullet;
import net.ariane.hud.BarreVie;
import net.ariane.levels.Level;
import net.ariane.levels.Level1;
import net.ariane.mobs.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import net.ariane.mobs.ennemis.*;

public class ArianeGame implements Screen {
	Joueur zac;
	HashSet<Ennemi>ennemis;
	HashSet<Bullet>balles_alliees=new HashSet<Bullet>();
	HashSet<Bullet>balles_ennemies=new HashSet<Bullet>();
	ShapeRenderer shape;
	Level niveaux[];

	private Zaq game;
	BarreVie barreVie = new BarreVie();
	private SpriteBatch batch;
	private Texture img;
	private Menu menu;
	private int niv;

	public ArianeGame(Zaq game, int niv){
		this.game = game;
		this.niv=niv;
		System.out.println("NIVEAU : "+this.niv);
	}
	

	public void create () {
		boolean truc=true;
		if(truc){
			System.out.println("OUI");
		}
		shape=new ShapeRenderer();
		zac=new Joueur();
	}

	public void createClassique (int X, int Y) {
		Ennemi ennemi=new Classique(X,Y);
		ennemis.add(ennemi);
	}
	public void createYwing (int X, int Y) {
		Ennemi ennemi=new Ywing(X,Y);
		ennemis.add(ennemi);
	}

	public void createMother (int X, int Y){
		Ennemi ennemi = new Mother(X, Y);
		ennemis.add(ennemi);
	}

	public void checkLevels()throws Exception{
		if(niveaux[niv].getNombreEnnemis()==0){
			System.out.println("SALUT");
		}
	}

	
	@Override
	public void render (float delta) {
		//Récupération du niveau et des ennemis
		try{
			checkLevels();
		}catch(Exception e){
			System.out.println("HELLO"+e);
		}
		Level level=niveaux[niv];
		HashSet<Ennemi>ennemis=level.ennemis;
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img,0,0);
		batch.end();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		int i=0;

		//MAJ de la barre de vie
		barreVie.draw(shape, zac.getLife(), zac.getMaxlife());


		//MAJ du héros
		if(zac.update(balles_alliees)){
			//Dire que c'est la fin
			System.out.println("TU AS PERDU, T'ES TROP NUL !");
			balles_alliees.clear();
			balles_ennemies.clear();
			ennemis.clear();
			System.exit(1);
		}

		//MAJ de ses balles
		ArrayList<Bullet> allies = new ArrayList<>(balles_alliees);
		while(i<allies.size()){
			Bullet balle=allies.get(i);
			if(balle.update() || balle.checkCollision(ennemis)){
				allies.remove(i);
			}else{
				i=i+1;
			}
		}
		balles_alliees.clear();
		balles_alliees=new HashSet<>(allies);
		i=0;

		//MAJ des méchants
		ArrayList<Ennemi> mechant=new ArrayList<>(ennemis);
		while(i<mechant.size()){
			Ennemi bad=mechant.get(i);
			bad.update(balles_ennemies,zac);
			if(bad.dead){
				mechant.remove(i);
			}else{
				i=i+1;
			}
		}
		ennemis.clear();
		ennemis=new HashSet<>(mechant);
		i=0;

		//MAJ des balles des ennemis
		ArrayList<Bullet> adverse= new ArrayList<>(balles_ennemies);
		while(i<adverse.size()){
			Bullet balle=adverse.get(i);
			if(balle.update() || balle.checkCollision(zac)){
				adverse.remove(i);
			}else{
				i=i+1;
			}
		}
		balles_ennemies.clear();
		balles_ennemies=new HashSet<>(adverse);
		i=0;
		//On draw tout dans le même ordre
		zac.draw(shape);
		while(i<allies.size()){
			Bullet balle=allies.get(i);
			balle.draw(shape);
			i=i+1;
		}
		i=0;
		while(i<adverse.size()){
			Bullet balle=adverse.get(i);
			balle.draw(shape);
			i=i+1;
		}
		for(Ennemi bad:ennemis){
			bad.draw(shape);
		}
		/*if(ennemis.isEmpty()){
			balles_ennemies.clear();
			for(Integer cle:niveaux.keySet()){
				if(cle!=1){
					if(niveaux.get(cle)==-1 && niveaux.get(cle-1)==0){
						niveaux.put(cle,1);
					}
				}
			}
		}*/

		shape.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	private void end(){
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("fond.png"));
		shape=new ShapeRenderer();
		zac=new Joueur();
		niveaux=new Level[1];
		niveaux[0]=new Level1();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
