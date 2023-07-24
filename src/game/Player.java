package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.standardactions.DeathAction;
import game.combatclasses.CombatClass;
import game.resettables.ResetEvent;
import game.enums.Species;
import game.items.FlaskOfCrimsonTears;
import game.runes.RunePile;
import game.resettables.Resettable;
import game.enums.Status;
import game.runes.RuneManager;
import game.utils.StatusEffectManager;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Brandon Yong Hoong Tak 32025963
 */
public class Player extends Actor implements Resettable {

	/**
	 * The players action menu
	 */
	private final Menu menu = new Menu();

	/**
	 * The map that the player is currently on.
	 */
	private GameMap gameMap;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param combatClass   Player's starting number of hitpoints and weapon
	 */
	public Player(String name, char displayChar, CombatClass combatClass, GameMap gameMap) {
		super(name, displayChar, combatClass.getHp());
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.CAN_TRADE);
		this.addCapability(Status.CAN_REST);
		this.addCapability(Status.CAN_TRAVEL);
		this.addCapability(Status.CAN_HAVE_DEBUFF);
		this.addCapability(Species.ALLIED);
		this.addWeaponToInventory(combatClass.getWeapon());
		this.gameMap = gameMap;
		this.addItemToInventory(FlaskOfCrimsonTears.getInstance());
	}

	/**
	 * Select and return an action to perform on the current turn.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

		StatusEffectManager.executeStatusEffect(this, gameMap, this.getMaxHp());

		if (!this.isConscious()) {
			new Display().println(new DeathAction().execute(this, this.gameMap));
			return new DoNothingAction();
		}

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		for (Weapon weapon : getWeaponInventory()) {
			if (weapon.getSkill(this) != null && hasCapability(Status.IN_COMBAT)) {
				actions.add(weapon.getSkill(this));
			}
		}
		
		removeCapability(Status.IN_COMBAT);
		RuneManager.getRunePile();
		RunePile.setPlayerLocation(gameMap.locationOf(this));
		display.print("HP: " + this.hitPoints + " | Runes: " + RuneManager.getPlayerRunes() + "\n");

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Reset the player, restoring their health to the maximum amount.
	 */
	public void reset(ResetEvent trigger) {
		this.hitPoints = maxHitPoints;
	}

}
