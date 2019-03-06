package Necrons;

import Game.Constants;
import Game.ICharacter;
import Guns.GaussGun;
import Guns.Shield;


    public class Immortal extends Necrons {

        private String name;
        private int health = Constants.NECRONS_IMMORTAL_HEALTH;
        private int attackPower = Constants.NECRONS_IMMORTAL_DAMAGE;
        private int heal = 150;
        private int experience = 0;
        private int armor = 0;
        private GaussGun weapon;


        public Immortal(String name, GaussGun weapon, Shield shield) {
            this.name = name;
            this.weapon = weapon;

        }


        public void useShield(Shield shield) {
            this.setArmor(shield.blockDamage());
            System.out.println(this.getName() + " picked up a shield.\n*" + this.getName() + "'s Armor now is: " + this.armor + "*\n");

        }

        @Override
        public void attackWithWeapon(ICharacter opponent) {
            //метод атаки с оружием
            this.setAttackPower(weapon.doDamage());
            this.reload();
            this.attack(opponent);
            System.out.println(this.getName() + " weapon ammo: " + weapon.getAmmo() + "\n");

        }

        public void shareHealth(Necrons character) {
            //метод, описывающий хил союзника
            this.health -= 50;
            System.out.println(this.getName() + " drain his oil to " + character.getName() + ". \n*-50 HP*\n" + this.getName() + " have " + this.getHealth() + " HP left.");
            character.setHealth(50);
            System.out.println(character.getName() + " get 50 HP.\n" + character.getHealth() + " HP left\n");

        }

        @Override
        public int takeDamage(int opponentAttackPower) {
            //метод описывающий принятие урона

            if (armor <= opponentAttackPower) {
                //после того, как идёт перезапись значения здоровья идёт проверка и обнуляется броня
                //если значение урона выше чем значение брони

                health += (armor - opponentAttackPower);
                if (armor - opponentAttackPower < 0) {
                    this.setArmor(0);
                }
                return health;
            } else {
                armor -= opponentAttackPower;
                return 0;
            }
        }


        @Override
        public void setArmor(int armor) {
            this.armor = armor;
        }

        @Override
        public int healUp() {
            this.status(this);
            System.out.println("*HEALED FOR 150 HP*\n");
            return health += heal;

        }

        @Override
        public void attack(ICharacter opponent) {
            //метод атаки с руки
            this.status(opponent);
            opponent.takeDamage(attackPower);
            System.out.println(opponent.getName() + "'ve been attacked by " + this.getName() + ".");
            System.out.println(opponent.getName() + " have " + opponent.getHealth() + " hp left.\n");
            this.gainExperience();
            this.status(opponent);
        }

        @Override
        public void jump() {
            System.out.println("*You cannot jump, you're necron, c'mon*");
        }

        @Override
        public void run() {
            System.out.println("Walk slowly");

        }


        @Override
        public void gainExperience() {
            experience += 15;
        }

        @Override
        public int getHealth() {
            return health;
        }

        @Override
        public String getName() {

            return name;
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
        public void setHealth(int health) {
            this.health += health;
        }


        public void reload() {
            if (this.weapon.getAmmo() == 0) {
                System.out.println();
                System.out.println("*RELOAD*");
                this.weapon.setAmmo(Constants.GAUSS_AMMO);
                System.out.println("Ammo: " + this.weapon.getAmmo() + "\n");
            }

        }
    }


