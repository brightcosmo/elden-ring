package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.StatusEffect;
import game.enums.StatusEffectStrength;

/**
 * Carries out the effects of status effects.
 * Used in Creative Requirement
 * @see game.enums.StatusEffect
 * @see game.enums.StatusEffectStrength
 *
 * Created by:
 * @author Nisha Kannapper
 */
public class StatusEffectManager {

    /**
     * Executes a series of actions depending on whether an actor has a status effect and the strength of the status effect
     * @param actor actor affected by status effect
     * @param gameMap map where actor is located
     * @param maxHp maximum hp of the actor
     */
    public static void executeStatusEffect(Actor actor, GameMap gameMap, int maxHp) {

        if (gameMap.locationOf(actor).getGround().hasCapability(StatusEffect.SCARLET_ROT) && !(actor.hasCapability(StatusEffect.SCARLET_ROT))){
            actor.addCapability(StatusEffect.SCARLET_ROT);
            actor.addCapability(StatusEffectStrength.HIGH);
        }

        if (actor.hasCapability(StatusEffect.SCARLET_ROT)){
            if (actor.hasCapability(StatusEffectStrength.HIGH)){
                actor.hurt((int)(maxHp*0.2));

                if (!(gameMap.locationOf(actor).getGround().hasCapability(StatusEffect.SCARLET_ROT))){
                    actor.removeCapability(StatusEffectStrength.HIGH);
                    actor.addCapability(StatusEffectStrength.MEDIUM);
                }

            }
            else if (actor.hasCapability(StatusEffectStrength.MEDIUM)){
                actor.hurt((int)(maxHp*0.1)+5);
                actor.removeCapability(StatusEffectStrength.MEDIUM);

                if (gameMap.locationOf(actor).getGround().hasCapability(StatusEffect.SCARLET_ROT)){
                    actor.addCapability(StatusEffectStrength.HIGH);
                } else {
                    actor.addCapability(StatusEffectStrength.LOW);
                }
            }
            else if (actor.hasCapability(StatusEffectStrength.LOW)){
                actor.hurt((int)(maxHp*0.05)+10);
                actor.removeCapability(StatusEffectStrength.LOW);

                if (gameMap.locationOf(actor).getGround().hasCapability(StatusEffect.SCARLET_ROT)){
                    actor.addCapability(StatusEffectStrength.HIGH);
                } else {
                    actor.removeCapability(StatusEffect.SCARLET_ROT);
                }

            }
        }
    }

    /**
     * Adds a status effect to an actor
     * @param actor the actor who the status effect should be added to
     * @param statusEffect the status effect to be added
     */
    public static void addStatusEffect(Actor actor, StatusEffect statusEffect){

        if (actor.hasCapability(statusEffect)){
            actor.removeCapability(statusEffect);}

        if (actor.hasCapability(StatusEffectStrength.HIGH)){
            actor.removeCapability(StatusEffectStrength.HIGH);}

        else if (actor.hasCapability(StatusEffectStrength.MEDIUM)){
            actor.removeCapability(StatusEffectStrength.MEDIUM);}

        else if (actor.hasCapability(StatusEffectStrength.LOW)){
            actor.removeCapability(StatusEffectStrength.LOW);}

        switch (statusEffect){
            case SCARLET_ROT:
                actor.addCapability(StatusEffect.SCARLET_ROT);
                actor.addCapability(StatusEffectStrength.HIGH);
                break;

            default:
                break;
        }

    }

    /**
     * Removes a status effect from an actor
     * @param actor the actor who the status effect should be removed from
     * @param statusEffect the status effect to be removed
     */
    public static void removeStatusEffect(Actor actor, StatusEffect statusEffect){

        if (!(actor.hasCapability(statusEffect))){return;}

        switch (statusEffect){
            case SCARLET_ROT:
                actor.removeCapability(StatusEffect.SCARLET_ROT);
                break;

            default:
                break;
        }

        if (actor.hasCapability(StatusEffectStrength.HIGH)){
            actor.removeCapability(StatusEffectStrength.HIGH);}

        else if (actor.hasCapability(StatusEffectStrength.MEDIUM)){
            actor.removeCapability(StatusEffectStrength.MEDIUM);}

        else if (actor.hasCapability(StatusEffectStrength.LOW)){
            actor.removeCapability(StatusEffectStrength.LOW);}

    }
}
