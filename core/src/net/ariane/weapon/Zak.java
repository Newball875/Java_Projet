package net.ariane.weapon;

import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

import com.badlogic.gdx.graphics.Color;

public class Zak extends Weapon{
    private final static int SPEEDBULLET=5;
    private final static int COOLDOWN=6;
    private final static int DAMAGE=5;
    private final static Color COLOR=Color.GREEN;

    public Zak(){
        super(SPEEDBULLET,COOLDOWN,DAMAGE,COLOR);
    }


    public void use(HashSet<Bullet> balles_tab, Entite cible, int X, int Y){
        if(this.wait<=0){
            balles_tab.add(new Bullet(X, Y, 0, this.getSpeedBullet(), this.getColor()));
            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }
    }
}
