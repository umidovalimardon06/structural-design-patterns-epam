import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile implements DisplayObject {
    private BufferedImage image;

    public ImageFile(String path) {
        this.image = load(path);
    }

    @Override
    public void display() {
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        JOptionPane.showMessageDialog(null, label);
    }

    private BufferedImage load(String path) {
        BufferedImage image1 = null;
        try {
            image1 = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image1;
    }
}
