import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PaperLabel extends JLabel {

    public PaperLabel() {
        super();

        setIcon(ImageResizer.resizeImage("images/paper.png", 50, 50));

        this.speed = new Random().nextInt(3) + 1;
        this.direction = 0;
    }

public void move() {
    Point currentPos = getLocation();
    setBounds(currentPos.x, currentPos.y + speed, 50, 50); // Explicitly set bounds

    if (currentPos.y > RockFrame.FRAME_HEIGHT) {
        setBounds(currentPos.x, 0, 50, 50); // Reset to the top
    }
}


    private int speed;
    private int direction; // Direction isn't needed for Paper
}
