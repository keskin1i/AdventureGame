package adventureGame;

import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
   public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Şuan buradasınız: "+this.getName());
        System.out.println("Dikkatli ol burada "+obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor.");
        System.out.print("<Savaş> veya <K>aç : ");
        String selectCase=inp.next().toUpperCase();
        if (selectCase.equals("S")){
            if (combat(obsNumber)){
                System.out.println(this.getName()+" tüm düşmanları yendiniz.");
                return true;

            }

        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for (int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() >= 0 && this.getObstacle().getHealth() >= 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat=inp.next().toUpperCase();
                if (selectCombat.equals("v")){
                    System.out.println("Siz vurdunuz!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage=this.getObstacle().getDamage()-getPlayer().getInvertory().getArmor().getBlock();
                        if (obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();


                    }

                }else {
                    return false;
                }
                return true;


            }
            if (this.getObstacle().getHealth()<getPlayer().getHealth()){

                System.out.println("Tebrikler... Düşmanı yendiniz.");
                System.out.println(this.getObstacle().getAward()+" para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Canınız: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" canı: "+getObstacle().getHealth());
        System.out.println("---------------");
    }
    public void playerStats(){
        System.out.println("Oyuncu değerleri.");
        System.out.println("-------------------------------");
        System.out.println("Sağlık: "+this.getPlayer().getHealth());
        System.out.println("Silah: "+this.getPlayer().getInvertory().getWeapon().getName());
        System.out.println("Zırh: "+this.getPlayer().getInvertory().getArmor().getName());
        System.out.println("Bloklama: "+this.getPlayer().getInvertory().getArmor().getBlock());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());
        System.out.println("Para: "+this.getPlayer().getMoney());
        System.out.println();

    }
    public void obstacleStats(int i){
        System.out.println(i+"."+this.getObstacle().getName()+" değerleri.");
        System.out.println("----------------------");
        System.out.println("Sağlık: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+this.getObstacle().getDamage());
        System.out.println("Ödül: "+this.getObstacle().getAward());
        System.out.println();
    }
    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.maxObstacle)+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
