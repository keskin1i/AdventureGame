package adventureGame;

public class Invertory {

   private Weapon weapon;
   private Armor armor;

    public Invertory(){
       this.weapon=new Weapon("yumruk",-1,0,0);
       this.armor=new Armor(-1,"paçavra",0,0);
   }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
