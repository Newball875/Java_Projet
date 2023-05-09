package net.ariane.bullet;

public class Bullet {

    public static final int DEFAULT_SIZE = 5;
    public static final int DEFAULT_DAMAGE = 10;

    public int size;
    public int positionx, positiony;
    public int speed;

    public int damage;

    public Bullet(int positionx, int positiony, int speed){
        setSize(DEFAULT_SIZE);
        setDamage(DEFAULT_DAMAGE);
        setSpeed(speed);
        setPositionx(positionx);
        setPositiony(positiony);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
