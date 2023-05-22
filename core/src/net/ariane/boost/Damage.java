package net.ariane.boost;

import net.ariane.weapon.Weapon;

public class Damage extends LuckyBlock{
    private int damage;
    private int wait;
    private int heal = 20;

    public Damage(int x, int y, Weapon weapon){
        super(x,y);
        damage = weapon.getDamage();
        weapon.setDamage(damage+20);
    }

    public boolean durée(int temps){
        temps=100*temps;
        if(wait<temps){
            wait++;
            return false;
        }
        wait=0;
        return true;
    }

}