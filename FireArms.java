
package Guns;

import java.util.Random;

    public abstract class FireArms implements IGuns {
        int ammo;
        int damage;
        int needExpierence;
        Random r = new Random();


        public abstract boolean accuracy();
        public abstract int getAmmo();
        public abstract void setAmmo(int ammo);
	
	
}
