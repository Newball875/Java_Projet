package net.ariane.mobs;

import net.ariane.bullet.Bullet;

import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public abstract class Ennemi extends Entite{

    public static final int MAXLIFE = 1000;
    public static final int SPEEDX = 1;
    public static final int SPEEDY = 1;
    public static final int SIZEX = 20;
    public static final int SIZEY = 20;

    private int score ;
    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}

    public Ennemi(int X, int Y){
        super();
        this.setX(X);
        this.setY(Y);
    }

    public void shoot(HashSet<Bullet>balles_ennemies, Entite cible){
        if(this.wait<=0){
            int D = Math.sqrt((Math.abs(this.getX() - cible.getX()) * Math.abs(this.getX() - cible.getX())) + (Math.abs(this.getY() - this.getY()) * Math.abs(this.getY() - this.getY()));
            balles_ennemies.add(this.weapon.use(getX()+(getSizeX()/2), getY()+(getSizeY()), (Math.abs(this.getX() - cible.getX()) * (this.weapon.getSpeedBullet() / D)), (Math.abs(this.getY() - cible.getY()) * (this.weapon.getSpeedBullet() / D))));
            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }
    }

    public abstract void update();
    
}
