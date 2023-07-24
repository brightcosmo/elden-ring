package game.resettables;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public interface Resettable {
    /**
     * A method that "resets" the object to its original state whenever there is an event that triggers reset.
     * The exact implementation depends on the object.
     */
    void reset(ResetEvent trigger);
}
