package adventure_game;

public class SafeHouse extends NormalLocation {

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean getLocation() {
        player.setHealth(player.getHealth());
        System.out.println("Get Well!");
        System.out.println("You are now in \"Safe House\" location");
        return true;
    }

}
