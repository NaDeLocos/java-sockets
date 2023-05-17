import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args){
        final String HOST="nose";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        Scanner scan = new Scanner(System.in);

        try {
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            System.out.println("Connection stablished");
            String sendMessage = "";
            while(sendMessage.equals("desconectar")){
                sendMessage = scan.nextLine();
                out.writeUTF(sendMessage);
                System.out.println(in.readInt());
            }
            sc.close();

            System.out.println(in.readUTF());
        } catch (Exception e) {
            // TODO: handle exception
        }

        
    }
    
}
