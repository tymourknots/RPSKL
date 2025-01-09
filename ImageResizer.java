import javax.swing.*;
import java.awt.*;

public class ImageResizer {
    /**
     * Loads an image from the given path and resizes it to the specified width and height.
     *
     * @param imagePath The path to the image file.
     * @param width The desired width of the resized image.
     * @param height The desired height of the resized image.
     * @return A resized ImageIcon.
     */
    public static ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imagePath); // Load the image
        Image originalImage = originalIcon.getImage(); // Get the original image
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize
        return new ImageIcon(resizedImage); // Return the resized image as an ImageIcon
    }
}

