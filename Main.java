package Game;

import Guns.GaussGun;
import Guns.Shield;
import Guns.Sword;
import Guns.Bolter;
import Necrons.Immortal;
import Necrons.Lychguard;
import Chaos.SpaceMarine;


public class Main {

	public static void main(String[] args) {
		GaussGun gun1 = new GaussGun();
		GaussGun gun2 = new GaussGun();
		Sword sword1 = new Sword();
		Bolter bolter1 = new Bolter();
		Shield shield1 = new Shield();
		Shield shield2 = new Shield();
		Shield shield3 = new Shield();
		
		Immortal player1 = new Immortal("Alan", gun1, shield1);
		Immortal player2 = new Immortal( "Stewart", gun2, shield2);
		Lychguard player3 = new Lychguard("John", sword1, shield3);
		SpaceMarine player4 = new SpaceMarine("Chorus", bolter1);
		player1.say();
		player1.attack(player2);
		player1.attackWithWeapon(player2);
		player2.attackWithWeapon(player1);
		
		player1.shareHealth(player2);
		player1.useShield(shield1);
		
		player2.attackWithWeapon(player1);
		player2.attackWithWeapon(player1);
		player2.attackWithWeapon(player1);
		player2.attackWithWeapon(player1);
		player2.attackWithWeapon(player1);
		player3.attackWithWeapon(player2);
		player4.attackWithWeapon(player3);
		player4.attackWithWeapon(player3);
		player4.attackWithWeapon(player3);
		player4.attackWithWeapon(player3);
		player4.attackWithWeapon(player3);
		player4.attackWithWeapon(player3);
		player4.attackWithWeapon(player3);
		
	}

}




