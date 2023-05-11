package net.ariane.mobs.ennemis;

import com.badlogic.gdx.Gdx;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.weapon.Destroyer;

import java.util.HashSet;

public class Classique extends Ennemi {
    public Classique(int X, int Y){
        super(X,Y);
        this.setLife(20);
        this.setWeapon(new Destroyer());
        this.setScore(5);
    }

    public void update(){
        if(this.getX()<=0 || this.getX()>=800){
            this.setSpeed(-this.getSpeed());
        }
        this.setX(this.getX() + this.getSpeed());
    }

}
