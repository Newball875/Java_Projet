package net.ariane.mobs.ennemis;

import com.badlogic.gdx.graphics.Texture;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;
import net.ariane.mobs.Joueur;

import com.badlogic.gdx.Gdx;

import net.ariane.mobs.Ennemi;
import net.ariane.weapon.PiouPiou;
import net.ariane.weapon.Rafale;
import net.ariane.weapon.Weapon;

import java.util.HashSet;

public class EnderDragon extends Ennemi{

    private static String SPRITE_LINK = "sprites/Boss_1.png";
    private static String SPRITE_BULETTE_LINK = "sprites/Slime_shoot_vert.png";

    Weapon weapon2;
    Weapon weapon3;
    public EnderDragon(int X, int Y){
        super(X,Y, SPRITE_LINK);
        this.setSpeedX(0);
        this.setSizeX(400);
        this.setSizeY(200);
        this.setMaxLife(2000);
        this.setLife(2000);
        this.setWeapon(new PiouPiou());
        this.setWeapon2(new PiouPiou());
        this.setWeapon3(new Rafale());
        this.setScore(2000);
        //this.setColor(Color.CORAL);

        this.sprite.setSize(this.getSizeX(),this.getSizeY());
        this.texture_bullet = new Texture(Gdx.files.internal(SPRITE_BULETTE_LINK));

    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }
    public void setWeapon3(Weapon weapon3) {
        this.weapon3 = weapon3;
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

    public void shoot(HashSet<Bullet>balles_ennemies, Entite cible){

        int x = this.getX();
        int y = this.getY();
        this.weapon.use(balles_ennemies, this.texture_bullet, cible,  x + (this.getSizeX() / 5), y + (getSizeY() / 2));
        this.weapon3.use(balles_ennemies, this.texture_bullet, cible,  x + (this.getSizeX() / 2), y);
        this.weapon2.use(balles_ennemies, this.texture_bullet, cible,  x + 4 * (this.getSizeX() / 5), y + (getSizeY() / 2));


    }
}