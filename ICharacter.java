package Game;

public interface ICharacter {
	
	String getName();
	int getHealth();
	int getAttackPower();
	int getExperience();
	void setAttackPower(int attackPower);
	void gainExperience();
	void attackWithWeapon(ICharacter opponent);
	
	
	
	
	void attack(ICharacter opponent);
	void status(ICharacter character);
	boolean isDead();
	void jump();
	void run();
	void say();
	int healUp();
	int takeDamage(int attackPower);
	

	
	
	

}
