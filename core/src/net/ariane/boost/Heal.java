package net.ariane.boost;

import net.ariane.mobs.Joueur;

public class Heal extends LuckyBlock{
    private int life;
    private int maxLife;
    private int wait;
    private int heal = 20;

    public Heal(int x, int y, Joueur zac){
        super(x,y);
        life = zac.getLife();
        maxLife = zac.getMaxlife();
        if(maxLife<=life+heal){
            zac.setLife(maxLife);
        }
        else{
            zac.setLife(life+heal);
        }
    }

}
