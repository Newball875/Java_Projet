package net.ariane.mobs.ennemis;

import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.*;

import java.util.HashSet;

public class Navar extends Ennemi{

    public Navar(int X, int Y){
        super(X,Y);
        this.setLife(20);
        this.setWeapon(new PiouPiou());
        this.setScore(10);
        this.setColor(Color.ORANGE);
    }

    public void update(){
        if(this.getX()<=0 || this.getX()>=800){
            this.setSpeedX(-this.getSpeedX());
        }
        if(this.getY()<=650 || this.getX()>=800){
            this.setSpeedY(-this.getSpeedY());
        }
        this.setX(this.getX() + this.getSpeedX());
        this.setY(this.getY() + this.getSpeedY());
    }

    public void update(HashSet<Bullet> balles_ennemies, Joueur cible) {
        if(this.getX()<=0 || this.getX()>=800){
            this.setSpeedX(-this.getSpeedX());
        }
        this.setX(this.getX() + this.getSpeedX());

        shoot(balles_ennemies, cible);
        if(this.getLife()<=0){
            this.dead=true;
        }
    }
}
