package net.ariane.mobs;

public class Entite {

    private static final int MAXLIFE = 1;
    private static final int SPEED = 1;
    private static final int SIZEX = 20;
    private static final int SIZEY = 20;

    public int life ;
    public int speed ;
    public int sizeX, sizeY;

    public Entite(){
        setLife(MAXLIFE);
        setSpeed(SPEED);
        setSizeX(SIZEX);
        setSizeY(SIZEY);
    }

    private int attack(Bullet bullet,Entite entite){
        if(entite.life - bullet.power <= 0){
            return 0 ;
        }
        return entite.life - bullet.power ;
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