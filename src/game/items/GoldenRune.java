package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.standardactions.ConsumeAction;
import game.enums.ItemStatus;
import game.interfaces.Consumable;
import game.runes.RuneManager;
import game.utils.RandomNumberGenerator;

/**
 * A golden rune which, when consumed, gives player a random amount of runes.
 * It is a one-time use item.
 *
 * @see ConsumeAction
 * @see Consumable
 *
 * Created by:
 * @author Nisha Kannapper
 */
public class GoldenRune extends ConsumableItem {

    int value;

    /***
     * Constructor.
     */
    public GoldenRune() {
        super("Golden Rune", '*', true);
        this.value = RandomNumberGenerator.getRandomInt(200,10000);
    }

    @Override
    public void consume(Actor actor) {
        RuneManager.addPlayerRunes(this.value);
        actor.removeItemFromInventory(this);
    }

    @Override
    public String getConsumeMessage() {
        return "produce " + this.value + " runes.";
    }

    @Override
    public String getMenuMessage() {
        return "(Produces " + this.value + " runes)";
    }



}
