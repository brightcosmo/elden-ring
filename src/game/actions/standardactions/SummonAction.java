package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.EnemyFactory;
import game.npcs.Ally;
import game.npcs.Invader;
import game.npcs.NpcManager;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * An action that allows the player to summon an NPC.
 * @see game.npcs.Invader
 * @see game.npcs.Ally
 * @see game.environments.SummonSign
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class SummonAction extends Action {
    /**
     * The location of the summon sign
     */
    Location summonLocation;

    /**
     * Constructor
     * @param summonLocation the location of the summon sign
     */
    public SummonAction(Location summonLocation){
        this.summonLocation = summonLocation;
    }
    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // get possible spawn locations (the summon sign itself and all of its exits)
        ArrayList<Location> validSpawns = new ArrayList<>();

        if (summonLocation.canActorEnter(actor)) {
            validSpawns.add(summonLocation);
        }

        for (Exit exit: summonLocation.getExits()){
            if (exit.getDestination().canActorEnter(actor)) {
                validSpawns.add(exit.getDestination());
            }
        }

        // no valid exit
        if (validSpawns.isEmpty()){
            return "There is no space to summon";
        }

        Location spawn = validSpawns.get(RandomNumberGenerator.getRandomInt(validSpawns.size()));

        Actor summoned;
        if (RandomNumberGenerator.getRandomInt(2) == 1) {
            summoned = NpcManager.generateAlly(map);
        }
        else{
            summoned = EnemyFactory.generateInvader(map);
        }
        map.addActor(summoned, spawn);
        return "A new " + summoned + " has been summoned!";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses the summoning sign";
    }
}
