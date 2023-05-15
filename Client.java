import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args){
        final String HOST="127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Hola desde el cliente");

            System.out.println("Desde el server" + in.readInt());

            sc.close();

            System.out.println(in.readUTF());
        } catch (Exception e) {
            // TODO: handle exception
        }

        
    }
    
}
