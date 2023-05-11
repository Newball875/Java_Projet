package net.ariane.weapon;

import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

public class Rafale extends Weapon{
    //Tir 3 balles(diagonale gauche, diagonale droite, bas droit)
    public Rafale(){
        super(2,1,5);
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
