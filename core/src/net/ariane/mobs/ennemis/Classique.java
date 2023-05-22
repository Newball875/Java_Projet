package net.ariane.mobs.ennemis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.Destroyer;

import java.util.HashMap;
import java.util.HashSet;

public class Classique extends Ennemi {

    private static String SPRITE_LINK = "sprites/Slime_vert.png";

    public Classique(int X, int Y){
        super(X,Y, SPRITE_LINK);
        this.setSpeedX(5);
        this.setLife(80);
        this.setWeapon(new Destroyer());
        this.setScore(5);
        //this.setColor(Color.CORAL);

        this.sprite.setSize(20,20);
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
