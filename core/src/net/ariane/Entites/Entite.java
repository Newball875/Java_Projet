package net.ariane.Entites;

public class Entite {

    public static final int MAXLIFE = 1;
    public static final int SPEED = 1;
    public static final int SIZEX = 20;
    public static final int SIZEY = 20;
    public int maxLife, life ;
    public int speed ;
    public int sizeX, sizeY;

    public Entite(){
        setLife(MAXLIFE);
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }



    //Ajouter Arme et Sprite
}