import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {

    Socket socketConnection;
    DataOutputStream outToServer;
    DataInputStream din;
    Board board;
    //DataClient d;
    Client() throws UnknownHostException, IOException {
        //d= new DataClient();

        JButton test = new JButton("click on me");

        board = new Board();



        socketConnection = new Socket("192.168.1.37", 8000);
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
}