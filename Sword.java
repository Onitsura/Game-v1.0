package Guns;
import Game.Constants;

public class Sword extends Steel {

	private int damage = Constants.SWORD_DAMAGE;
	private int needExperience = 10;
	
	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public int getExperience() {
		return needExperience;
	}

	@Override
	public int doDamage() {
		if (this.criticalChance() == true) {
			return damage*2;
		}
		else {
			return damage;
		}
		
	}
	@Override
	public boolean criticalChance() {
		//шанс критического урона +100%
		if (Constants.RANDOM.nextInt(5)+1 == 5) {
			System.out.println("*CRIT*");
			return true;
		}
		else {
			System.out.println("*NO CRIT*");
			return false;
		}
	}
	
	
}
