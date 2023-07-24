package game.weapons;

import game.enums.ItemStatus;
import game.interfaces.Purchasable;
import game.interfaces.Sellable;

/**
 * A weapon which can be bought and sold, wielded by Astrologers.
 * NOTE: This weapon is implemented without the special skill as it is optional.
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class AstrologerStaff extends TradableWeapon implements Purchasable, Sellable {
    /**
     * Constructor.
     */
    public AstrologerStaff() {
        super("Astrologer's Staff", 'f', 274, "zaps", 50);
        makePurchasable();
        makeSellable();
        setCost(800);
        setSellingPrice(100);
    }

    /**
     * Adds the purchasable capability
     */
    public void makePurchasable() {
        this.addCapability(ItemStatus.PURCHASABLE);
    }

    /**
     * Sets the buying price
     *
     * @param runes the buying price
     */
    public void setCost(int runes) {
        cost = runes;
    }


    /**
     * Adds the sellable capability
     */
    public void makeSellable() {
        this.addCapability(ItemStatus.SELLABLE_WEAPON);
    }

    /**
     * Sets the selling price
     *
     * @param runes the selling price
     */
    public void setSellingPrice(int runes) {
        sellingPrice = runes;
    }
}
