package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.enums.StatusEffect;
import game.utils.StatusEffectManager;

public class RotPuddle extends Ground {

    /**
     * Constructor.
     */
    public RotPuddle() {
        super('/');
        this.addCapability(StatusEffect.SCARLET_ROT);
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()) { // check if the location contains an actor
            if (location.getActor().hasCapability(Status.CAN_HAVE_DEBUFF)){
                StatusEffectManager.addStatusEffect(location.getActor(), StatusEffect.SCARLET_ROT);
            }
        }
    }
}
