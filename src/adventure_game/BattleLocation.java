package adventure_game;

import java.util.Random;
import java.util.Scanner;

//Battle Location ---> "Forest", "Cave" and "River"
public class BattleLocation extends Location {
    protected Obstacle obstacle;
    protected String award;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    BattleLocation(Player player, String locationName, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = locationName;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        int obstacleCount = obstacle.count();
        System.out.println("You are now in " + this.getName() + " location.");
        System.out.println("Be careful! " + obstacleCount + " " + obstacle.getName() + "s live here!");
        System.out.print("Fight<F> or Escape<E>: ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")) {
            if (combat(obstacleCount)) {
                System.out.println("You cleared all the enemies in the " + this.getName() + " location.");
                if (this.award.equals("Food") && !player.getInventory().isFood()) {
                    System.out.println("You won " + this.award);
                    player.getInventory().setFood(true);
                } else if (this.award.equals("Water") && !player.getInventory().isWater()) {
                    System.out.println("You won " + this.award);
                    player.getInventory().setWater(true);
                } else if (this.award.equals("Firewood") && !player.getInventory().isFirewood()) {
                    System.out.println("You won " + this.award);
                    player.getInventory().setFirewood(true);
                } else if(this.award.equals("") && !player.getInventory().isMine()) {
                    String[] mineArray = new String[]{"Money", "Weapon", "Armor", ""};
                    int number = (int) (rand.nextInt(3));
                    if(mineArray[number].equals("Money")) {
                        int[] moneyArray = new int[]{10, 5, 1};
                        number = (int) (rand.nextInt(2));
                        if (player.getMoney()>0) {
                            player.setMoney(player.getMoney()-moneyArray[number]);
                            System.out.println("You lost money");
                            playerStats();
                        }
                    } else if (mineArray[number].equals("Weapon")) {
                        //String[] weaponArray = new String[]{"Revolver", "Sword", "Rifle"};
                        //number = (int) (rand.nextInt(2));
                        //playerSetMoney = player.getMoney + weaponPrice
                        if(player.getInventory().getWeaponName() != null) {
                            player.getInventory().setWeaponName(null);
                            System.out.println("You lost weapon");
                        }
                    } else if (mineArray[number].equals("Armor")) {
                        //String[] armorArray = new String[]{"Slight", "Middle", "Heavy"};
                        //number = (int) (rand.nextInt(2));
                        //playerSetMoney = player.getMoney + armorPrice
                        if(player.getInventory().getArmorName() != null) {
                            player.setHealth(player.getHealth()-player.getInventory().getArmor());
                            player.getInventory().setArmorName(null);
                            System.out.println("You lost armor");
                        }
                    } else {
                        System.out.print("You haven't lost any mines.");
                    }
                    player.getInventory().setMine(true);
                }
                return true;
            }
            if(player.getHealth()<=0) {
                System.out.println("You died!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obstacleCount) {
        int randomStart = (int) ((Math.random() * 2));
        for (int i=0; i<obstacleCount; i++) {
            int defObstacleHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealth()>0 && obstacle.getHealth()>0) {
                System.out.print("Hit<H> or Escape<E>:");
                String selectCase = input.nextLine();
                selectCase = selectCase.toUpperCase();
                if (selectCase.equals("H")) {
                    if(randomStart==1) {
                        System.out.println("Start from player");
                        System.out.println("You hit!");
                        obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                        afterHit();
                        if (obstacle.getHealth()>0) {
                            System.out.println();
                            System.out.println("Monster hit you!");
                            player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInventory().getArmor()));
                            afterHit();
                        }
                    } else {
                        System.out.println("Start from monster");
                        System.out.println("Monster hit you!");
                        player.setHealth(player.getHealth() - obstacle.getDamage());
                        afterHit();
                        if(player.getHealth()>0) {
                            System.out.println();
                            System.out.println("You hit!");
                            obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }
            if (obstacle.getHealth()<player.getHealth()) {
                System.out.println("You beat enemy!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Your current money: " + player.getMoney());
                obstacle.setHealth(defObstacleHealth);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Player values --->");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Damage: " + player.getTotalDamage());
        System.out.println("Money: " + player.getMoney());
        if (player.getInventory().getDamage()>0) {
            System.out.println("Weapon:" + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getArmor() > 0) {
            System.out.println("Armor:" + player.getInventory().getArmorName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Values --->");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Award: " + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Player health: " + player.getHealth());
        System.out.println(obstacle.getName() + " health: " + obstacle.getHealth());
        System.out.println();
    }

}
