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

    private int attack(Bullet bullet,Entite entite){
        if(entite.life - bullet.power <= 0){
            return 0 ;
        }
        return entite.life - bullet.power ;
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