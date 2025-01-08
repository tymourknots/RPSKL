import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SpockLabel extends JLabel {

    public SpockLabel() {
        super("(K)");
        this.speed = new Random().nextInt(3) + 1; // Speed at which Spock rises upwards
        this.direction = 2; // Indicating upward movement
        setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void move() {
        // Move Spock upwards
        Point currentPos = getLocation();
        setLocation(currentPos.x, currentPos.y - speed);

        // Check for bounds and reset position if needed
        if (currentPos.y < 0) {
            setLocation(currentPos.x, RockFrame.FRAME_HEIGHT); // Reset to bottom
        }
    }

    private int speed;
    private int direction; // Direction for upward movement
}
