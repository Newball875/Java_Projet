package net.ariane.levels;

import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level1 extends Level{

	public Level1(){
		super(1,"Niveau 1");
		//Première vague à 1 ennemi : 1 Classique
		this.vagues[0]=new Ennemi[1];
		this.vagues[0][0]=new Classique(100,700);
	}
}
