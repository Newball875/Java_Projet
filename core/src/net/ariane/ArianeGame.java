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
import com.badlogic.gdx.input.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Cursor.SystemCursor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ArianeGame implements Screen {
	public static final float BACKGROUND_SPEED=-100;
	private Texture img1,img2;
	private float yMax, y1, y2;

	Joueur zac;
	HashSet<Ennemi>ennemis;
	HashSet<Bullet>balles_alliees=new HashSet<Bullet>();
	HashSet<Bullet>balles_ennemies=new HashSet<Bullet>();
	ShapeRenderer shape;
	BitmapFont font;
	Level niveau;
	int[] curseur=new int[2];

	private GameScreen game;
	BarreVie barreVie = new BarreVie();
	BarreBoss barreBoss = new BarreBoss();
	private SpriteBatch batch;
	private Texture img;
	private Score score;
	public int niv;
	private int wait;


	private boolean pause = false;

	public ArianeGame(GameScreen game, int niv){
		this.game = game;
		this.niv=niv;
		System.out.println("NIVEAU : "+this.niv);
	}

	public boolean attente(int temps){
		temps=60*temps;
		if(wait<temps){
			wait++;
			return true;
		}
		return false;
	}

	public void checkLevels(){
		//On vérifie si il reste des ennemis
		if(!ennemis.isEmpty()){
			//Si il en reste, on ne fait rien
			return;
		}
		//Sinon, on regarde pour passer à la vague suivante
		Level level=niveau;
		if(level.vagueSuivante()){
			//Si on peut passer à la vague suivante, on l'a fait donc on ne fait plus rien
			return;
		}
		//Si on n'a pas pu, on regarde si on peut passer au niveau suivant
		//Donc on doit attendre, puis générer le niveau et l'envoyer
		if(attente(2)){
			//On attend
			return;
		}
		niv=niv+1;
		level=genererNiveau(niv);
		//Si on a pu le générer, on le met dans le niveau actuel
		if(level!=null){
			niveau=level;
			wait=0;
			return;
		}
		//Sinon, on dit qu'on a gagné
		System.out.println("GAGNÉ !");
		backToMenu();
	}

	//Fonction qui génère le niveau demandé (il n'y en a que 5, donc entre 0 et 4), mais si on demande 5, on estime que ce n'est pas une erreur, juste une victoire.
	//C'est pour éviter d'avoir le message d'erreur lorsque l'on gagne
	public Level genererNiveau(int lev){
		switch(lev){
			case 0: return new Level1();
			case 1: return new Level2();
			case 2: return new Level3();
			case 3: return new Level4();
			case 4: return new Level5();
			case 5: return null;
			default: System.out.println("[ERROR]:Numéro de niveau incorrect !");
					return null;
		}
	}

	//Fonction qui permet de faire les diverses mises à jour
	public void update(){

		ennemis=niveau.ennemis;
		checkLevels();

		ArrayList<Bullet> allies;
		ArrayList<Ennemi> mechant;
		ArrayList<Bullet> adverse;

		if(!this.pause) {
			//Mise à jour du fond
			y1=y1+BACKGROUND_SPEED*Gdx.graphics.getDeltaTime();
			y2=y1+yMax;
			if(y1>=0){
				y1=-yMax;
				y2=0;
			}
			int i = 0;
			//MAJ du héros
			if (zac.update(balles_alliees)) {
				//Dire que c'est la fin
				System.out.println("TU AS PERDU !");
				balles_alliees.clear();
				balles_ennemies.clear();
				ennemis.clear();
				backToMenu();
			}

			//MAJ de ses balles

			allies = new ArrayList<>(balles_alliees);
			while (i < allies.size()) {
				Bullet balle = allies.get(i);
				if (balle.update() || balle.checkCollision(ennemis)) {
					allies.remove(i);
				} else {
					i = i + 1;
				}
			}
			balles_alliees.clear();
			balles_alliees = new HashSet<>(allies);


			i = 0;

			//MAJ des méchants
			mechant = new ArrayList<>(ennemis);
			while (i < mechant.size()) {
				Ennemi bad = mechant.get(i);
				bad.update(balles_ennemies, zac);
				if (bad.dead) {
					score.add(bad.getScore());
					mechant.remove(i);
				} else {
					i = i + 1;
				}
			}
			ennemis.clear();
			ennemis = new HashSet<>(mechant);

			i = 0;

			//MAJ des balles des ennemis
			adverse = new ArrayList<>(balles_ennemies);
			while (i < adverse.size()) {
				Bullet balle = adverse.get(i);
				if (balle.update() || balle.checkCollision(zac)) {
					adverse.remove(i);
				} else {
					i = i + 1;
				}
			}
			balles_ennemies.clear();
			balles_ennemies = new HashSet<>(adverse);

		}

		//Partie de vérification de la pause
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
			//Si pause est false (jeu en cours), on va mettre pause en true et garder les coordonnées du curseur
			if(!this.pause){
				this.pause=true;
				curseur[0]=Gdx.input.getX();
				curseur[1]=Gdx.input.getY();
				Gdx.graphics.setSystemCursor(SystemCursor.Arrow);
			}else{
				//Si pause est true (jeu en pause), on va mettre pause en false et remettre les anciennes coordonnées du curseur
				this.pause=false;
				Gdx.input.setCursorPosition(curseur[0], curseur[1]);
				Gdx.graphics.setSystemCursor(SystemCursor.None);
			}
		}
	}
	
	@Override
	public void render (float delta) {
		//Mise à jour des données
		update();

		//Affichage du fond qui bouge
		batch.begin();
		batch.draw(img1, 0, y1);
		batch.draw(img2,0,y2);
		batch.end();

		shape.begin(ShapeRenderer.ShapeType.Filled);
		int i = 0;
		ArrayList<Bullet> allies=new ArrayList<>(balles_alliees);
		ArrayList<Bullet> adverse = new ArrayList<>(balles_ennemies);

		batch.begin();
		//On draw tout dans le même ordre
		zac.draw(shape, batch);
		while (i < allies.size()) {
			Bullet balle = allies.get(i);
			balle.draw(shape, batch);
			i = i + 1;
		}
		i = 0;
		while (i < adverse.size()) {
			Bullet balle = adverse.get(i);
			balle.draw(shape, batch);
			i = i + 1;
		}
		for (Ennemi bad : ennemis) {
			bad.draw(shape, batch);
		}

		//Draw de la barre de vie
		barreVie.draw(shape, zac.getLife(), zac.getMaxlife());
		//Draw de la barre de boss
		niveau.draw(shape, font, batch);
		score.draw(font, batch);
		niveau.ennemis = ennemis;


		batch.end();
		shape.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}
	public void backToMenu(){
		Gdx.graphics.setSystemCursor(SystemCursor.Arrow);
        game.backToMenu();
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
		img1=new Texture(Gdx.files.internal("background_minecraft.png"));
		img2=new Texture(Gdx.files.internal("background_minecraft.png"));
		yMax=4608;	//Taille en y de l'image (à changer si on change d'image)
		y1=-yMax;
		y2=0;
		shape=new ShapeRenderer();
		zac=new Joueur();
		niveau=genererNiveau(niv);
		if(niveau==null){
			niv=0;
			niveau=genererNiveau(niv);
		}
		score = new Score();
		Gdx.graphics.setSystemCursor(SystemCursor.None);
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
