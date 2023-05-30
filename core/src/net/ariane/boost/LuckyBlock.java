package net.ariane.boost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.ariane.mobs.Ennemi;
import net.ariane.mobs.Entite;
import net.ariane.mobs.Joueur;

import java.util.HashSet;

public abstract class LuckyBlock {
    private Sprite sprite;
    private Texture texture;
    private String lien_img = "sprites/Bonus.png";

    private int x;
    private int y;
    private int size = 15;

    public LuckyBlock(int X, int Y){
        this.setX(X);
        this.setY(Y);

        this.texture = new Texture(Gdx.files.internal(lien_img));
        this.sprite = new Sprite(this.texture);
    }

    public boolean update(){
        this.setY(this.getY() - 3);
        return this.border();
    }

    boolean border(){
        return (this.getX() <= 0);
    }

    public boolean checkCollision(Joueur cible){
        if(collidesWith(cible)){
            return true;
        }
        return false;
    }

    private boolean collidesWith(Entite cible){
        int start_x=this.getX()-(size),end_x=this.getX()+(size);
        int start_y=this.getY()-(size),end_y=this.getY()+(size);
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

    public void draw(ShapeRenderer shape, SpriteBatch batch) {
        this.sprite.setPosition((float) this.getX(), (float) this.getY());
        sprite.draw(batch);
    }

    public int getX(){return x;}
    public void setX(int x){this.x=x;}

    public int getY(){return y;}
    public void setY(int y){this.y=y;}

    public abstract void use(Joueur joueur);

}
