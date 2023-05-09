package net.ariane.mobs.ennemis;

import net.ariane.mobs.Ennemi;
import net.ariane.weapon.*;

public class Navar extends Ennemi{

    public Navar(int X, int Y){
        super(X,Y);
        this.setLife(20);
        this.setWeapon(new Rafale());
    }

}
