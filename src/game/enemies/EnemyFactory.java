package game.enemies;
import edu.monash.fit2099.engine.positions.GameMap;
import game.npcs.Invader;
import game.combatclasses.CombatClass;
import game.resettables.ResetManager;
import game.utils.CombatClassMenu;

/**
 * A factory for enemies, allows us to abstract the responsibility of creating enemies into a seperate class
 * @see Enemy
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */

public class EnemyFactory {

    /**
     * Creates a new giant crab instance
     * @param map the map that the enemy is on
     * @return new giant crab enemy
     */
    public static GiantCrab createGiantCrab(GameMap map) {
        GiantCrab gc = new GiantCrab(map);
        ResetManager.getInstance().registerResettable(gc);
        return gc;
    }

    /**
     * Creates a new giant crayfish instance
     * @param map the map that the enemy is on
     * @return new giant crayfish enemy
     */
    public static GiantCrayfish createGiantCrayfish(GameMap map) {
        GiantCrayfish gcf = new GiantCrayfish(map);
        ResetManager.getInstance().registerResettable(gcf);
        return gcf;
    }

    /**
     * Creates a new giant dog instance
     * @param map the map that the enemy is on
     * @return new giant dog enemy
     */
    public static GiantDog createGiantDog(GameMap map) {
        GiantDog gd = new GiantDog(map);
        ResetManager.getInstance().registerResettable(gd);
        return gd;
    }

    /**
     * Creates a new heavy skeletal swordsman instance
     * @param map the map that the enemy is on
     * @return new heavy skeletal swordsman enemy
     */
    public static HeavySkeletalSwordsman createHeavySkeletalSwordsman(GameMap map) {
        HeavySkeletalSwordsman hs = new HeavySkeletalSwordsman(map);
        ResetManager.getInstance().registerResettable(hs);
        return hs;
    }

    /**
     * Creates a new skeletal bandit instance
     * @param map the map that the enemy is on
     * @return new skeletal bandit enemy
     */
    public static SkeletonBandit createSkeletonBandit(GameMap map) {
        SkeletonBandit sb = new SkeletonBandit(map);
        ResetManager.getInstance().registerResettable(sb);
        return sb;
    }

    /**
     * Creates a new lone wolf instance
     * @param map the map that the enemy is on
     * @return new lone wolf enemy
     */
    public static LoneWolf createLoneWolf(GameMap map) {
        LoneWolf lw = new LoneWolf(map);
        ResetManager.getInstance().registerResettable(lw);
        return lw;
    }

    /**
     * Creates a new pile of bones instance
     * @param map the map that the enemy is on
     * @return new pile of bones enemy
     */
    public static PileOfBones createPileOfBones(SkeletalEnemy spawnedEnemy, GameMap map) {
        PileOfBones pob = new PileOfBones(spawnedEnemy, map);
        ResetManager.getInstance().registerResettable(pob);
        return pob;
    }

    /**
     * Creates a Dog instance
     * @return new dog enemy
     */
    public static Dog createDog(GameMap map) {
        Dog dg = new Dog(map);
        ResetManager.getInstance().registerResettable(dg);
        return dg;
    }

    /**
     * Creates a godrick soldier instance
     * @return new godrick soldier enemy
     */
    public static GodrickSoldier createGodrickSoldier(GameMap map) {
        GodrickSoldier gs = new GodrickSoldier(map);
        ResetManager.getInstance().registerResettable(gs);
        return gs;
    }

    /**
     * Creates a godrick the grafted instance
     * @return new godrick the grafted enemy
     */
    public static GodrickTheGrafted createGodrickTheGrafted(GameMap map) {
        GodrickTheGrafted gg = new GodrickTheGrafted(map);
        ResetManager.getInstance().registerResettable(gg);
        return gg;
    }

    /**
     * Generate an invader by choosing a random combat class and registering it as a resettable.
     *
     * @param map The map to spawn the invader on
     * @return The generated Invader
     */
    public static Invader generateInvader(GameMap map) {
        CombatClass combatClass = CombatClassMenu.getRandomClass();
        Invader invader = new Invader(combatClass, map);
        ResetManager.getInstance().registerResettable(invader);
        return invader;
    }
}
