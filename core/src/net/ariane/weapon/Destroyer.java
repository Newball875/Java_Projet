package net.ariane.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

public class Destroyer extends Weapon{
    private final static int SPEEDBULLET=5;
    private final static int COOLDOWN=6;
    private final static int DAMAGE=5;
    private final static Color COLOR=Color.RED;

    public Destroyer(){
        super(SPEEDBULLET,COOLDOWN,DAMAGE,COLOR);
    }

    public void use(HashSet<Bullet> balles_tab, Texture texture, Entite cible, int X, int Y){

        if(this.wait<=0){

            int longX = (cible.getX() - X) * 10;
            int longY = (cible.getY() - Y) * 10;
            int D = (int)Math.sqrt((longX * longX + longY * longY));

            int speedX = (longX * (this.getSpeedBullet() * 10) / D) / 10;
            int speedY = (longY * (this.getSpeedBullet() * 10) / D) / 10;

            balles_tab.add(new Bullet(X, Y, speedX, speedY, texture));
            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }
    }
}
