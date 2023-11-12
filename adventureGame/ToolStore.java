package adventureGame;

import java.util.SortedMap;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz.");
        boolean showMenu=true;
       while (showMenu){
           System.out.println("1.Silah");
           System.out.println("2.Zırh");
           System.out.println("3.Çıkış yap");
           System.out.print("Seçiminiz: ");
           int selectCase=inp.nextInt();
           while (selectCase<1||selectCase>3){
               System.out.print("Geçersiz seçim yaptınız,tekrar seçim yapınız: ");
               selectCase=inp.nextInt();
           }
           switch (selectCase){
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("Birdaha bekleriz.");
                   showMenu=false;
                   break;
           }
       }
        return true;
    }
    public void printWeapon(){
        System.out.println("----------Silahlar------------");
        for (Weapon w:Weapon.weapons()) {
            System.out.println(w.getId()+"-"+w.getName()+" <Para: "+w.getPrice()+", Hasar: "+w.getDamage()+" >");
        }
        System.out.println("Çıkış yapmak için '0' basınız.");

    }
    public void buyWeapon(){
        System.out.print("Bir silah seçiniz: ");
        int selectWeapon=inp.nextInt();
        while (selectWeapon<0||selectWeapon>Weapon.weapons().length){
            System.out.print("Geçersiz seçim yaptınız,tekrar seçim yapınız: ");
            selectWeapon=inp.nextInt();
        }
       if (selectWeapon != 0){
           Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);
           if (selectedWeapon != null){
               if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                   System.out.println("Bakiyeniz yeterli değildir.");
               }else{
                   //Satın alma işlemlerini yaptığımız yer
                   System.out.println(selectedWeapon.getName()+" silahını satın aldınız.");
                   int balance= getPlayer().getMoney()-selectedWeapon.getPrice();
                   this.getPlayer().setMoney(balance);
                   System.out.println("Kalan paranız: "+this.getPlayer().getMoney());
                   this.getPlayer().getInvertory().setWeapon(selectedWeapon);
               }
           }
       }
    }
    public void printArmor(){

        System.out.println("----------Zırhlar------------");
        for (Armor a:Armor.armors()) {
            System.out.println(a.getId()+"-"+a.getName()+" <Para: "+a.getPrice()+", Zırh: "+a.getBlock()+" >");
        }
        System.out.println("Çıkış yapmak için '0' basınız.");
    }
    public void buyArmor(){

        System.out.print("Bir zırh seçiniz: ");
        int selectArmorId=inp.nextInt();
        while (selectArmorId<0||selectArmorId>Armor.armors().length){
            System.out.print("Geçersiz seçim yaptınız,tekrar seçim yapınız: ");
            selectArmorId=inp.nextInt();
        }
        if (selectArmorId!=0){
            Armor selectedArmor = Armor.getArmorById(selectArmorId);
            if (selectedArmor != null){
                if (selectedArmor.getPrice()>getPlayer().getMoney()){
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                }else {
                    System.out.println(selectedArmor.getName()+" zırhını satın aldınız.");
                    this.getPlayer().getInvertory().setArmor(selectedArmor);
                    this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                    System.out.println("Kalan bakiyeniz: "+this.getPlayer().getMoney());

                }
            }
        }
    }


    }


