import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SpockLabel extends JLabel {

    public SpockLabel() {
        super();

        setIcon(ImageResizer.resizeImage("images/spock.png", 50, 50));

        this.speed = new Random().nextInt(3) + 1;
        this.direction = 2;
    }

    public void move() {
        Point currentPos = getLocation();
        setBounds(currentPos.x, currentPos.y - speed, 50, 50); // Explicitly set bounds
    
        if (currentPos.y < 0) {
            setBounds(currentPos.x, RockFrame.FRAME_HEIGHT, 50, 50); // Reset to the bottom
        }
    }
    

    private int speed;
    private int direction; // Direction for upward movement
}
