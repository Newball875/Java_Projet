package net.ariane.mobs;

import net.ariane.bullet.Bullet;
import net.ariane.weapon.Weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Entite {

    private static final int MAXLIFE = 1;
    private static final int SPEED = 1;
    private static final int SIZEX = 20;
    private static final int SIZEY = 20;
    private static final int X=15;
    private static final int Y=15;

    private int life ;
    private int speed ;
    private int sizeX, sizeY;
    private int x,y;
    public Weapon weapon ;

    public Bullet bullet ;

    public Entite(){
        setLife(MAXLIFE);
        setSpeed(SPEED);
        setSizeX(SIZEX);
        setSizeY(SIZEY);
    }

    public int getLife(){return life;}
    public void setLife(int life){this.life=life;}

    public int getSpeed(){return speed;}
    public void setSpeed(int speed){this.speed=speed;}

    public int getSizeX(){return sizeX;}
    public void setSizeX(int sizeX){this.sizeX=sizeX;}

    public int getSizeY(){return sizeY;}
    public void setSizeY(int sizeY){this.sizeY=sizeY;}

    public int getX(){return x;}
    public void setX(int x){this.x=x;}

    public int getY(){return y;}
    public void setY(int y){this.y=y;}

    public Weapon getWeapon(){return this.weapon;}
    public void setWeapon(Weapon weapon){this.weapon=weapon;}

    private int attack(Bullet bullet,Entite entite){
        if(entite.life - bullet.damage <= 0){
            return 0 ;
        }
        return entite.life - bullet.damage ;
    }

    public void draw(ShapeRenderer shape){
		shape.setColor(Color.WHITE);
		shape.rect((float)this.getX(),(float)this.getY(),(float)this.getSizeX(),(float)this.getSizeY());
	}

    public void update(){
		this.setX(Gdx.input.getX());
		this.setY((Gdx.graphics.getHeight()-Gdx.input.getY()));
	}
}