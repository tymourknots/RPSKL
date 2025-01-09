import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 * The RockFrame class represents the main window of the Rock-Paper-Scissors-Lizard-Spock (RPSKL) game.
 * It sets up the game interface, initializes the game elements, and handles the game logic.
 * Players can create various shapes by clicking buttons, and these shapes interact according to RPSKL rules.
 *
 * @author Tymour Aidabole
 * @uni taa2146
 */
public class RockFrame extends JFrame {


    /**
     * Constructs and initializes the RockFrame.
     */
    public RockFrame() {
        setTitle("RPSKL Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(new BorderLayout());

        setupFactoryArea();

        Timer timer = new Timer(DELAY, e -> updateShapes());
        timer.start();

        setVisible(true);
    }

    /**
     * Sets up the factory area with buttons for creating game shapes.
     */
    private void setupFactoryArea() {
        factoryPanel = new JPanel();
        factoryPanel.setLayout(new GridLayout(1, SHAPES.length));
        for (String shape : SHAPES) {
            JButton button = new JButton(shape);
            button.addActionListener(e -> createShape(shape));
            factoryPanel.add(button);
        }
        add(factoryPanel, BorderLayout.NORTH);
    }

    /**
     * Creates a shape based on the specified type and adds it to the game.
     *
     * @param shapeType The type of shape to create (R, P, S, K, L).
     */
    private void createShape(String shapeType) {
        JLabel shapeLabel;
        switch (shapeType) {
            case "R":
                shapeLabel = new RockLabel();
                break;
            case "P":
                shapeLabel = new PaperLabel();
                break;
            case "S":
                shapeLabel = new ScissorsLabel();
                break;
            case "K":
                shapeLabel = new SpockLabel();
                break;
            case "L":
                shapeLabel = new LizardLabel();
                break;
            default:
                return;
        }
        positionShape(shapeLabel);
        add(shapeLabel);
        repaint();
    }
    
    
    /**
     * Positions a given JLabel within the game frame.
     *
     * @param label The JLabel to position.
     */    
    private void positionShape(JLabel label) {
        Random rand = new Random();
        int labelWidth = 50;  // Fixed width of your labels (match image size)
        int labelHeight = 50; // Fixed height of your labels (match image size)
        int x = rand.nextInt(FRAME_WIDTH - labelWidth);
        int y = rand.nextInt(FRAME_HEIGHT - labelHeight - factoryPanel.getHeight());
        label.setBounds(x, y, labelWidth, labelHeight);
    }
    
    
    /**
     * Updates the positions of the shapes and checks for collisions.
     */
    private void updateShapes() {
        ArrayList<JLabel> shapes = new ArrayList<>();
    
        // Move each shape according to its specific behavior and add it to the list for collision checking
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof RockLabel) {
                ((RockLabel) comp).move();
            } else if (comp instanceof PaperLabel) {
                ((PaperLabel) comp).move();
            } else if (comp instanceof ScissorsLabel) {
                ((ScissorsLabel) comp).move();
            } else if (comp instanceof SpockLabel) {
                ((SpockLabel) comp).move();
            } else if (comp instanceof LizardLabel) {
                ((LizardLabel) comp).move();
            }
    
            if (comp instanceof JLabel) {
                shapes.add((JLabel) comp);
            }
        }
    
        // Check for collisions
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                JLabel shape1 = shapes.get(i);
                JLabel shape2 = shapes.get(j);
                if (intersect(shape1, shape2)) {
                    handleCollision(shape1, shape2);
                }
            }
        }
    }

    /**
     * Determines the type of a given JLabel based on its text.
     *
     * @param label The JLabel whose type is to be determined.
     * @return The type of the shape as a String.
     */
    private String getType(JLabel label) {
        if (label instanceof RockLabel) return "R";
        if (label instanceof PaperLabel) return "P";
        if (label instanceof ScissorsLabel) return "S";
        if (label instanceof SpockLabel) return "K";
        if (label instanceof LizardLabel) return "L";
        return "";
    }
    
    
    /**
     * Checks if two JLabels intersect.
     *
     * @param label1 The first JLabel.
     * @param label2 The second JLabel.
     * @return True if the JLabels intersect, false otherwise.
     */
    private boolean intersect(JLabel label1, JLabel label2) {
        Rectangle bounds1 = label1.getBounds();
        Rectangle bounds2 = label2.getBounds();
        return bounds1.intersects(bounds2);
    }
    
    /**
     * Handles the collision between two shapes, applying RPSKL rules.
     *
     * @param shape1 The first shape involved in the collision.
     * @param shape2 The second shape involved in the collision.
     */
    private void handleCollision(JLabel shape1, JLabel shape2) {
        String type1 = getType(shape1);
        String type2 = getType(shape2);
    
        String winner = determineWinner(type1, type2);
    
        // Only remove shapes if it's not a tie
        if (!winner.equals("Tie")) {
            if (!winner.equals(type1)) {
                getContentPane().remove(shape1);
            }
            if (!winner.equals(type2)) {
                getContentPane().remove(shape2);
            }
        }
    
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    /**
     * Determines the winner of a collision based on RPSKL rules.
     *
     * @param type1 The type of the first shape.
     * @param type2 The type of the second shape.
     * @return The type of the winning shape, or "Tie" if there is no winner.
     */
    private String determineWinner(String type1, String type2) {
        if (type1.equals(type2)) return "Tie";
    
        switch (type1) {
            case "R":
                if (type2.equals("S") || type2.equals("L")) return type1;
                break;
            case "P":
                if (type2.equals("R") || type2.equals("K")) return type1;
                break;
            case "S":
                if (type2.equals("P") || type2.equals("L")) return type1;
                break;
            case "K":
                if (type2.equals("S") || type2.equals("R")) return type1;
                break;
            case "L":
                if (type2.equals("K") || type2.equals("P")) return type1;
                break;
        }
    
        return type2; // If type1 doesn't win, type2 wins
    }

    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 400;
    private static final String[] SHAPES = {"R", "P", "S", "K", "L"};
    private JPanel factoryPanel;
    private Timer movementTimer;
    private static final int DELAY = 100; // Update interval in milliseconds
}
