package net.ariane.mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.ariane.ArianeGame;
import net.ariane.hud.Score;
import net.ariane.weapon.*;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public abstract class Entite {

    private static final int MAXLIFE = 1;
    private static final int SPEEDX = 10;
    private static final int SPEEDY = 10;
    private static final int SIZEX = 20;
    private static final int SIZEY = 20;
    private static final int X=100;
    private static final int Y=100;

    private int life ;
    private int maxLife ;
    private int speedx ;
    private int speedy ;
    private int sizeX, sizeY;
    private int x,y;

    protected Sprite sprite;
    protected Texture texture;
    protected Texture texture_bullet;
    protected Weapon weapon;
    protected Sound sound;            //Le son sera quand une entité est touchée


    public Entite(int maxLife, int sizeX, int sizeY, String lien_img, String lien_son){
        if(maxLife<=0){
            maxLife = MAXLIFE;
        }
        if(sizeX <= 0){sizeX = SIZEX;}
        if(sizeY <= 0){sizeY = SIZEY;}
        setMaxLife(maxLife);
        setLife(maxLife);
        setSpeedX(SPEEDX);
        setSpeedX(SPEEDY);
        setSizeX(sizeX);
        setSizeY(sizeY);
        setX(X);
        setY(Y);
        setSound(lien_son);

        this.texture = new Texture(Gdx.files.internal(lien_img));
        this.sprite = new Sprite(this.texture);
    }

    public Entite(int maxLife, int sizeX, int sizeY, String lien_son){
        if(maxLife<=0){
            maxLife = MAXLIFE;
        }
        if(sizeX <= 0){sizeX = SIZEX;}
        if(sizeY <= 0){sizeY = SIZEY;}
        setMaxLife(maxLife);
        setLife(maxLife);
        setSpeedX(SPEEDX);
        setSpeedX(SPEEDY);
        setSizeX(sizeX);
        setSizeY(sizeY);
        setX(X);
        setY(Y);
        setSound(lien_son);
    }

    public Entite(int life,int maxLife, String lien_img, String lien_son){
        if(maxLife<=0){
            maxLife = MAXLIFE;
        }
        setMaxLife(maxLife);
        setSpeedX(SPEEDX);
        setSpeedX(SPEEDY);
        setSizeX(SIZEX);
        setSizeY(SIZEY);
        setX(X);
        setY(Y);
        setLife(life);
        setSound(lien_son);

        this.texture = new Texture(Gdx.files.internal(lien_img));
        this.sprite = new Sprite(this.texture);
    }

    public int getLife(){return life;}
    public void setLife(int life){this.life = life;}
    public int getMaxlife(){return this.maxLife;}
    public void setMaxLife(int maxLife){this.maxLife = maxLife;}

    public int getSpeedX(){return speedx;}
    public void setSpeedX(int speedx){this.speedx = speedx;}
    public int getSpeedY(){return speedy;}
    public void setSpeedY(int speedy){this.speedy = speedy;}

    public int getSizeX(){return sizeX;}
    public void setSizeX(int sizeX){this.sizeX = sizeX;}

    public int getSizeY(){return sizeY;}
    public void setSizeY(int sizeY){this.sizeY = sizeY;}

    public int getX(){return x;}
    public void setX(int x){this.x=x;}

    public int getY(){return y;}
    public void setY(int y){this.y=y;}

    public Weapon getWeapon(){return this.weapon;}
    public void setWeapon(Weapon weapon){this.weapon = weapon;}

    public Sound getSound(){return this.sound;}
    public void setSound(String son){this.sound=Gdx.audio.newSound(Gdx.files.internal(son));}

  //  public Color getColor(){return this.color;}
    //public void setColor(Color color){this.color=color;}

    public abstract int attack(int damage);

    public void draw(ShapeRenderer shape, SpriteBatch batch){
        this.sprite.setPosition((float)this.getX(),(float)this.getY());
        sprite.draw(batch);
	}

}