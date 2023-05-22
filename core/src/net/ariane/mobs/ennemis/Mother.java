package net.ariane.mobs.ennemis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Entite;
import net.ariane.mobs.Joueur;
import net.ariane.weapon.Destroyer;
import net.ariane.weapon.PiouPiou;

import java.util.HashSet;

public class Mother extends Ennemi{

    private static String SPRITE_LINK = "sprites/Enemie_2.png";
    private static String SPRITE_BULETTE_LINK = "sprites/Slime_shoot_vert.png";

    public Mother(int X, int Y){
        super(X,Y, SPRITE_LINK);
        this.setSpeedX(1);
        this.setSizeX(50);
        this.setSizeY(40);
        this.setLife(250);
        this.setWeapon(new PiouPiou());
        this.setScore(20);
        //this.setColor(Color.BROWN);

        this.sprite.setSize(this.getSizeX(),this.getSizeY());
        this.texture_bullet = new Texture(Gdx.files.internal(SPRITE_BULETTE_LINK));

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
        this.weapon.use(balles_ennemies, this.texture_bullet, cible, x, y);
    }
}
