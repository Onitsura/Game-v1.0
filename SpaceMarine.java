package Chaos;

import Game.Constants;
import Game.ICharacter;
import Guns.Bolter;



public class SpaceMarine extends Chaos {
	
	String name;
    private int health = Constants.CHAOS_SM_HEALTH;
    private int attackPower = Constants.CHAOS_SM_DAMAGE;
    private int heal;
    private int experience;
    private int curse = Constants.CHAOS_CURSE;
    Bolter weapon;
	
	public SpaceMarine(String name, Bolter weapon) {
		this.weapon = weapon;
		this.name = name;
	}
    
    
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getAttackPower() {
		return attackPower;
	}

	

	@Override
	public int getExperience() {
		return experience;
	}

	@Override
	public void setAttackPower(int attackPower) {
			this.attackPower = attackPower;
	}

	@Override
	public void gainExperience() {
		experience +=15;
	}

	@Override
	public void attack(ICharacter opponent) {
		this.status(opponent);
		this.beCursed(opponent);
		
		opponent.takeDamage(this.attackPower);
		System.out.println(opponent.getName() + "'ve been attacked by "+ this.getName() + ".");
		System.out.println(opponent.getName() + " have " + opponent.getHealth() + " hp left.\n");
		this.status(opponent);
		this.gainExperience();
		curse += this.attackPower;
				
	}

	@Override
	public void jump() {
				
	}

	@Override
	public void run() {
				
	}

	@Override
	public void say() {
		System.out.println("For Chaos!!!");
				
	}

	@Override
	public int healUp() {
		return health += heal;
	}

	@Override
	public int takeDamage(int attackPower) {
		return health -= attackPower;
	}

	@Override
	public void beCursed(ICharacter opponent) {
		if (curse > 500) {
			System.out.println("*" + this.getName() + " being cursed.*");
			this.attackPower = attackPower*2;
			this.health += opponent.takeDamage(this.attackPower);
		}
				
	}
	public void reload() {
		if (this.weapon.getAmmo() <= 0) {
			this.weapon.setAmmo(Constants.BOLTER_AMMO);
			System.out.println("*RELOAD*\n");
			
		}
	}

	@Override
	public void attackWithWeapon(ICharacter opponent) {
		this.setAttackPower(weapon.doDamage());
		this.reload();
		this.attack(opponent);
		System.out.println("Weapon ammo: " + weapon.getAmmo());
		
	}

}
