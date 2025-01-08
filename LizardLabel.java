import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LizardLabel extends JLabel {

    public LizardLabel() {
        super("(L)");
        this.speed = new Random().nextInt(3) + 1; // Speed at which Lizard moves leftward
        this.direction = 3; // Indicating leftward movement
        setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void move() {
        // Move Lizard leftward
        Point currentPos = getLocation();
        setLocation(currentPos.x - speed, currentPos.y);

        // Check for bounds and reset position if needed
        if (currentPos.x < 0) {
            setLocation(RockFrame.FRAME_WIDTH, currentPos.y); // Reset to the right side
        }
    }

    private int speed;
    private int direction; // Direction for leftward movement
}
