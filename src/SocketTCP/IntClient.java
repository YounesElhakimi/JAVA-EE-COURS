package SocketTCP;

import java.io.*;
import java.net.Socket;

public class IntClient {
    Socket s;

    {
        try {

            System.out.println("connection in Client .......");
            s = new Socket("127.0.0.1" , 8888);

            //communication avec un client
            //récuperer les flux / canaux associes

            System.out.println("out/ in Client .......");
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out =new DataOutputStream( s.getOutputStream());

            //Write
            System.out.println("write client..");
            out.writeInt(23);

            System.out.println("read client..");
            int result = in.readInt();

            System.out.println("result  : "+ result);

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntClient client = new IntClient();
    }
}
