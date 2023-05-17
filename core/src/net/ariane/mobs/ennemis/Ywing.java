package net.ariane.mobs.ennemis;

import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.*;

import java.io.Console;
import java.util.HashSet;

public class Ywing extends Ennemi{

    public Ywing(int X, int Y){
        super(X,Y);
        this.setSpeedX(3);
        this.setLife(120);
        this.setSizeX(30);
        this.setWeapon(new Rafale());
        this.setScore(10);
        this.setColor(Color.ORANGE);
    }
    int DefY = this.getY();

    public int getDefY() {
        return DefY;
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
        //System.out.println(Math.sin(getX()/50));
        //System.out.println(30 * Math.sin(getX()/50));
        this.setY((int)(this.getDefY() + (30 * Math.sin(getX()/50))));

        shoot(balles_ennemies, cible);
        if(this.getLife()<=0){
            this.dead=true;
        }
    }
}
