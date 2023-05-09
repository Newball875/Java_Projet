package net.ariane.mobs.ennemis;

import net.ariane.mobs.Ennemi;
import net.ariane.weapon.Destroyer;

public class Classique extends Ennemi {
    public Classique(){
        super();
        this.setLife(20);
        this.setWeapon(new Destroyer());
    }
}
