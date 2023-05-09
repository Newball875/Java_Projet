package net.ariane.mobs;

public class Ennemi extends Entite{

    public static final int MAXLIFE = 1000;
    public static final int SPEED = 1;
    public static final int SIZEX = 20;
    public static final int SIZEY = 20;

    public Ennemi(int X, int Y){
        super();
        this.setX(X);
        this.setY(Y);
    }
    
}
