package net.ariane.mobs.ennemis;

import net.ariane.mobs.Ennemi;
import net.ariane.weapon.Destroyer;

public class Classique extends Ennemi {
    public Classique(int X, int Y){
        super(X,Y);
        this.setLife(20);
        this.setWeapon(new Destroyer());
        this.setScore(5);
    }
}
