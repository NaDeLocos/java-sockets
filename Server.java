import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args){
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        final int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while(true){
                sc = servidor.accept();//se queda esperando y devuelve el socket del cliente
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String recivedMessage = "";
                while(recivedMessage.equals("desconectar")){
                    recivedMessage = in.readUTF();
                    out.writeUTF(recivedMessage);
                }

                sc.close();

                System.out.println("Cliente desconectado");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}