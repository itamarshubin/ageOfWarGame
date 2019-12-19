import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

//import newClient.Server;

import java.text.*;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Server
{
    static Vector<Socket> ClientSockets;
    int fps = 10;
    String data = "";

    Server() throws IOException
    {
        System.out.println("Server started");

        ServerSocket server = new ServerSocket(8000);
        ClientSockets = new Vector<Socket>();


        for (int i = 0; i < 2; i++) {
            Socket client = server.accept();
            AcceptClient acceptClient = new AcceptClient(client);
            System.out.println("Client connected");
        }
    }

    class AcceptClient extends Thread {
        Socket ClientSocket;
        DataInputStream din;
        DataOutputStream dout;

        AcceptClient(Socket client) throws IOException {
            ClientSocket = client;
            din = new DataInputStream(ClientSocket.getInputStream());
            dout = new DataOutputStream(ClientSocket.getOutputStream());

            ClientSockets.add(ClientSocket);

            start();

        }

        public void run() {
            try {
                while (true) {

                    String msgFromClient = din.readUTF();
                    System.out.println(msgFromClient);
                    for (int i = 0; i < ClientSockets.size(); i++) {
                        Socket pSocket = (Socket) ClientSockets.elementAt(i);
                        //if (ClientSocket.equals(pSocket))
                        //	continue;
                        DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
                        pOut.writeUTF(msgFromClient);
                        pOut.flush();
                    }
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
    }
}
