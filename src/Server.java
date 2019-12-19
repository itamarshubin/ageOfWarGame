import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class Server
{
    static List<C> ClientTheads;
    int fps = 10;
    String data = "";

    Server() throws IOException
    {
        System.out.println("Server started");
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;
        ServerSocket server = new ServerSocket(8000);
        ClientTheads = new ArrayList<>();


        for (int i = 0; i < 2; i++) {
            Socket client = server.accept();
            inputStream = new ObjectInputStream(client.getInputStream());
            outputStream = new ObjectOutputStream(client.getOutputStream());
            System.out.println("Client connected");
            ClientTheads.add(new C(outputStream, inputStream));
        }
        new Thread(new Myth(ClientTheads.get(0).outputStream, ClientTheads.get(1).inputStream)).start();
        new Thread(new Myth(ClientTheads.get(1).outputStream, ClientTheads.get(0).inputStream)).start();
    }



    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
    }
}
