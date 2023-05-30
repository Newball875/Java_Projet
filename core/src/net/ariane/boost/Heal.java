package net.ariane.boost;

import net.ariane.mobs.Joueur;
import java.util.Random;

public class Heal extends LuckyBlock{
    private int heal;
    private Random random ;

    public Heal(int x, int y){
        super(x,y);
        random = new Random() ;
    }

    private void setHeal(){
        this.heal = this.random.nextInt(250) - 50;
    }

    public void use(Joueur joueur) {
        this.setHeal();

        if(joueur.MAXLIFE <= joueur.life + this.heal) {
            joueur.setLife(joueur.MAXLIFE);
        } else {
            joueur.setLife(joueur.life + this.heal);
        }
        System.out.println(this.heal);
    }

}
