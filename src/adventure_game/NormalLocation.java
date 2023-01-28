package adventure_game;

//Normal Location ---> "Safe House" and "Tool Store"
public abstract class NormalLocation extends Location {
    NormalLocation(Player player, String name) {
        super(player);
        this.name = name;
    }

    public boolean getLocation() {
        return true;
    }

}
