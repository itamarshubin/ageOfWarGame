import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Timer;

public class Client implements Runnable {

    Socket socketConnection;
    DataOutputStream outToServer;
    DataInputStream din;
    Board board;
    ClientData DATA;
    boolean isDerechChaim;
    boolean banana = true;

    Client() throws UnknownHostException, IOException, ClassNotFoundException, URISyntaxException {
        //System.out.println(convert.strToObj(convert.objToStr(new ClientData())).toString());
        board = new Board();
        DATA=new ClientData();

        Thread frame = new Thread(f);
        frame.start();
        board.mySoldier1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Soldier s = new Soldier("normal",isDerechChaim);
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
                    Soldier s = new Soldier("archer",isDerechChaim);
                    DATA.getSoldiers().add(s);
                    board.soldiers.add(s);
                    board.add(board.soldiers.get(board.soldiers.size()-1));
                    board.repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        board.mySoldier3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Soldier s = new Soldier("defender",isDerechChaim);
                    DATA.getSoldiers().add(s);
                    board.soldiers.add(s);
                    board.add(board.soldiers.get(board.soldiers.size()-1));
                    board.repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        socketConnection = new Socket("192.168.1.37", 8000);
        outToServer = new DataOutputStream(socketConnection.getOutputStream());
        din = new DataInputStream(socketConnection.getInputStream());



       if(din.readUTF().equals("first"))
            isDerechChaim=true;
        else
            isDerechChaim=false;


        System.out.println("is derch"+isDerechChaim);

        Thread sendData = new Thread(new Runnable() {
            @Override
            public void run() {
                new Timer().scheduleAtFixedRate(new TimerTask(){
                    @Override
                    public void run(){
                        try {
                            outToServer.writeUTF(convert.objToStr(DATA));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },0,1000);
            }
        });
        sendData.start();
        Thread thread;
        thread = new Thread(this);
        thread.start();

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


    public static void main(String[] arg) throws UnknownHostException, IOException, ClassNotFoundException, URISyntaxException {
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
                System.out.println(din.readUTF());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    Runnable f = new Runnable() {
        @Override
        public void run() {
            new Timer().scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                int Y=550;
                    for (int i = 0; i < DATA.getSoldiers().size(); i++) {
                        if((board.soldiers.get(i).getType()).equals("defender"))
                            Y=520;
                        else
                            Y=550;

                        DATA.getSoldiers().get(i).setLocation(DATA.getSoldiers().get(i).getX()+DATA.getSoldiers().get(i).getSpeed(),Y);
                        if ((board.soldiers.get(i).getX() % 2) == 0)
                            board.soldiers.get(i).setIcon(new ImageIcon(board.soldiers.get(i).getWalkingImg()));

                        else
                            board.soldiers.get(i).setIcon(new ImageIcon(board.soldiers.get(i).getStandingImg()));

                        if (((board.soldiers.get(i).getX()>900) || (board.soldiers.get(i).getType().equals("defender")&&(board.soldiers.get(i).getX()>850)))&&isDerechChaim) {
                            board.soldiers.get(i).setSpeed(0);
                            if (banana) {
                                board.soldiers.get(i).setIcon(new ImageIcon(board.soldiers.get(i).getAttackingImg()));
                                banana = !banana;
                            } else {
                                board.soldiers.get(i).setIcon(new ImageIcon(board.soldiers.get(i).getStandingImg()));
                                banana = !banana;
                            }

                        }

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