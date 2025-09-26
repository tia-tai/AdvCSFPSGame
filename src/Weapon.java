import java.util.ArrayList;

public class Weapon {
    private String weaponName;
    private boolean shooting;
    private int magazineNumber;
    private int maxBullets;
    private int bulletCount;
    private int damage;
    private boolean inspection;
    private int viewDirection;
    private float accuracy;
    private Character sight;


    public Weapon(String weaponName, boolean shooting, int magazineNumber, int maxBullets, int bulletCount, int damage, boolean inspection, float accuracy){
        this.weaponName = weaponName;
        this.shooting = shooting;
        this.magazineNumber = magazineNumber;
        this.maxBullets = maxBullets;
        this.bulletCount = bulletCount;
        this.damage = damage;
        this.inspection = inspection;
        this.viewDirection = viewDirection;
        this.accuracy = accuracy;
        this.sight = sight;
    }

    void aimDownSights() {
        System.out.println(weaponName + " is being aimed.");

    }

    void inspect(boolean right){
        if (right) {
            viewDirection = viewDirection + 4;
        } else {
            viewDirection = viewDirection - 4;
        }
        System.out.println(weaponName + " weapon changes direction to: " + viewDirection);
    }




    void reload(){
        if (shooting) {
            if ((bulletCount < 1) && (magazineNumber > 0)) {
                System.out.println(weaponName + " is having mag emptied and replaced.");
                bulletCount = maxBullets;
                magazineNumber = magazineNumber - 1;
            } else {
                System.out.println(weaponName + " can't be reloaded.");

            }
        } else {
            System.out.println(weaponName + " doesn't need reloaded.");
        }
    }

    void fire(Player owner) {


    }
}






