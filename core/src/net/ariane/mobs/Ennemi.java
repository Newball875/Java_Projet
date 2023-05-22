package net.ariane.mobs;

import net.ariane.bullet.Bullet;

import java.awt.*;
import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;

public abstract class Ennemi extends Entite{

    private static final int MAXLIFE = 1000;
    private static final int SPEEDX = 10;
    private static final int SPEEDY = 10;
    private static final int SIZEX = 20;
    private static final int SIZEY = 20;

    private int score ;
    protected HashSet<Bullet>balles=new HashSet<Bullet>();
    public boolean dead=false;

    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}

    public HashSet<Bullet> getBalles(){return this.balles;}


    public Ennemi(int X, int Y, String lien_img){
        super(MAXLIFE, SIZEX, SIZEY, lien_img);
        this.setX(X);
        this.setY(Y);
    }

    public void shoot(HashSet<Bullet>balles_ennemies, Entite cible){

        int x = this.getX() + (getSizeX()/2);
        int y = this.getY();
        this.weapon.use(balles_ennemies, this.texture_bullet, cible,  x, y);
    }

    public abstract void update(HashSet<Bullet>balles_ennemies, Joueur cible);
    
}
