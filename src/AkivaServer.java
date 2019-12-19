
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

    public class AkivaServer {

        private static List<Client> clientList;

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket;
            Socket clientSocket;
            OutputStream outputStream;
            InputStream inputStream;
            ObjectOutputStream objectOutputStream;
            ObjectInputStream objectInputStream;
            List<AkivaClient> clientList = new ArrayList<AkivaClient>();
            serverSocket = new ServerSocket(8100);
            int count = 1;
            do {
                System.out.println("waiting for client num " + count);
                clientSocket = serverSocket.accept();
                outputStream = clientSocket.getOutputStream();
                inputStream = clientSocket.getInputStream();
                objectOutputStream = new ObjectOutputStream(outputStream);
                objectInputStream = new ObjectInputStream(inputStream);
                System.out.println("connected to client");
                clientList.add(new AkivaClient(objectInputStream, objectOutputStream, count));
            } while (clientList.size() < 2);
        }

    }

