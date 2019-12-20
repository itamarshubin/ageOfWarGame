import java.io.*;

public class convert {
    public static String objToStr(ClientData object) throws IOException {
        FileOutputStream file = new FileOutputStream("text.txt");
        ObjectOutputStream out = new ObjectOutputStream(file);

        // Method for serialization of object
        out.writeObject(object);

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

}
