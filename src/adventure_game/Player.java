package adventure_game;

import java.util.Scanner;

public class Player {
    private int damage, healthy, money, rHealthy;
    private String name, characterName;
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter() {
        System.out.println("Information of characters: ");
        System.out.println("1-Samurai ---> Damage: 5 - Health(Strength): 21 - Money: 15");
        System.out.println("2-Archer ---> Damage: 7 - Health(Strength): 18 - Money: 20");
        System.out.println("3-Knight ---> Damage: 8 - Health(Strength): 24 - Money: 5");
        System.out.print("Choose a character: ");

        int characterID = input.nextInt();

        while (characterID<1 || characterID>3) {
            System.out.print("Please enter a valid character id: ");
            characterID = input.nextInt();
        }

        switch (characterID) {
            case 1:
                initPlayer("Samurai", 5, 21, 15);
                break;
            case 2:
                initPlayer("Archer", 7, 18, 20);
                break;
            case 3:
                initPlayer("Knight", 8, 24, 5);
                break;
            default:
                initPlayer("Samurai", 5, 21, 15);
                break;
        }
        System.out.println("The character has been created.! " +
                "\nCharacter name: " + getCharacterName() +
                "\nDamage: " + getDamage() +
                "\nHealth: " + getHealth() +
                "\nMoney: " + getMoney());
    }

    public void initPlayer(String characterName, int damage, int healthy, int money) {
        setCharacterName(characterName);
        setDamage(damage);
        setHealthy(healthy);
        setMoney(money);
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
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

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
