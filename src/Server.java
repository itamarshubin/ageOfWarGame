import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class Server {

    static Socket client1;
    static Socket client2;


    Server() throws IOException
    {

        System.out.println("Server started");
        ServerSocket server = new ServerSocket(8000);
        client1 = new Socket();
        client2 = new Socket();

        client1 = server.accept();
        AcceptClient acceptClient = new AcceptClient(client1);
        System.out.println("Client1 connected");

        client2 = server.accept();
        AcceptClient acceptClient1 = new AcceptClient(client2);
        System.out.println("Client2 connected");



    }

    class AcceptClient extends Thread {
        Socket ClientSocket;
        ObjectInputStream din1;
        ObjectOutputStream dout1;
        ObjectInputStream din2;
        ObjectOutputStream dout2;

        AcceptClient(Socket client) throws IOException {
            ClientSocket = client;

            if (client1 == null) {
                din1 = new ObjectInputStream(ClientSocket.getInputStream());
                dout1 = new ObjectOutputStream(ClientSocket.getOutputStream());
                client1 = ClientSocket;
            }
            else
                din2 = new ObjectInputStream(ClientSocket.getInputStream());
                dout2 = new ObjectOutputStream(ClientSocket.getOutputStream());
                client2 = ClientSocket;

            start();

        }

        public void run()
        {
            try {
                while (true) {

                    //String msgFromClient = din.readUTF();
                    //System.out.println(msgFromClient);
                    //for (int i = 0; i < ClientSockets.size(); i++) {
                    //Socket pSocket = (Socket) ClientSockets.elementAt(i);
                    //if (ClientSocket.equals(pSocket))
                    //	continue;
                    //ObjectOutputStream pOut1 = new ObjectOutputStream(client1.getOutputStream());
                    //pOut1.writeObject(new Object());
                    //pOut1.flush();
                    //ObjectOutputStream pOut2 = new ObjectOutputStream(client2.getOutputStream());
                    //pOut2.writeObject(new Object());
                    //pOut2.flush();
                    dout1.writeObject(new ClientData());
                    dout1.flush();
                    dout2.writeObject(new ClientData());
                    dout2.flush();

                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }
    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
    }
}
