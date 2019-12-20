import java.io.*;
import java.nio.charset.Charset;
import java.util.Base64;

public class tryg {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientData o = new ClientData();
        ByteArrayOutputStream text = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(text);
        out.writeObject(o);
        String s = text.toString();
        System.out.println(s);

      /*  out.close();
        text.close();

        String s = text.toString();
        //BufferedInputStream text2 = new BufferedInputStream(text);
        InputStream in = new ByteArrayInputStream(s.getBytes(Charset.forName("UTF-8")));

        // Method for deserialization of object

        o = (ClientData)in.readObject();

        in.close();
        text2.close();
        System.out.println(o.toString());*/
    }
}