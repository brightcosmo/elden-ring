package game.weapons;

import edu.monash.fit2099.engine.items.Item;
import game.enums.ItemStatus;
import game.interfaces.PurchasableWithItem;
import game.interfaces.Sellable;
import game.items.RemembranceOfTheGrafted;

/**
 * Godrick's phase one axe weapon, can perform a spinning attack
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by: Rys
 *
 */
public class AxeOfGodrick extends Sword implements Sellable, PurchasableWithItem {

    /**
     * Constructor.
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "cleaves", 84);
        this.setSellingPrice(100);
        this.makeSellable();
        this.makePurchasableWithItem();
        this.setItemCost(new RemembranceOfTheGrafted());
    }

    /**
     * Make the item sellable
     */
    public void makeSellable() {this.addCapability(ItemStatus.SELLABLE_WEAPON);}

    /**
     * Sets the selling price for an item
     * @param runes new selling price
     */
    public void setSellingPrice(int runes) {sellingPrice = runes;}


    /**
     * Make the item purchasable
     */
    public void makePurchasableWithItem() {this.addCapability(ItemStatus.PURCHASABLE_WITH_ITEM);}

    /**
     * Sets the cost for an item
     * @param cost new cost
     */
    public void setItemCost(Item cost) {this.itemCost = cost;}
}