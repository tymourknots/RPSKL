import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScissorsLabel extends JLabel {

    public ScissorsLabel() {
        super("(S)");
        this.speed = new Random().nextInt(3) + 1; // Speed at which Scissors move left to right
        this.direction = 1; // Indicating left to right movement
        setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void move() {
        // Move the Scissors left to right
        Point currentPos = getLocation();
        setLocation(currentPos.x + speed, currentPos.y);

        // Check for bounds and reset position if needed
        if (currentPos.x + getWidth() > RockFrame.FRAME_WIDTH) {
            setLocation(0, currentPos.y); // Reset to left side
        }
    }

    private int speed;
    private int direction; // Direction for left-right movement
}
