package net.ariane;

import com.badlogic.gdx.Input;
import net.ariane.bullet.Bullet;
import net.ariane.hud.BarreBoss;
import net.ariane.hud.BarreVie;
import net.ariane.hud.Score;
import net.ariane.levels.*;
import net.ariane.mobs.*;
import net.ariane.mobs.ennemis.*;

import java.util.ArrayList;
import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ArianeGame implements Screen {
	Joueur zac;
	HashSet<Ennemi>ennemis;
	HashSet<Bullet>balles_alliees=new HashSet<Bullet>();
	HashSet<Bullet>balles_ennemies=new HashSet<Bullet>();
	ShapeRenderer shape;
	BitmapFont font;
	Level niveaux[];

	private GameAriane game;
	BarreVie barreVie = new BarreVie();
	BarreBoss barreBoss = new BarreBoss();
	private SpriteBatch batch;
	private Texture img;
	private Menu menu;
	private Score score;
	public int niv;
	private int wait;

	public ArianeGame(GameAriane game, int niv){
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

	public boolean attente(int temps){
		temps=60*temps;
		if(wait<temps){
			wait++;
			return false;
		}
		wait=0;
		return true;
	}


	public void pause() {
		boolean fin = false;
		while (!fin) {
			System.out.println("ici");
			if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)) {
				System.out.println("la");
				fin = true;
			}
		}
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
		if(niv>=niveaux.length){
			niv--;
			return;
		}
		Level level=niveaux[niv];
		if(level.getNombreEnnemis()==0){
			balles_ennemies.clear();
			if(level.vagueSuivante()){
				return;
			}
			else{
				//Attente (en seconde)
				if(attente(2)){
					niv++;
					wait=0;
					checkLevels();
				}
			}
		}
	}

	
	@Override
	public void render (float delta) {
		//Récupération du niveau et des ennemis
		try{
			checkLevels();
		}catch(Exception e){
			System.out.println("ERREUR : "+e);
		}
		Level level=niveaux[niv];
		ennemis=level.ennemis;

		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img,0,0);
		batch.end();

		
		shape.begin(ShapeRenderer.ShapeType.Filled);
		int i=0;

		//MAJ du héros
		if(zac.update(balles_alliees)){
			//Dire que c'est la fin
			System.out.println("TU AS PERDU, T'ES TROP NUL !");
			balles_alliees.clear();
			balles_ennemies.clear();
			System.out.println("SALUUUUT");
			ennemis.clear();
			game.changeScreen(new Menu(game));
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
				score.add(bad.getScore());
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


		batch.begin();
		//On draw tout dans le même ordre
		zac.draw(shape, batch);
		while(i<allies.size()){
			Bullet balle=allies.get(i);
			balle.draw(shape, batch);
			i=i+1;
		}
		i=0;
		while(i<adverse.size()){
			Bullet balle=adverse.get(i);
			balle.draw(shape, batch);
			i=i+1;
		}
		for(Ennemi bad:ennemis){
			bad.draw(shape, batch);
		}

		//Draw de la barre de vie
		barreVie.draw(shape, zac.getLife(), zac.getMaxlife());
		//Draw de la barre de boss
		level.draw(shape, font, batch);
		score.draw(font, batch);
		level.ennemis=ennemis;

		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			pause();
		}
;
		batch.end();
		shape.end();

	}

	@Override
	public void resize(int width, int height) {

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
		wait=0;
		batch = new SpriteBatch();
		font=new BitmapFont();
		img = new Texture(Gdx.files.internal("fond.png"));
		shape=new ShapeRenderer();
		zac=new Joueur();
		niveaux=new Level[5];
		niveaux[0]=new Level1();
		niveaux[1]=new Level2();
		niveaux[2]=new Level3();
		niveaux[3]=new Level4();
		niveaux[4]=new Level5();
		score = new Score();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
