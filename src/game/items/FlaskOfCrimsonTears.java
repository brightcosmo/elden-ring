package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.standardactions.ConsumeAction;
import game.interfaces.Consumable;
import game.resettables.ResetEvent;
import game.resettables.ResetManager;
import game.resettables.Resettable;

/**
 * A flask which the player owns, that can be consumed to heal a certain amount.
 * The flask has a limited number of uses.
 *
 * @see game.actions.standardactions.ConsumeAction
 * @see Consumable
 * @see game.resettables.Resettable
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class FlaskOfCrimsonTears extends ConsumableItem implements Resettable {

    /**
     * The current number of uses remaining for the flask
     */
    private int uses;

    /**
     * The amount to heal the player by
     */
    private int healAmount = 250;

    /**
     * The maximum number of uses for the flask
     */
    private int maxUses = 2;

    /**
     * The single instance of the flask
     */
    private static FlaskOfCrimsonTears instance;

    /**
     * Constructor
     */
    private FlaskOfCrimsonTears(){
        super("Flask of Crimson Tears", ' ', false);
        this.uses = maxUses;
    }

    /**
     * Return the existing instance of Flask, if it exists
     * Otherwise, create a new Flask and register it as a resettable
     */
    public static FlaskOfCrimsonTears getInstance(){
        if (instance == null){
            instance = new FlaskOfCrimsonTears();
            ResetManager.getInstance().registerResettable(instance);
        }
        return instance;
    }

    /**
     * Check if the flask can still be consumed
     * @return true if there is at least 1 use remaining, false otherwise
     */
    public boolean isConsumable(){
        return this.uses > 0;
    }

    /**
     * Consume the flask, taking up 1 "use" and healing the actor
     * @param actor The actor consuming the item
     */
    public void consume(Actor actor){
            this.uses -= 1;
            actor.heal(healAmount);
    }

    /**
     * A message for the ConsumeAction
     * @return A string describing the effect to the actor
     */
    public String getConsumeMessage(){
            return "heal for " + this.healAmount;
    }

    /**
     * A message for the ConsumeAction
     * @return A string describing the action to be performed
     */
    public String getMenuMessage(){
        return "(" + this.uses + " use" + (this.uses == 1 ? "" : "s") + " remaining)";
    }

    /**
     * Reset the flask by restoring the max number of uses
     */
    public void reset(ResetEvent trigger){
        this.uses = maxUses;
    }

    /**
     * Adds a specific amount of uses to the maximum uses of the flask.
     * @param uses number of uses to increase the limit by
     */
    public void addMaxUses(int uses) {
        this.maxUses += uses;
    }

    /**
     * Adds a specific amount of healing to the heal amount of the flask.
     * @param healAmount amount to increase healing by
     */
    public void addHealAmount(int healAmount){this.healAmount += healAmount;}

    public void tick(Location currentLocation, Actor actor) {

        removeAction(getConsumeAction());

        if (isConsumable()) {
            ConsumeAction consumeAction = new ConsumeAction(this);
            setConsumeAction(consumeAction);
            addAction(consumeAction);
        }
    }
}
