package net.ariane.weapon;

import com.badlogic.gdx.graphics.Texture;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

import com.badlogic.gdx.graphics.Color;

public class ZakUpgrade3 extends Weapon{
    private final static int SPEEDBULLET=5;
    private final static int COOLDOWN=60;
    private final static int DAMAGE=1000;
    private final static Color COLOR=Color.GREEN;

    public ZakUpgrade3(){
        super(SPEEDBULLET,COOLDOWN,DAMAGE,COLOR);
    }


    public void use(HashSet<Bullet> balles_tab, Texture texture, Entite cible, int X, int Y){
        if(this.wait<=0){
            balles_tab.add(new Bullet(X, Y, 0, this.getSpeedBullet(), texture,getDamage()));
            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }
    }
}
