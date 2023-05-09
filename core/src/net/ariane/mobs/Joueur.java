package net.ariane.mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Joueur extends Entite{

    private static final int MAXLIFE = 100;
    private static final int SIZEX=10;
    private static final int SIZEY=10;

    public Joueur(){
        super();
    }

    public void update(){
		this.setX(Gdx.input.getX()-(this.getSizeX()/2));
		this.setY((Gdx.graphics.getHeight()-Gdx.input.getY())-(this.getSizeY()/2));
        shoot();
        //System.out.println("COOS SOURIS : "+Gdx.input.getX()+" ; "+(Gdx.graphics.getHeight()-Gdx.input.getY()));
        //System.out.println("COOS CARRE : "+this.getX()+" ; "+this.getY());
        //System.out.println("\n\n");
	}

    public void shoot(){
        if(Gdx.input.isKeyPressed(Keys.SPACE)){
            System.out.println("SALUUUUUT");
        }
    }
}
