import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class convert {
    public static String objToStr(ClientData object) throws IOException {
        FileOutputStream file = new FileOutputStream("text.txt");
        ObjectOutputStream out = new ObjectOutputStream(file);

        // Method for serialization of object
        //out.writeObject(object);

        out.close();
        file.close();
        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        return stringBuilder.toString();

    }
    public static ClientData strToObj(String string) throws IOException, ClassNotFoundException, URISyntaxException {
        //PrintWriter writer = new PrintWriter("text.txt", "UTF-8");
        //writer.println(string);
        //File f = new File(convert.class.getResource("text.txt").toURI());
        String s = Path.of(convert.class.getResource("RB Attacking.png").toURI()).toString().substring(0,72)+"text.txt";
        System.out.println(s);
        Files.writeString(Path.of(s), string);

        FileInputStream file = new FileInputStream("text.txt");
        ObjectInputStream in = new ObjectInputStream(file);

        //in.close();
        //file.close();
        // Method for deserialization of object
        return  (ClientData)in.readObject();

    }


}
