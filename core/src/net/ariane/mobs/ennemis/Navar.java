package net.ariane.mobs.ennemis;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.*;

import java.util.HashSet;

public class Navar extends Ennemi{

    public Navar(int X, int Y){
        super(X,Y);
        this.setLife(20);
        this.setWeapon(new Rafale());
        this.setScore(10);
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

    }
}
