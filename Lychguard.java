package Necrons;

import Game.Constants;
import Game.ICharacter;
import Guns.Shield;
import Guns.Steel;
import Guns.Sword;

public class Lychguard extends Necrons {
	
	private String name;
	private int health = Constants.NECRONS_LYCHGUARD_HEALTH;
	private int attackPower = Constants.NECRONS_LYCHGUARD_DAMAGE;
	private int heal = 150;
	private int experience = 0;
	private int armor = 100;
	private Steel weapon;
	
	public Lychguard(String name, Sword weapon, Shield shield) {
		this.name = name;
		this.weapon = weapon;
		
	}
	public void useShield(Shield shield) {
    	this.setArmor(shield.blockDamage());
    	System.out.println(this.getName() + " picked up a shield.\n*" + this.getName() + "'s Armor now is: " + this.armor + "*\n");

    }
	
	

	@Override
	public void attack(ICharacter opponent) {
		this.status(opponent);
        opponent.takeDamage(attackPower);
        System.out.println(opponent.getName() + "'ve been attacked by " + this.getName() + ".");
        System.out.println(opponent.getName() + " have " + opponent.getHealth() + " hp left.\n");
        this.gainExperience();
        this.status(opponent);
				
	}
	@Override
	public void attackWithWeapon(ICharacter opponent) {
        this.setAttackPower(weapon.doDamage());
        System.out.println("*DAMAGE :" + this.getAttackPower() + "*\n");
        this.attack(opponent);
        
        
    }


    @Override
    public void jump() {
        System.out.println("*You cannot jump, you're necron, c'mon*");
    }

    @Override
    public void run() {
        System.out.println("*Walk slowly*");

    }

	@Override
	public int healUp() {
				
		return health += heal;
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
	public void setArmor(int armor) {
		this.armor = armor;
	}


	@Override
	public int takeDamage(int opponentAttackPower) {
    	
    	if (armor <= opponentAttackPower) {
    		health += (armor - opponentAttackPower);
    		if (armor - opponentAttackPower < 0) {
    			this.setArmor(0); 
    		}
    		return health;
    	}
    	else {
    		armor -= opponentAttackPower;
    		return 0;
    	}
    }
	@Override
	public void setHealth(int health) {
		this.health = health;		
	}

}
