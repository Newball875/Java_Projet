package net.ariane.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

public class Zak extends Weapon{
    public Zak(){
        super(6,6,5);
    }


    public void use(HashSet<Bullet> balles_tab, Entite cible, int X, int Y){
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if(this.wait<=0){
                balles_tab.add(new Bullet(X, Y, 0, this.getSpeedBullet(), Color.GREEN));
                this.wait=this.getCooldown();
            }
            else{
                this.wait--;
            }
        }
    }
}
