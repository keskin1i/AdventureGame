package adventureGame;

import java.util.Scanner;

public class Game {
    private Scanner inp=new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz.");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName=inp.next();
        Player player=new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli oyuna Hoşgeldin. Burda yaşananların hepsi gerçek.");
        System.out.println("Oyuna başlamak için bir karakter seçiniz.");
        player.selectChar();

        Location location=null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("##########Bölgeler###########");
            System.out.println();
            System.out.println("1.Güvenli Ev --> Burası sizin için güvenli ev.burada düşman yok.");
            System.out.println("2.Eşya Dükkanı --> Burada mühimmat satın alabilirsiniz.");
            System.out.println("3.Mağara --> Ödül<Yemek>. Dikkatli ol! zombi çıkabilir.");
            System.out.println("4.Orman --> Ödül<Odun>. Dikkatli ol! vampir çıkabilir. ");
            System.out.println("5.Nehir --> Ödül<Su>. Dikkatli ol! ayı çıkabilir.");
            System.out.println("0.Çıkış yap --> Oyunu sonlandır.");
            System.out.print("Gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc=inp.nextInt();
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Geçerli bir bölge seçiniz!");
            }
            if (location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin :) ");
                break;
            }
            if (!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }

        }

    }
}
