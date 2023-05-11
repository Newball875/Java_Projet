package net.ariane.mobs;

import net.ariane.bullet.Bullet;

import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;

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
            int x=0,y=0;
            int D = (int)Math.sqrt(((this.getX() - cible.getX()) * (this.getX() - cible.getX())) + ((this.getY() - this.getY()) * (this.getY() - this.getY())));
            this.balles.add(this.weapon.use(getX()+(getSizeX()/2), getY(), ((this.getX() - cible.getX()) * (this.weapon.getSpeedBullet() / D)), ((this.getY() - cible.getY()) * (this.weapon.getSpeedBullet() / D)),Color.RED));
            this.wait=this.getCooldown();
            //x=(Math.abs(this.getX() - cible.getX()))
            //y=(Math.abs(this.getY() - cible.getY()));
            System.out.println("x "+x+" ; y "+y);
        }
        else{
            this.wait--;
        }
    }

    public abstract void update(Joueur zac);
    
}
