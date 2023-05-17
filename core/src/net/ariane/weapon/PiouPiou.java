package net.ariane.weapon;

import com.badlogic.gdx.graphics.Color;
import net.ariane.bullet.Bullet;
import net.ariane.mobs.Entite;

import java.util.HashSet;

public class PiouPiou extends Weapon{

    private final static int SPEEDBULLET=4;
    private final static int COOLDOWN=15;
    private final static int DAMAGE=4;
    private final static Color COLOR=Color.RED;

    public PiouPiou(){
        super(SPEEDBULLET,COOLDOWN,DAMAGE,COLOR);
    }

    public void use(HashSet<Bullet> balles_tab, Entite cible, int X, int Y){

        if(this.wait<=0){

            for(int i = -5; i <= 5; i++){
                int [] jliste = {-5, 5};
                for(int j=0; j<=1; j++) {

                    int longX = (X + i) - X;
                    int longY = (Y + jliste[j]) - Y;
                    int D = (int) Math.sqrt((longX * longX + longY * longY));

                    int speedX = longX * this.getSpeedBullet() / D;
                    int speedY = longY * this.getSpeedBullet() / D;

                    balles_tab.add(new Bullet(X, Y, speedX, speedY, Color.RED));
                }

            }

            for(int j = -4; j <= 4; j++){
                int [] iliste = {-5, 5};
                for(int i=0; i<=1; i++) {

                    int longX = (X + iliste[i]) - X;
                    int longY = (Y + j) - Y;
                    int D = (int) Math.sqrt((longX * longX + longY * longY));

                    int speedX = longX * this.getSpeedBullet() / D;
                    int speedY = longY * this.getSpeedBullet() / D;

                    balles_tab.add(new Bullet(X, Y, speedX, speedY, Color.RED));
                }

            }

            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }

    }
}
