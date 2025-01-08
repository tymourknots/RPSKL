import javax.swing.*;
import java.awt.*;
/**
 * The RockLabel class represents the "Rock" shape in the Rock-Paper-Scissors-Lizard-Spock (RPSKL) game.
 * This class extends JLabel and is used to display a Rock shape on the game frame.
 * 
 * The RockLabel is characterized by its immobility, as indicated by its zero speed.
 * It does not move and remains static in its initial position.
 * 
 * The label is designed with a specific font and style to clearly represent the "Rock" element in the game.
 */

public class RockLabel extends JLabel {
    /**
     * Constructs a RockLabel with predefined properties.
     * The label is initialized with the text "(R)" to represent Rock.
     * It is set to have zero speed and a static direction.
     */
    public RockLabel() {
        super("(R)");
        this.speed = 0; // Rock stays in place
        this.direction = 0;
        setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void move() {
        // Rock doesn't move, so this is empty
    }

    private int speed;
    private int direction; // 0 for static, 1 for left-right, etc.
}
