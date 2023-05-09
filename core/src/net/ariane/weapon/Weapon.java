package net.ariane.weapon;

import net.ariane.bullet.Bullet;

public class Weapon {

    private static final int DEFAULT_SPEED_BULLET = 1;
    private static final int DEFAULT_SPEED_SHOT = 3;
    private static final int DEFAULT_DAMAGE = 10;


    public int speedBullet;
    public int speedShot;
    public int damage;


    public Weapon(){
        setSpeedBullet(DEFAULT_SPEED_BULLET);
        setSpeedShot(DEFAULT_SPEED_SHOT);
        setDamage(DEFAULT_DAMAGE);
    }

    public Weapon(int speedBullet, int speedShot, int damage){
        setSpeedBullet(speedBullet);
        setSpeedShot(speedShot);
        setDamage(damage);
    }

    public void setSpeedBullet(int speedBullet) {
        this.speedBullet = speedBullet;
    }
    public int getSpeedBullet() {
        return speedBullet;
    }

    public void setSpeedShot(int speedShot) {
        this.speedShot = speedShot;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void use(int x, int y, int Xspeed, int Yspeed){
        Bullet bullet = new Bullet(x, y, Xspeed, Yspeed);
    }
}