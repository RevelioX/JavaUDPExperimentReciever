package backend.org;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImageDisplayer extends JFrame {
    private BufferedImage image;

    public ImageDisplayer(BufferedImage image) {
        this.image = image;
        setTitle("Image Displayer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibuja la imagen en el centro del panel
                int x = (getWidth() - image.getWidth()) / 2;
                int y = (getHeight() - image.getHeight()) / 2;
                g.drawImage(image, x, y, this);
            }
        };
        getContentPane().add(panel);

        setVisible(true);
    }
}
