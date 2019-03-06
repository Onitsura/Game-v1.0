package Guns;

import Game.Constants;

    public class GaussGun extends FireArms {

        private int ammo;
        private int needExperience = 40;
        private int damage = 70;

        public GaussGun() {
            ammo = Constants.GAUSS_AMMO;
        }

        @Override
        public boolean accuracy() {
            int x = (r.nextInt(3) + 1) % 2;
            if (x != 0 == true) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public void setAmmo(int ammo) {
            this.ammo = ammo;
        }

        @Override
        public int doDamage() {
            if (this.accuracy() == true) {
                ammo--;
                return damage;
            } else {
                System.out.println("*MISS* \n");
                ammo--;
                return 0;
            }
        }


        @Override
        public int getExperience() {

            return needExperience;
        }

        public int getDamage() {
            return damage;
        }


        @Override
        public int getAmmo() {

            return ammo;
        }


    }
