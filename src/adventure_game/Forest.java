package adventure_game;

public class Forest extends BattleLocation {

    Forest(Player player) {
        super(player, "Forest", new Vampire(), "Firewood");
    }

}
