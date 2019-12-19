import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JFrame {
    public Board() throws IOException {

            BufferedImage background;
            String backgroundSrc = "Background.png";

            //Loading the image into Background

            background = ImageIO.read(Board.class.getResource(backgroundSrc));


            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1080, 720);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);

            frame.setContentPane(new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(background, 0, 0, null);
                }
            });
            frame.setVisible(true);
        }
    }

