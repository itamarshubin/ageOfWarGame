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
    public static ClientData strToObj(String string) throws IOException, ClassNotFoundException {
        PrintWriter writer = new PrintWriter("text.txt", "UTF-8");
        writer.println(string);
        FileInputStream file = new FileInputStream("text.txt");
        ObjectInputStream in = new ObjectInputStream(file);

        in.close();
        file.close();
        // Method for deserialization of object
        return  (ClientData)in.readObject();

    }
    private String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

}
