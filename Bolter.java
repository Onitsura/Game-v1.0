package Guns;

import Game.Constants;

    public class Bolter extends FireArms {

        int ammo = Constants.BOLTER_AMMO;
        int damage = Constants.BOLTER_DAMAGE;
        int needExperience = 10;


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
            if (this.accuracy() == true) {
                ammo--;
                return damage;
            } else {
                System.out.println("*MISS*\n");
                ammo--;
                return 0;
            }
        }

        @Override
        public boolean accuracy() {
            int x = (Constants.RANDOM.nextInt(2) + 1) % 2;
            if (x != 0 == true) {

                return true;
            } else {

                return false;
            }
        }

        @Override
        public int getAmmo() {
            return ammo;
        }

        @Override
        public void setAmmo(int ammo) {
            this.ammo = ammo;
        }
    }
