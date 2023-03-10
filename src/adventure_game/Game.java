package adventure_game;

import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    Player player;
    Location location;

    public void login() {
        System.out.println("********** Welcome to Adventure Game **********");
        System.out.println("Enter your name before starting the game: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        player.selectCharacter();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("=================================================");
            System.out.println();
            System.out.println("Information about locations: ");
            System.out.println("1.SAFE HOUSE ---> Your own safe location, no enemy!");
            System.out.println("2.CAVE ---> You may come across zombies!");
            System.out.println("3.FOREST ---> You may come across vampire!");
            System.out.println("4.RIVER ---> You may come across bear!");
            System.out.println("5.MINE ---> You may come across snake!");
            System.out.println("6.TOOL STORE ---> You can buy Weapon or Armor!");
            System.out.print("Select a location to perform an action: ");

            int selectLocation = input.nextInt();
            while (selectLocation<0 || selectLocation>5) {
                System.out.print("Please select a valid location: ");
                selectLocation = input.nextInt();
            }

            switch (selectLocation) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    if(!player.getInventory().isFood()) {
                        location = new Cave(player);
                    } else {
                        System.out.println("You won the Cave location award");
                    }
                    break;
                case 3:
                    if(!player.getInventory().isFirewood()) {
                        location = new Forest(player);
                    } else {
                        System.out.println("You won the Forest location award");
                    }
                    break;
                case 4:
                    if(!player.getInventory().isWater()) {
                        location = new River(player);
                    } else {
                        System.out.println("You won the River location award");
                    }
                    break;
                case 5:
                    if(!player.getInventory().isMine()) {
                        location = new Mine(player);
                    } else {
                        System.out.println("You entered Mine location");
                    }
                    break;
                case 6:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location.getName().equals("Safe House")) {
                if (player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
                    System.out.println("Congratulations you won the game!");
                    break;
                }
            }

            if(selectLocation==2 && !player.getInventory().isFood()) {
                if (!location.getLocation()) {
                    System.out.println("GAME FINISHED!");
                    break;
                }
            } else if(selectLocation==3 && !player.getInventory().isFirewood()) {
                if (!location.getLocation()) {
                    System.out.println("GAME FINISHED!");
                    break;
                }
            } else if(selectLocation==4 && !player.getInventory().isWater()) {
                if (!location.getLocation()) {
                    System.out.println("GAME FINISHED!");
                    break;
                }
            } else if(selectLocation==5 && !player.getInventory().isMine()) {
                if (!location.getLocation()) {
                    System.out.println("GAME FINISHED!");
                    break;
                }
            }
        }
    }
}
