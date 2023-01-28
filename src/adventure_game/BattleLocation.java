package adventure_game;

import java.util.Scanner;

//Battle Location ---> "Forest", "Cave" and "River"
public class BattleLocation extends Location {
    protected Obstacle obstacle;
    protected String award;

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
        for (int i=0; i<obstacleCount; i++) {
            int defObstacleHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealth()>0 && obstacle.getHealth()>0) {
                System.out.print("Hit<H> or Escape<E>:");
                String selectCase = input.nextLine();
                selectCase = selectCase.toUpperCase();
                if (selectCase.equals("H")) {
                    System.out.println("You hit!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth()>0) {
                        System.out.println();
                        System.out.println("Monster hit you!");
                        player.setHealthy(player.getHealth() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        afterHit();
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
