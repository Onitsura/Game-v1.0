package Necrons;

import Game.ICharacter;

public abstract class Necrons implements ICharacter {

        public static final String id = "Necron";
        String name;
        int health;
        int attackPower;
        int heal;
        int expierence;


        
        
        public abstract void setArmor(int armor);
        
        public abstract void setHealth(int health);
       
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
        


        public void say() {
            System.out.println("....hkhkkh.......");
        }

		

    }
