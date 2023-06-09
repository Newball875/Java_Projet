package net.ariane.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Replay {

    private static final int SIZEX = 200;
    private static final int SIZEY = 200;
    private static final int X=100;
    private static final int Y=600;
    private int sizeX, sizeY;
    private int x,y;
    private Color color=Color.WHITE;


    public Replay(){
        setSizeX(SIZEX);
        setSizeY(SIZEY);
        setX(X);
        setY(Y);
        setColor(color);
    }

    public void draw(ShapeRenderer shape){
        shape.setColor(this.color);
        shape.rect((float)this.getX(),(float)this.getY(),(float)(this.getSizeX()),(float)this.getSizeY());
    }

    public int getSizeX(){return sizeX;}
    public void setSizeX(int sizeX){this.sizeX = sizeX;}

    public int getSizeY(){return sizeY;}
    public void setSizeY(int sizeY){this.sizeY = sizeY;}

    public int getX(){return x;}
    public void setX(int x){this.x=x;}

    public int getY(){return y;}
    public void setY(int y){this.y=y;}

    public Color getColor(){return this.color;}
    public void setColor(Color color){this.color=color;}
}
