package net.ariane.mobs.ennemis;

import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Entite;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.Destroyer;
import net.ariane.weapon.PiouPiou;

import java.util.HashSet;

public class Mother extends Ennemi{

    private static String SPRITE_LINK = "sprites/Slime_vert.png";

    public Mother(int X, int Y){
        super(X,Y, SPRITE_LINK);
        this.setSpeedX(1);
        this.setSizeX(50);
        this.setSizeY(30);
        this.setLife(250);
        this.setWeapon(new PiouPiou());
        this.setScore(20);
        //this.setColor(Color.BROWN);
    }

    public void update(HashSet<Bullet> balles_ennemies, Joueur cible){
        if(this.getX()<=0 || this.getX()>=800){
            this.setSpeedX(-this.getSpeedX());
        }
        this.setX(this.getX() + this.getSpeedX());

        shoot(balles_ennemies, cible);
        if(this.getLife()<=0){
            this.dead=true;
        }
    }

    @Override
    public void shoot(HashSet<Bullet>balles_ennemies, Entite cible) {

        int x = this.getX() + (getSizeX() / 2);
        int y = this.getY() + (getSizeY() / 2);
        this.weapon.use(balles_ennemies, cible, x, y);
    }
}
