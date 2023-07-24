package game.npcs;

import game.enums.ItemType;
import edu.monash.fit2099.engine.positions.GameMap;
import game.combatclasses.CombatClass;
import game.resettables.ResetManager;
import game.utils.CombatClassMenu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Used to generate NPCs.
 * @author Nisha Kannapper
 */
public class NpcManager {
    /**
     * Generates a trader called Merchant Kale as a Trader object.
     *
     * @return Trader object with Merchant Kale's details
     */
    public static Trader generateMerchantKale() {
        return new Trader(
                "Merchant Kale",
                'K',
                1,
                new ArrayList<ItemType>(Arrays.asList(ItemType.UCHIGATANA, ItemType.GREAT_KNIFE, ItemType.CLUB, ItemType.SCIMITAR)),
                new ArrayList<ItemType>(Arrays.asList(ItemType.UCHIGATANA, ItemType.GREAT_KNIFE, ItemType.CLUB, ItemType.GROSSMESSER, ItemType.SCIMITAR, ItemType.REMEMBRANCE_OF_THE_GRAFTED)),
                new ArrayList<ItemType>()
        );
    }

    /**
     * Generates a trader called Finger Reader Enia as a Trader object.
     *
     * @return Trader object with Finger Reader Enia's details
     */
    public static Trader generateFingerReaderEnia() {
        return new Trader(
                "Finger Reader Enia",
                'E',
                1,
                new ArrayList<ItemType>(),
                new ArrayList<ItemType>(Arrays.asList(ItemType.UCHIGATANA, ItemType.GREAT_KNIFE, ItemType.CLUB, ItemType.GROSSMESSER, ItemType.SCIMITAR, ItemType.AXE_OF_GODRICK, ItemType.GRAFTED_DRAGON, ItemType.HEAVY_CROSSBOW, ItemType.REMEMBRANCE_OF_THE_GRAFTED, ItemType.ASTROLOGER_STAFF)),
                new ArrayList<ItemType>(Arrays.asList(ItemType.AXE_OF_GODRICK, ItemType.GRAFTED_DRAGON))
        );
    }

    /**
     * Generate an ally by choosing a random combat class and registering it as a resettable.
     *
     * @param map The map to spawn the ally on
     * @return The generated Ally
     */
    public static Ally generateAlly(GameMap map) {
        CombatClass combatClass = CombatClassMenu.getRandomClass();
        Ally ally = new Ally(combatClass, map);
        ResetManager.getInstance().registerResettable(ally);
        return ally;
    }
}

