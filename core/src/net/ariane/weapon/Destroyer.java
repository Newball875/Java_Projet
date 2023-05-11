package net.ariane.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

public class Destroyer extends Weapon{
    public Destroyer(){
        super(6,6,5);
    }

    public void use(HashSet<Bullet> balles_tab, Entite cible, int X, int Y){

        if(this.wait<=0){

            int longX = cible.getX() - X;
            int longY = cible.getY() - Y;
            int D = (int)Math.sqrt((longX * longX + longY * longY));

            int speedX = longX * this.getSpeedBullet() / D;
            int speedY = longY * this.getSpeedBullet() / D;

            balles_tab.add(new Bullet(X, Y, speedX, speedY, Color.RED));
            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }
    }
}
