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

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(1080, 720);
            this.setResizable(false);
            this.setLocationRelativeTo(null);

            this.setContentPane(new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(background, 0, 0, null);
                }
            });

            this.setVisible(true);
            Start();
        }

    private void Start() {
        String name = "no clue yet";
        JLabel welcomeMessage = new JLabel();
        welcomeMessage.setText("WELCOME TO " + name + "!");
    }

}

