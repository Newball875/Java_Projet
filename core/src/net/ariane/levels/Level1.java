package net.ariane.levels;

import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level1 extends Level{

	public Level1(){
		super(1);
		int i=0;
		while(i<this.getNombre()){
			Ennemi ennemi=new Classique(100,700);
			Ennemi mechant=new Ywing(150,650);
			this.vagues[i]=new Ennemi[2];
			this.vagues[i][0]=ennemi;
			this.vagues[i][1]=mechant;
			this.ennemis.add(ennemi);
			this.ennemis.add(mechant);
			i=i+1;
		}
	}
}
