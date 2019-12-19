import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class C {

    public ObjectOutputStream outputStream;
    public ObjectInputStream inputStream;

    public C(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }
}
