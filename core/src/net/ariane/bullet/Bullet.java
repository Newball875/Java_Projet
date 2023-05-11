package net.ariane.bullet;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import net.ariane.mobs.*;

public class Bullet {

    public static final int DEFAULT_SIZE = 5;
    public static final int DEFAULT_DAMAGE = 10;

    public int size;
    public int Xposition, Yposition;
    public int Xspeed, Yspeed;
    public int damage;

    public Bullet(int Xposition, int Yposition, int Xspeed, int Yspeed){
        setSize(DEFAULT_SIZE);
        setDamage(DEFAULT_DAMAGE);
        setXspeed(Xspeed);
        setYspeed(Yspeed);
        setXposition(Xposition);
        setYposition(Yposition);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize(){return this.size;}

    public void setXposition(int positionx) {
        this.Xposition = positionx;
    }

    public void setYposition(int positiony) {
        this.Yposition = positiony;
    }

    public int getXposition() {
        return Xposition;
    }

    public int getYposition() {
        return Yposition;
    }


    public void setXspeed(int xspeed) {
        Xspeed = xspeed;
    }

    public void setYspeed(int yspeed) {
        Yspeed = yspeed;
    }

    public int getXspeed() {
        return Xspeed;
    }

    public int getYspeed() {
        return Yspeed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void draw(ShapeRenderer shape){
		shape.setColor(Color.RED);
		shape.circle(this.getXposition(),this.getYposition(),this.getSize());
	}

    public void update(){
        setXposition(getXposition() + getXspeed());
        setYposition(getYposition() + getYspeed());
    }
}