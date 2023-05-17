package net.ariane.levels;

import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level1 extends Level{

	public Level1(){
		super(1);
		int i=0;
		while(i<this.getNombre()){
			Ennemi ennemi=new Classique(100,700);
			this.vagues[i]=new Ennemi[1];
			this.vagues[i][0]=ennemi;
			this.ennemis.add(ennemi);
			i=i+1;
		}
	}
}
