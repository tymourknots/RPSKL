import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LizardLabel extends JLabel {

    public LizardLabel() {
        super();

        setIcon(ImageResizer.resizeImage("images/lizard.png", 50, 50));

        this.speed = new Random().nextInt(3) + 1;
        this.direction = 3;
    }

    public void move() {
        Point currentPos = getLocation();
        setBounds(currentPos.x - speed, currentPos.y, 50, 50); // Explicitly set bounds
    
        if (currentPos.x < 0) {
            setBounds(RockFrame.FRAME_WIDTH, currentPos.y, 50, 50); // Reset to the right
        }
    }
    
    

    private int speed;
    private int direction; // Direction for leftward movement
}
