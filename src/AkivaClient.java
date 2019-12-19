import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

    class AkivaClient {

        private ObjectInputStream inputStream;
        private ObjectOutputStream outputStream;
        private int count;

        AkivaClient(ObjectInputStream inputStream, ObjectOutputStream outputStream, int count) {
            this.inputStream = inputStream;
            this.outputStream = outputStream;
            this.count = count;
        }
    }

