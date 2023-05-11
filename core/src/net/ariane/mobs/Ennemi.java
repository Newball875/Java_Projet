package net.ariane.mobs;

import net.ariane.bullet.Bullet;

import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public abstract class Ennemi extends Entite{

    public static final int MAXLIFE = 1000;
    public static final int SPEED = 1;
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

    public void shoot(HashSet<Bullet>balles_ennemies){
        if(this.wait<=0){
            balles_ennemies.add(this.weapon.use(getX()+(getSizeX()/2), getY()+(getSizeY()), 0, this.weapon.getSpeedBullet()));
            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }
    }

    public abstract void update();
    
}
