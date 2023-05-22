package net.ariane.boost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class LuckyBlock {
    private Sprite sprite;
    private Texture texture;
    private String lien_img;

    private int x,y;

    public LuckyBlock(int X, int Y){
        this.setX(X);
        this.setY(Y);

        this.texture = new Texture(Gdx.files.internal(lien_img));
        this.sprite = new Sprite(this.texture);
    }

    public int getX(){return x;}
    public void setX(int x){this.x=x;}

    public int getY(){return y;}
    public void setY(int y){this.y=y;}

}
