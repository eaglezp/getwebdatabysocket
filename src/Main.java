import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Socket socket = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            printWriter.println("GET / HTTP/1.1");
            printWriter.println("Host:localhost");
            printWriter.println("ContentType:text/html");
            printWriter.println();
            printWriter.flush();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String string = "";
            while ((string = bufferedReader.readLine()) !=  null) {
                System.out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                printWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
