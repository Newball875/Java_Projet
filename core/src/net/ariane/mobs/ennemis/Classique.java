package net.ariane.mobs.ennemis;

import com.badlogic.gdx.Gdx;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.Destroyer;

import java.util.HashMap;
import java.util.HashSet;

public class Classique extends Ennemi {
    public Classique(){
        super();
        this.setLife(20);
        this.setWeapon(new Destroyer());
        this.setScore(5);
    }

    //HashMap<Ennemi,Bullet>balles_ennemies=new HashMap<Ennemi,Bullet>();

    public void update(HashMap<Ennemi,Bullet>balles_ennemies, Joueur zac){
        if(this.getX()<=0 || this.getX()>=800){
            this.setSpeedX(-this.getSpeedX());
        }
        this.setX(this.getX() + this.getSpeedX());
    }

}
