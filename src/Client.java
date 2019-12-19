import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable{
    Socket socketConnection;
    DataOutputStream outToServer;
    DataInputStream din;
    ClientData DATA;

//    Board board;
//    Data boardData;

    Client() throws UnknownHostException, IOException{
        //set the serverClient
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

        DATA = new ClientData();

        try {
            System.out.print("Enter you name: ");
            ClientName = input.next();

            br = new BufferedReader(new InputStreamReader(System.in));
            while (!SQL.equalsIgnoreCase("exit")) {
                SQL = br.readLine();
                outToServer.writeUTF(SQL);
                outToServer.flush();
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
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
