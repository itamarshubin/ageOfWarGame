import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable{
    Socket socketConnection;
    DataOutputStream outToServer;
    DataInputStream din;
    //    Board board;
//    Data boardData;
    int rightSoldiersCount;
    JLabel resalt;

    Client() throws UnknownHostException, IOException{

        socketConnection = new Socket("192.168.1.29", 8000);
        outToServer = new DataOutputStream(socketConnection.getOutputStream());
        din = new DataInputStream(socketConnection.getInputStream());

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
    public static void main(String[] arg) throws UnknownHostException, IOException {
        Client client = new Client();
    }

    public void run() {
        while (true) {
            try {
                System.out.flush();
                String data=din.readUTF();
                //System.out.println(data);
                System.out.println(data);
//                if (data.equals("GR")) {
//                    boardData.getRightsoldiers().get(0).setPosition(boardData.getRightsoldiers().get(0).getPosition()+5);
//                    updateBoard(boardData);
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

