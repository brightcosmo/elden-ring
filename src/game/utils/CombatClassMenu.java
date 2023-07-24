package game.utils;

import edu.monash.fit2099.engine.displays.Display;
import game.combatclasses.*;

import java.util.Arrays;
import java.util.List;

/**
 * A simple I/O interface used to accept user input for a combat class.
 * This also generates random combat classes where needed.
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class CombatClassMenu {

    /**
     * The Display class to display prompts in the terminal.
     */
    private static final Display display = new Display();

    private static final List<Character> validChars = Arrays.asList('S','B','W','A');


    /**
     * Allows the user to choose a combat class.
     * Prompts the user for input until a valid one is entered, then create the corresponding combat class.
     * @return The combat class chosen by the player
     */
    public static CombatClass promptClass() {
        char inputChar;
        do {
            display.print("  S => Samurai\n  B => Bandit\n  W => Wretch\n  A => Astrologer\nEnter a character to choose your class:");
            inputChar = Character.toUpperCase(display.readChar());
        } while (!validChars.contains(inputChar));
        return getCombatClass(inputChar);
    }

    public static CombatClass getRandomClass() {
        return getCombatClass(validChars.get(RandomNumberGenerator.getRandomInt(validChars.size())));
    }

    public static CombatClass getCombatClass(char c){
        CombatClass combatClass = null;
        switch (c) {
            case 'S' -> combatClass = new Samurai();
            case 'B' -> combatClass = new Bandit();
            case 'W' -> combatClass = new Wretch();
            case 'A' -> combatClass = new Astrologer();
        }
        return combatClass;
    }
}
