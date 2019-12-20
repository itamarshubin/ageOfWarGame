import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Timer;

public class Client implements Runnable {

    Socket socketConnection;
    DataOutputStream outToServer;
    DataInputStream din;
    Board board;
    ClientData DATA;
    Client() throws UnknownHostException, IOException {
        board = new Board();
        DATA=new ClientData();

        Thread frame = new Thread(f);
        frame.start();
        board.mySoldier1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Soldier s = new Soldier("normal");
                    DATA.getSoldiers().add(s);
                    board.soldiers.add(s);
                    board.add(board.soldiers.get(board.soldiers.size()-1));
                    board.repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        board.mySoldier2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    board.AddSoldier("archer");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        board.mySoldier3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    board.AddSoldier("defender");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //socketConnection = new Socket("192.168.1.37", 8000);
        //outToServer = new DataOutputStream(socketConnection.getOutputStream());
        //din = new DataInputStream(socketConnection.getInputStream());

        Thread thread;
        thread = new Thread(this);
        //thread.start();

        BufferedReader br = null;
        String ClientName = null;
        Scanner input = new Scanner(System.in);
        String SQL = "";
        try {
            System.out.print("Enter you name: ");
            ClientName = input.next();
            // ClientName += ": ";
            // QUERY PASSING

            br = new BufferedReader(new InputStreamReader(System.in));
            while (!SQL.equalsIgnoreCase("exit")) {
                // System.out.println();
                // System.out.print(ClientName);

                SQL = br.readLine();
                // SQL = input.next();
                outToServer.writeUTF(SQL);
                outToServer.flush();
                // System.out.println(din.readUTF());

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] arg) throws UnknownHostException, IOException {
        Client client = new Client();
    }

    public void run() {
        while (true) {
            try {
                /*
                 * String text = din.readUTF().split(": ")[1]; for (int i = 0; i <
                 * 20-text.length(); i++) { text="  "+text; } System.out.println(text);
                 */
                System.out.flush();
                if (din.readUTF().equals("new soldier")) {
                    newSoldier();

                }
                System.out.println(din.readUTF());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public void newSoldier() throws IOException {
        board.AddSoldier("normal");
    }

    Runnable f = new Runnable() {
        @Override
        public void run() {
            new Timer().scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                    for (int i = 0; i < DATA.getSoldiers().size(); i++) {
                        DATA.getSoldiers().get(i).setLocation(DATA.getSoldiers().get(i).getX()+3,550);
                        if ((board.soldiers.get(i).getX() % 2) == 0)
                            board.soldiers.get(i).setIcon(new ImageIcon(board.soldiers.get(i).getWalkingImg()));

                        else
                            board.soldiers.get(i).setIcon(new ImageIcon(board.soldiers.get(i).getStandingImg()));

                        board.soldiers.get(i).setLocation(board.soldiers.get(i).getX(),550);


                    }
                    board.repaint();
                    //board.soldiers = DATA.getSoldiers();
                    //for (int i = 0; i < board.soldiers.size(); i++) {

                    //System.out.println("Here");
                    //}
                }
            },0,100);
        }
    };

}