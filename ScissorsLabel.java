import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScissorsLabel extends JLabel {

    public ScissorsLabel() {
        super();

        setIcon(ImageResizer.resizeImage("images/scissors.png", 50, 50));

        this.speed = new Random().nextInt(3) + 1;
        this.direction = 1;
    }

    public void move() {
        Point currentPos = getLocation();
        setBounds(currentPos.x + speed, currentPos.y, 50, 50); // Explicitly set bounds
    
        if (currentPos.x + 50 > RockFrame.FRAME_WIDTH) {
            setBounds(0, currentPos.y, 50, 50); // Reset to the left
        }
    }
    

    private int speed;
    private int direction; // Direction for left-right movement
}
