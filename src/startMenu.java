//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import static javax.imageio.ImageIO.read;

public class startMenu {

    public static void main(String[] args) throws IOException {
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileInputStream = new FileInputStream(String.valueOf(startMenu.class.getResource("5.mp3")).substring(6));
                    Player player = new Player(fileInputStream);
                    System.out.println("Song is playing...");
                    player.play();
                } catch (FileNotFoundException | JavaLayerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }}).start();*/





        JFrame Frame = new JFrame("startMenu");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(1096, 759);
        //System.out.println(startMenu.class.getResource(""));
        BufferedImage image = read(startMenu.class.getResource("Background.png"));

        Frame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }


        });


        JButton buttonStartFake = new JButton("VS  AI");
        JButton buttonStart = new JButton("MULTIPLAYER");
        JButton buttonExit = new JButton("exit");
        Font fuente = new Font("ARCADE", Font.PLAIN, 44);

        buttonExit.setFont(fuente);
        buttonExit.setFocusPainted(false);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Frame.dispatchEvent(new WindowEvent(Frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        buttonStart.setFont(fuente);
        buttonStart.setFocusPainted(false);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client c = new Client();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //button
        buttonStartFake. setFont(fuente);
        buttonStartFake.setFocusPainted(false);
//     buttonStartFake.setText("start");
//     JLabel text = new JLabel("start");
//     buttonStartFake.add(text);
        buttonStartFake.setForeground(Color.white);
        buttonStartFake.setBackground(Color.MAGENTA);
        buttonStartFake.setBounds(405, 100, 300, 80);
        buttonStartFake.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                buttonStartFake.setText("VS   AI");

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                buttonStartFake.setText("MULTIPLAYER");
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }
        });


        buttonStart.setText("MULTIPLAYER");
        buttonStart.setForeground(Color.white);
        buttonStart.setBackground(Color.MAGENTA);
        buttonStart.setBounds(405, 250, 300, 80);

        buttonExit.setText("EXIT");
        buttonExit.setForeground(Color.white);
        buttonExit.setBackground(Color.MAGENTA);
        buttonExit.setBounds(405, 400, 300, 80);


        Frame.setLayout(null);
        Frame.add(buttonStartFake);
        Frame.add(buttonStart);
        Frame.add(buttonExit);

//
//     GridLayout grid = new GridLayout();
//     grid.setColumns(1);
//     grid.setRows(2);
//     buttonStartFake.setLayout(grid);
        Frame.setVisible(true);

    }


}