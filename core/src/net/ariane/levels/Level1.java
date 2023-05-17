package net.ariane.levels;

import net.ariane.mobs.ennemis.*;

public class Level1 extends Level{

	public Level1(){
		super(1);
		int i=0;
		while(i<this.getNombre()){
			this.vagues[i].add(new Classique(100,700));
			i=i+1;
		}
	}
}
