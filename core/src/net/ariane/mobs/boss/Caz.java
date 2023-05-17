package net.ariane.mobs.boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.Destroyer;
import net.ariane.weapon.Kaz;

import java.util.HashMap;
import java.util.HashSet;

public class Caz extends Ennemi {
    public Caz(int X, int Y){
        super(X,Y);
        this.setLife(100);
        this.setWeapon(new Kaz());
        this.setScore(100);
        this.setColor(Color.CORAL);
    }

    public void update(HashSet<Bullet>balles_ennemies, Joueur cible){
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
