import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {

    Socket socketConnection;
    DataOutputStream outToServer;
    DataInputStream din;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    Board board;
    //DataClient d;
    Client() throws UnknownHostException, IOException {
        //d= new DataClient();
        //board = new Board();
        socketConnection = new Socket("127.0.0.1", 8000);
        inputStream = new ObjectInputStream(socketConnection.getInputStream());
        outputStream = new ObjectOutputStream(socketConnection.getOutputStream());
//        outToServer = new DataOutputStream(socketConnection.getOutputStream());
//        din = new DataInputStream(socketConnection.getInputStream());

        Thread thread;
        thread = new Thread(this);
        thread.start();

    }

    public static void main(String[] arg) throws UnknownHostException, IOException {
        Client client = new Client();
    }

    public void run() {
        while (true) {
//            try {
//                /*
//                 * String text = din.readUTF().split(": ")[1]; for (int i = 0; i <
//                 * 20-text.length(); i++) { text="  "+text; } System.out.println(text);
//                 */
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
                outputStream.writeObject(new Object());
                System.out.println(inputStream.readObject().toString());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}