package adventure_game;

import java.util.Scanner;

public class ToolStore extends NormalLocation {
    Scanner input = new Scanner(System.in);

    ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean getLocation() {
        System.out.println("Money: " + player.getMoney());
        System.out.println("1.Weapons");
        System.out.println("2.Armors");
        System.out.println("3.Exit");
        System.out.print("You choice: ");
        int selectTool = input.nextInt();
        int selectItemID;
        switch (selectTool) {
            case 1:
                selectItemID = weaponMenu();
                buyWeapon(selectItemID);
                break;
            case 2:
                selectItemID = armorMenu();
                buyArmor(selectItemID);
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu() {
        System.out.println("1.Revolver (Money: 25 - Damage: 2)"); //tabanca
        System.out.println("2.Sword (Money: 35 - Damage: 3)"); //kılıç
        System.out.println("3.Rifle (Money: 45 - Damage: 7)"); //tüfek
        System.out.println("4.Exit");
        System.out.print("Choose a weapon: ");
        int selectWeaponID = input.nextInt();
        return selectWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String weaponName = null;
        switch(itemID) {
            case 1:
                weaponName = "Revolver";
                damage = 2;
                price = 25;
                break;
            case 2:
                weaponName = "Sword";
                damage = 3;
                price = 35;
                break;
            case 3:
                weaponName = "Rifle";
                damage = 7;
                price = 45;
                break;
            case 4:
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Invalid transaction!");
                break;
        }

        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setWeaponName(weaponName);
                player.getInventory().setDamage(damage);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought " + weaponName + ". Previous damage: " + player.getDamage() + ", New damage: "
                        + player.getTotalDamage());
                System.out.println("Remaining money:" + player.getMoney());
            } else {
                System.out.println("Not enough money!");
            }
        }
    }

    public int armorMenu() {
        System.out.println("1.Slight (Money: 15 - Damage: 1)");
        System.out.println("2.Middle (Money: 25 - Damage: 3)");
        System.out.println("3.Heavy (Money: 40 - Damage: 5)");
        System.out.println("4.Exit");
        System.out.print("Choose a armor: ");
        int selectArmorID = input.nextInt();
        return selectArmorID;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String armorName = null;
        switch (itemID) {
            case 1:
                armorName = "Slight Armor";
                avoid = 1;
                price = 15;
                break;
            case 2:
                armorName = "Middle Armor";
                avoid = 3;
                price = 25;
                break;
            case 3:
                armorName = "Heavy Armor";
                avoid = 5;
                price = 40;
                break;
            case 4:
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Invalid transaction!");
                break;
        }

        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmorName(armorName);
                player.getInventory().setArmor(avoid);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought " + armorName + ". Blocked damage: " + player.getInventory().getArmor());
                System.out.println("Remaining money:" + player.getMoney());
            } else {
                System.out.println("Not enough money!");
            }
        }
    }

}
