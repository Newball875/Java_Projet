package net.ariane.bullet;

import java.util.HashSet;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import net.ariane.mobs.*;

public class Bullet {

    public static final int DEFAULT_SIZE = 5;
    public static final int DEFAULT_DAMAGE = 10;

    public int size;
    public int Xposition, Yposition;
    public int Xspeed, Yspeed;
    public int damage;
    private Color color;

    protected Sprite sprite;
    private boolean delete=false;

    public Bullet(int Xposition, int Yposition, int Xspeed, int Yspeed, Texture texture){
        setSize(DEFAULT_SIZE);
        setDamage(DEFAULT_DAMAGE);
        setXspeed(Xspeed);
        setYspeed(Yspeed);
        setXposition(Xposition);
        setYposition(Yposition);
        this.sprite = new Sprite(texture);
        this.sprite.setSize(this.size * 2, this.size * 2);
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

    public int getDamage(){return this.damage;}

    public Color getColor(){return this.color;}
    public void setColor(Color color){this.color=color;}

    public boolean getDelete(){return this.delete;}

    public void draw(ShapeRenderer shape, SpriteBatch batch){
        this.sprite.setPosition((float)this.getXposition(),(float)this.getYposition());
        sprite.draw(batch);

		//shape.setColor(this.color);
		//shape.circle(this.getXposition(),this.getYposition(),this.getSize());
	}

    public boolean update(){
        setXposition(getXposition() + getXspeed());
        setYposition(getYposition() + getYspeed());
        return this.border();
    }

    boolean border(){
        return (this.getXposition()<=0 || this.getXposition()>=800)||(this.getYposition()<=0 || this.getYposition()>=800);
    }

    public boolean checkCollision(Joueur cible){
		if(collidesWith(cible)){
            cible.attack(this.getDamage());
            return true;
        }
        return false;
	}

	public boolean checkCollision(HashSet<Ennemi>ennemis){
        for(Ennemi cible:ennemis){
		    if(collidesWith(cible)){
                cible.attack(this.getDamage());
                return true;
            }
        }
        return false;
	}

    private boolean collidesWith(Entite cible){
		int start_x=this.getXposition()-(size),end_x=this.getXposition()+(size);
		int start_y=this.getYposition()-(size),end_y=this.getYposition()+(size);
		int pStart_x=cible.getX(),pEnd_x=cible.getX()+(cible.getSizeX());
		int pStart_y=cible.getY(),pEnd_y=cible.getY()+cible.getSizeY();
		if(end_x<pStart_x){
			return false;
		}
		if(start_x>pEnd_x){
			return false;
		}
		if(end_y<pStart_y){
			return false;
		}
		if(start_y>pEnd_y){
			return false;
		}
		return true;
	}
}