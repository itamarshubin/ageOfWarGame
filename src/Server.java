import java.io.*;
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
    boolean isDerechChaim=true;
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

                System.out.println("asd");
            if(isDerechChaim) {
                dout.writeUTF("first");
                isDerechChaim=false;
            }else {
                dout.writeUTF("last");

            }
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
                        if (msgFromClient.equals("N"))
                            pOut.writeUTF("new soldier");
                        else
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

    public static byte[] toS(ClientData c) throws IOException {

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so = new ObjectOutputStream(bo);
        so.writeObject(c);
        so.flush();
        return bo.toString().getBytes();
    }
    // deserialize the object
    public static ClientData toOb(String s) throws IOException, ClassNotFoundException {

        byte b[] = s.getBytes();
        ByteArrayInputStream bi = new ByteArrayInputStream(b);
        ObjectInputStream si = new ObjectInputStream(bi);
        return (ClientData) si.readObject();
    }
}
