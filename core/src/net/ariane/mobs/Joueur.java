package net.ariane.mobs;

import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.*;
import net.ariane.weapon.*;

public class Joueur extends Entite{

    private static final int MAXLIFE = 1000;
    private static final int SIZEX=20;
    private static final int SIZEY=20;

    private static String SPRITE_LINK = "sprites/Slime.png";

    private int highScore ;
    public int getHighScore(){return highScore;}
    public void setHighScore(int score){this.highScore = highScore;}

    public Joueur(){
        super(MAXLIFE, SIZEX, SIZEY, SPRITE_LINK);
        this.setWeapon(new Zak());
        this.setHighScore(0);
        this.sprite.setSize(SIZEX,SIZEY);
    }

    public boolean update(HashSet<Bullet>balles_alliees){
		this.setX(Gdx.input.getX()-(this.getSizeX()/2));
		this.setY((Gdx.graphics.getHeight()-Gdx.input.getY())-(this.getSizeY()/2));
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isButtonPressed(0)){
            shoot(balles_alliees);
        }
        return (this.getLife()<=0);
	}

    public void shoot(HashSet<Bullet>balles_alliees){
        int x = this.getX() + (getSizeX()/2);
        int y = this.getY() + getSizeY();
        this.weapon.use(balles_alliees, null,  x, y);
    }
}
