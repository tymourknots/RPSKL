import javax.swing.*;
/**
 * The Runner class serves as the entry point for the Rock-Paper-Scissors-Lizard-Spock (RPSKL) game.
 * It initializes and displays the main game window defined by the RockFrame class.
 *
 * This program implements a GUI-based version of the RPSKL game, where players can 
 * generate shapes (Rock, Paper, Scissors, Lizard, Spock) by clicking on corresponding buttons. 
 * Each shape moves in a predefined manner and interacts with other shapes according to the RPSKL rules.
 * When shapes collide, the game applies these rules to determine the outcome, resulting in the removal 
 * of the losing shape(s) from the game.
 *
 * Technical Debt:
 * - Current Collision Handling: When two shapes collide, there is an issue where not only the
 *   involved shapes are removed, but all instances of the losing shape type are removed from the frame.
 *   This is due to the method of shape identification and removal in collision handling, which 
 *   does not precisely target only the shapes involved in the specific collision.
 * - The current implementation does not handle ties (when similar shapes collide) in a specific way, 
 *   and this scenario might require further refinement for more sophisticated game dynamics.
 *
 * @author Tymour Aidabole
 * @uni taa2146
 */
public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockFrame().setVisible(true));
    }
}
