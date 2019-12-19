import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

        Socket client = server.accept();
        AcceptClient acceptClient = new AcceptClient(client);
        System.out.println("Client connected");


    }

    class AcceptClient extends Thread {
        Socket ClientSocket;
        DataInputStream din;
        DataOutputStream dout;

        AcceptClient(Socket client) throws IOException {
            ClientSocket = client;
            din = new DataInputStream(ClientSocket.getInputStream());
            dout = new DataOutputStream(ClientSocket.getOutputStream());

            if (client1==null)
                client1 = ClientSocket;
            else
                client2 = ClientSocket;

            start();

        }

        public void run()
        {
            try {
                while (true) {

                    String msgFromClient = din.readUTF();
                    System.out.println(msgFromClient);
                    //for (int i = 0; i < ClientSockets.size(); i++) {
                    //Socket pSocket = (Socket) ClientSockets.elementAt(i);
                    //if (ClientSocket.equals(pSocket))
                    //	continue;
                    DataOutputStream pOut1 = new DataOutputStream(client1.getOutputStream());
                    pOut1.writeUTF(msgFromClient);
                    pOut1.flush();
                    DataOutputStream pOut2 = new DataOutputStream(client2.getOutputStream());
                    pOut2.writeUTF(msgFromClient);
                    pOut2.flush();

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
