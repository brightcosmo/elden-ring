package game.items;

import game.enums.ItemStatus;
import game.interfaces.Sellable;

/**
 * Tradable item dropped by Godrick the Grafted, can be traded for his weapons at finger reader Enia
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by: Rys
 *
 */
public class RemembranceOfTheGrafted extends TradableItem implements Sellable {

    /***
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
        this.setSellingPrice(20000);
        this.makeSellable();
    }

    /**
     * Make the item sellable
     */
    public void makeSellable() {this.addCapability(ItemStatus.SELLABLE_ITEM);}

    /**
     * Sets the selling price for an item
     * @param runes new selling price
     */
    public void setSellingPrice(int runes) {sellingPrice = runes;}
}

