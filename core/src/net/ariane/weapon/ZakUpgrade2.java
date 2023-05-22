package net.ariane.weapon;

import com.badlogic.gdx.graphics.Texture;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

import com.badlogic.gdx.graphics.Color;

public class ZakUpgrade2 extends Weapon{
    private final static int SPEEDBULLET=5;
    private final static int COOLDOWN=6;
    private final static int DAMAGE=5;
    private final static Color COLOR=Color.GREEN;

    public ZakUpgrade2(){
        super(SPEEDBULLET,COOLDOWN,DAMAGE,COLOR);
    }


    public void use(HashSet<Bullet> balles_tab, Texture texture, Entite cible, int X, int Y) {

        if (this.wait <= 0) {

            for (int i = -1; i <= 1; i++) {

                int longX = i * 10;
                int longY = 5 * 10;
                int D = (int) Math.sqrt((longX * longX + longY * longY));

                int speedX = (longX * (this.getSpeedBullet() * 10) / D) / 10;
                int speedY = (longY * (this.getSpeedBullet() * 10) / D) / 10;

                balles_tab.add(new Bullet(X, Y, speedX, speedY, texture,getDamage()));
            }
            this.wait = this.getCooldown();
        } else {
            this.wait--;
        }
    }
}
