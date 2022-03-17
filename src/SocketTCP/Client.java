package SocketTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    Socket s;

    {
        try {

            System.out.println("connection in Client .......");
            s = new Socket("127.0.0.1" , 8888);

            //communication avec un client
            //récuperer les flux / canaux associes

            System.out.println("out/ in Client .......");
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            //Write
            System.out.println("write client..");
            out.write(23);

            System.out.println("read client..");
            int result = in.read();

            System.out.println("result  : "+ result);

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}
