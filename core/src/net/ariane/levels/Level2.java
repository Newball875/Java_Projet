package net.ariane.levels;

import net.ariane.mobs.Ennemi;
import net.ariane.mobs.ennemis.*;

public class Level2 extends Level{

	public Level2(){
		super(2);     
		//Première vague à 1 ennemi : 1 Classique
		this.vagues[0]=new Ennemi[1];
		this.vagues[0][0]=new Classique(100,700);

		//Seconde Vague : 1 Classique et 1 Ywing
		this.vagues[1]=new Ennemi[2];
		this.vagues[1][0]=new Mother(100,700);
		this.vagues[1][1]=new Ywing(150,650);
	}
}
