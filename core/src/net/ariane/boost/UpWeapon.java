package net.ariane.boost;

import net.ariane.mobs.Joueur;
import net.ariane.weapon.Weapon;

public class UpWeapon extends LuckyBlock{

    public UpWeapon(int x, int y){
        super(x,y);
    }

    public void use(Joueur joueur){
        if(joueur.weapon_used < joueur.WEAPON_NB){
            joueur.weapon_used++;
        }
        System.out.println(joueur.weapon_used);
    }

}