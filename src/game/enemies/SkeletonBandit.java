package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Species;
import game.weapons.Grossmesser;
import game.weapons.Scimitar;

/**
 * An enemy that represents a Skeletal bandit
 * spawns from graveyard on the west east of the map and is capable of performing a spinning attack with its scimitar
 * won't attack other skeletons
 * @see game.actions.skills.SpinningAttack
 * @see game.environments.Graveyard
 * @see Scimitar
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class SkeletonBandit extends SkeletalEnemy {

    /**
     * Constructor.
     * @param map the map that the enemy is on
     */
    public SkeletonBandit(GameMap map) {
        super("Skeleton Bandit", 'b', 184, Species.SKELETAL, map);
        addWeaponToInventory(new Scimitar());
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public SkeletalEnemy getNewSkeleton(GameMap map) {
        return EnemyFactory.createSkeletonBandit(map);
    }
}
