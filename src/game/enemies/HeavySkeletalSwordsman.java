package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Species;
import game.weapons.GiantDogHead;
import game.weapons.Grossmesser;

/**
 * An enemy that represents a Heavy skeletal swordsman
 * spawns from graveyard on the west side of the map and is capable of performing a spinning attack with its grossmesser
 * won't attack other skeletons
 * @see game.actions.skills.SpinningAttack
 * @see game.environments.Graveyard
 * @see Grossmesser
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class HeavySkeletalSwordsman extends SkeletalEnemy {

    /**
     * Constructor.
     * @param map the map that the enemy is on
     */
    public HeavySkeletalSwordsman(GameMap map) {
        super("Heavy Skeletal Swordsman", 'q', 153, Species.SKELETAL, map);
        addWeaponToInventory(new Grossmesser());
    }

    @Override
    public SkeletalEnemy getNewSkeleton(GameMap map) {
        return EnemyFactory.createHeavySkeletalSwordsman(map);
    }
}
