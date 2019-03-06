package Chaos;

import Game.ICharacter;

public abstract class Chaos implements ICharacter {

	String name;
    int health;
    int attackPower;
    int heal;
    int experience;
    int curse;  // уникальное поле хаоса, показатель "проклятия"
    			//при наборе определенного значения проклятия запускается метод, который ниже
    
    public abstract void beCursed(ICharacter opponent); //уникальный для каждой единицы Хаоса метод, который даёт преимущество в бою.
    
    
    
    
    public boolean isDead() {
        if (this.getHealth() <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void status(ICharacter character) {
        if (character.isDead() == true) {
            System.out.println(character.getName() + " is dead");
            System.out.println(this.getName() + " win!");
            System.exit(0);
        } else if (this.isDead() == true) {
            System.out.println(this.getName() + "is dead");
            System.out.println(character.getName() + " win!");
            System.exit(0);
        }
    }
    
    
    
}
