import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PaperLabel extends JLabel {

    public PaperLabel() {
        super("(P)");
        this.speed = new Random().nextInt(3) + 1; // Random speed between 1 and 3
        this.direction = 0; // Direction isn't really used here
        setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void move() {
        // Move the Paper downward
        Point currentPos = getLocation();
        setLocation(currentPos.x, currentPos.y + speed);
    }

    private int speed;
    private int direction; // Direction isn't needed for Paper
}
