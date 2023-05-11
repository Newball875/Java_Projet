package net.ariane.weapon;

import com.badlogic.gdx.graphics.Color;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

public abstract class Weapon {

    private static final int DEFAULT_SPEED_BULLET = 1;
    private static final int DEFAULT_COOLDOWN = 3;
    private static final int DEFAULT_DAMAGE = 10;


    public int speedBullet;

    public int cooldown;
    public int damage;

    protected int wait=0;
    protected Color color;


    public Weapon(){
        setSpeedBullet(DEFAULT_SPEED_BULLET);
        setCooldown(DEFAULT_COOLDOWN);
        setDamage(DEFAULT_DAMAGE);
        setColor(Color.WHITE);
    }

    public Weapon(int speedBullet, int cooldown, int damage, Color color){
        setSpeedBullet(speedBullet);
        setCooldown(cooldown);
        setDamage(damage);
        setColor(color);
    }

    public void setSpeedBullet(int speedBullet) {
        this.speedBullet = speedBullet;
    }
    public int getSpeedBullet() {
        return speedBullet;
    }

    public int getCooldown(){return this.cooldown;}
    public void setCooldown(int cool){this.cooldown=cool;}


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setColor(Color color){this.color=color;}
    public Color getColor(){return this.color;}


    public abstract void use(HashSet<Bullet> balles_alliees, Entite cible, int x, int y);
}