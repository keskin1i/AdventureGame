package adventureGame;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner inp=new Scanner(System.in);
    private Invertory invertory;

    public Player(String name){
        this.name=name;
        this.invertory=new Invertory();
        this.orjinalHealth=health;
    }
    public void selectChar(){
       GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Karakterler");
        System.out.println("---------------------------------------------------------------------");
        for (GameChar gameChar:charList) {
            System.out.println("ID: "+gameChar.getId()+
                    "\t Karakter: "+gameChar.getName()+
                    "\t Hasar: " +gameChar.getDamage()+
                    "\t Sağlık: " +gameChar.getHealth()+
                    "\t Para: " +gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Bir karakter seçiniz: ");
        int selectChar=inp.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }

        /*System.out.println("Karakter: "
                +this.getCharName()+
                ", Hasar: "+getDamage()+
                ", Sağlık: "+getHealth()+
                ", Para: "+getMoney());

         */
    }


    public void initPlayer(GameChar gameChar){
       this.setDamage(gameChar.getDamage());
       this.setHealth(gameChar.getHealth());
       this.setOrjinalHealth(gameChar.getHealth());
       this.setMoney(gameChar.getMoney());
       this.setCharName(gameChar.getName());
    }
    public void printInfo(){

        System.out.println("Silahınız: "+this.getInvertory().getWeapon().getName()+
                ", Zırh: "+this.getInvertory().getArmor().getName()+
                ", Bloklama: "+this.getInvertory().getArmor().getBlock()+
                ", Hasarınız: "+getTotalDamage()+
                ", Sağlık: "+getHealth()+
                ", Para: "+getMoney());
    }
    public int getTotalDamage(){
        return damage + getInvertory().getWeapon().getDamage();
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Invertory getInvertory() {
        return invertory;
    }

    public void setInvertory(Invertory invertory) {
        this.invertory = invertory;
    }

    public Weapon getWeapon(){
        return this.getInvertory().getWeapon();
    }
    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public Scanner getInp() {
        return inp;
    }

    public void setInp(Scanner inp) {
        this.inp = inp;
    }
}
