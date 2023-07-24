package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.standardactions.ConsumeAction;
import game.enums.StatusEffect;
import game.interfaces.Consumable;
import game.utils.StatusEffectManager;

/**
 * A bolus which, when consumed, cures the consumer of Scarlet Rot.
 * It is a one-time use item.
 * [Creative requirement]
 *
 * @see ConsumeAction
 * @see Consumable
 *
 * Created by:
 * @author Nisha Kannapper
 */
public class PreservingBolus extends ConsumableItem {

    /***
     * Constructor.
     */
    public PreservingBolus() {
        super("Preserving Bolus", ',', true);
    }

    @Override
    public void consume(Actor actor) {
        StatusEffectManager.removeStatusEffect(actor, StatusEffect.SCARLET_ROT);
        actor.removeItemFromInventory(this);
    }

    @Override
    public String getConsumeMessage() {
        return " be free from the scarlet rot.";
    }

    @Override
    public String getMenuMessage() {
        return "(Cures Scarlet Rot)";
    }
    
}
