import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
            this.setLayout(null);

        //soldier 1 button
        JButton mySoldier1 = new JButton("text");
        mySoldier1.setPreferredSize(new Dimension(80, 80));
        mySoldier1.setBounds(30,150,80,80);
        mySoldier1.getPreferredSize();
        mySoldier1.setIcon(new ImageIcon("src/Soldier L1 Standing.png"));
        mySoldier1.setBorder(new LineBorder(Color.RED,5));

        //soldier 2 button
        JButton mySoldier2 = new JButton("text");
        mySoldier2.setPreferredSize(new Dimension(80, 80));
        mySoldier2.setBounds(30,250,80,80);
        mySoldier2.getPreferredSize();
        //mySoldier1.setIcon(new ImageIcon("src/Soldier L1 Standing.png"));
        mySoldier2.setBorder(new LineBorder(Color.RED,5));

        //soldier 3 button
        JButton mySoldier3 = new JButton();
        mySoldier3.setPreferredSize(new Dimension(80, 80));
        mySoldier3.setBounds(30,350,80,80);
        mySoldier3.setIcon(new ImageIcon("src/RB Standing.png"));
        mySoldier3.setBorder(new LineBorder(Color.RED,5));

        //cash labal
        String cashFromServer = "500$";
        JLabel cash = new JLabel(cashFromServer);
        cash.setSize(new Dimension(320,64));
        cash.setLocation(50, 30);
        cash.setForeground(Color.yellow);
        cash.setFont(new java.awt.Font("Arcade normal", 1, 48));
        cash.setVisible(true);






        this.add(mySoldier1);
        this.add(mySoldier2);
        this.add(mySoldier3);
        this.add(cash);
        this.setVisible(true);
        Start();
        }

    private void Start() {
        String name = "no clue yet";
        JLabel welcomeMessage = new JLabel();
        welcomeMessage.setText("WELCOME TO " + name + "!");
    }

}

