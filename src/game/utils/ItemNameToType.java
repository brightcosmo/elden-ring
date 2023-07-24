package game.utils;

import game.enums.ItemType;
import game.items.*;
import game.weapons.*;

import java.util.HashMap;


/**
 * A class used to match strings containing an item's name to a ItemType enum.
 * @author Nisha Kannapper
 */
public class ItemNameToType {

    /**
     * A HashMap: keys are the String names of item, values are the item's respective ItemType enum
     */
    private static HashMap<String, ItemType> itemTypeHashMap = new HashMap<String, ItemType>() {
        { put((new Club()).toString(), ItemType.CLUB);
            put((new GreatKnife()).toString(), ItemType.GREAT_KNIFE);
            put((new Uchigatana()).toString(), ItemType.UCHIGATANA);
            put((new Grossmesser()).toString(), ItemType.GROSSMESSER);
            put((new Scimitar()).toString(), ItemType.SCIMITAR);
            put((new HeavyCrossbow()).toString(), ItemType.HEAVY_CROSSBOW);
            put((new GraftedDragon()).toString(), ItemType.GRAFTED_DRAGON);
            put((new AxeOfGodrick()).toString(), ItemType.AXE_OF_GODRICK);
            put((new RemembranceOfTheGrafted()).toString(), ItemType.REMEMBRANCE_OF_THE_GRAFTED);
            put((new GoldenRune()).toString(), ItemType.GOLDEN_RUNE);
            put((new GoldenSeed()).toString(), ItemType.GOLDEN_SEED);
            put((new SacredTear()).toString(), ItemType.SACRED_TEAR);
            put((new PreservingBolus()).toString(), ItemType.PRESERVING_BOLUS);
            put((new AstrologerStaff()).toString(), ItemType.ASTROLOGER_STAFF);

        }
    };

    /**
     * Takes an item's name and returns the respective item's ItemType enum
     * @param name name of an item
     * @return
     */
    public static ItemType get(String name) {
        return itemTypeHashMap.get(name);
    }
}
