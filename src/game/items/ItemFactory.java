package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.ItemType;
import game.interfaces.Purchasable;
import game.interfaces.PurchasableWithItem;
import game.interfaces.Sellable;
import game.weapons.*;

/**
 * A class used to generate Purchasable and Sellable objects.
 * @author Nisha Kannapper
 */
public class ItemFactory {

    /**
     * Generates a Purchasable object.
     * @param item enum specifies which Purchasable object to generate
     * @return newly generated Purchasable object
     */
    public static Purchasable generatePurchasable (ItemType item) {

        Purchasable returnItem;

        switch (item) {
            case CLUB:
                returnItem = new Club();
                break;

            case UCHIGATANA:
                returnItem = new Uchigatana();
                break;

            case GREAT_KNIFE:
                returnItem = new GreatKnife();
                break;

            case SCIMITAR:
                returnItem = new Scimitar();
                break;

            case HEAVY_CROSSBOW:
                returnItem = new HeavyCrossbow();
                break;

            case ASTROLOGER_STAFF:
                returnItem = new AstrologerStaff();
                break;

            
            default:
                returnItem = null;
        }

        return returnItem;
    }

    /**
     * Generates a Sellable object.
     * @param item enum specifies which Sellable object to generate
     * @return newly generated Sellable object
     */
    public static Sellable generateSellable (ItemType item) {

        Sellable returnItem;

        switch (item) {
            case CLUB:
                returnItem = new Club();
                break;

            case UCHIGATANA:
                returnItem = new Uchigatana();
                break;

            case GREAT_KNIFE:
                returnItem = new GreatKnife();
                break;

            case GROSSMESSER:
                returnItem = new Grossmesser();
                break;
                
            case SCIMITAR:
                returnItem = new Scimitar();
                break;

            case HEAVY_CROSSBOW:
                returnItem = new HeavyCrossbow();
                break;

            case AXE_OF_GODRICK:
                returnItem = new AxeOfGodrick();
                break;

            case GRAFTED_DRAGON:
                returnItem = new GraftedDragon();
                break;

            case REMEMBRANCE_OF_THE_GRAFTED:
                returnItem = new RemembranceOfTheGrafted();
                break;

            case ASTROLOGER_STAFF:
                returnItem = new AstrologerStaff();
                break;

            default:
                returnItem = null;
        }

        return returnItem;
    }

    /**
     * Generates a Item object.
     * @param weapon enum specifies which WeaponItem object to generate
     * @return newly generated WeaponItem object
     */
    public static WeaponItem generateWeaponItem (ItemType weapon) {

        WeaponItem returnWeapon;

        switch (weapon) {
            case CLUB:
                returnWeapon = new Club();
                break;

            case UCHIGATANA:
                returnWeapon = new Uchigatana();
                break;

            case GREAT_KNIFE:
                returnWeapon = new GreatKnife();
                break;

            case GROSSMESSER:
                returnWeapon = new Grossmesser();
                break;

            case SCIMITAR:
                returnWeapon = new Scimitar();
                break;

            case HEAVY_CROSSBOW:
                returnWeapon = new HeavyCrossbow();
                break;

            case AXE_OF_GODRICK:
                returnWeapon = new AxeOfGodrick();
                break;

            case GRAFTED_DRAGON:
                returnWeapon = new GraftedDragon();
                break;

            default:
                returnWeapon = null;
        }

        return returnWeapon;
    }

    /**
     * Generates a PurchasableWithItem object.
     * @param weapon enum specifies which PurchasableWithItem object to generate
     * @return newly generated Purchasable object
     */
    public static PurchasableWithItem generatePurchasableWithItem (ItemType weapon) {

        PurchasableWithItem returnWeapon;

        switch (weapon) {
            case AXE_OF_GODRICK:
                returnWeapon = new AxeOfGodrick();
                break;

            case GRAFTED_DRAGON:
                returnWeapon = new GraftedDragon();
                break;

            default:
                returnWeapon = null;
        }

        return returnWeapon;
    }

}
