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

                int longX = i * 10;
                int longY = -5 * 10;
                int D = (int) Math.sqrt((longX * longX + longY * longY));

                int speedX = (longX * (this.getSpeedBullet() * 10) / D) / 10;
                int speedY = (longY * (this.getSpeedBullet() * 10) / D) / 10;

                balles_tab.add(new Bullet(X, Y, speedX, speedY, Color.RED));


                longX = i * 10;
                longY = 5 * 10;
                D = (int) Math.sqrt((longX * longX + longY * longY));

                speedX = (longX * (this.getSpeedBullet() * 10) / D) / 10;
                speedY = (longY * (this.getSpeedBullet() * 10) / D) / 10;

                balles_tab.add(new Bullet(X, Y, speedX, speedY, Color.RED));


            }
            for(int j = -4; j <= 4; j++){
                int longX = -5 * 10;
                int longY = j * 10;
                int D = (int) Math.sqrt((longX * longX + longY * longY));

                int speedX = (longX * (this.getSpeedBullet() * 10) / D) / 10;
                int speedY = (longY * (this.getSpeedBullet() * 10) / D) / 10;

                balles_tab.add(new Bullet(X, Y, speedX, speedY, Color.RED));

                longX = 5 * 10;
                longY = j * 10;
                D = (int) Math.sqrt((longX * longX + longY * longY));

                speedX = (longX * (this.getSpeedBullet() * 10) / D) / 10;
                speedY = (longY * (this.getSpeedBullet() * 10) / D) / 10;

                balles_tab.add(new Bullet(X, Y, speedX, speedY, Color.RED));


            }

            this.wait=this.getCooldown();
        }
        else{
            this.wait--;
        }

    }
}
