package net.ariane.mobs;

import net.ariane.bullet.Bullet;

import java.awt.*;
import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public abstract class Ennemi extends Entite{

    private static final int MAXLIFE = 1000;
    private static final int SPEEDX = 1;
    private static final int SPEEDY = 1;
    private static final int SIZEX = 20;
    private static final int SIZEY = 20;

    private int score ;
    protected HashSet<Bullet>balles=new HashSet<Bullet>();

    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}

    public HashSet<Bullet> getBalles(){return this.balles;}


    public Ennemi(int X, int Y){
        super();
        this.setX(X);
        this.setY(Y);
    }

    public void shoot(Entite cible){
        if(this.wait<=0){

            int X = cible.getX() - this.getX();
            int Y = cible.getY() - this.getY();
            int D = (int)Math.sqrt((X*X + Y*Y));

            int speedX = (X * this.weapon.getSpeedBullet()) / D;
            int speedY = Y * this.weapon.getSpeedBullet() / D;

            System.out.println(speedX + " " + speedY);
            this.balles.add(this.weapon.use(getX()+(getSizeX()/2), getY(), speedX, speedY, Color RED));
            this.wait=this.getCooldown();

        }
        else{
            this.wait--;
        }
    }

    public abstract void update(Joueur zac);
    
}
