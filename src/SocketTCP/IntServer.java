package SocketTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IntServer {

    ServerSocket ss;

    {
        try {
            //etap 1
            //ouvrir un port d'ecout  disponible

            System.out.println("ouvrir un port d'ecout  disponible .......");
            ss = new ServerSocket(8888);

            //etap 2
            //Attende la demandes de connexions envoyées par des clients
            //methode bloquante
            while (true){
                System.out.println("accept .......");
                Socket s = ss.accept();

                //etap 3
                //communication avec un client
                //récuperer les flux / canaux associes
                DataInputStream in = new DataInputStream( s.getInputStream());
                DataOutputStream out =new DataOutputStream( s.getOutputStream());

                //  lire / acrire des données vers le resau
                // methode bloquante
                // x est un byte
                System.out.println("Read server .......");
                int x = in.readInt();

                int y = 2*x;

                System.out.println("write server .......");
                out.writeInt(y);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntServer server = new IntServer();
    }
}
