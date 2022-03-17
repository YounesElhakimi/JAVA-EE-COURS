package SocketTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

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
                InputStream in = s.getInputStream();
                OutputStream out = s.getOutputStream();

                //  lire / acrire des données vers le resau
                // methode bloquante
                // x est un byte
                System.out.println("Read server .......");
                int x = in.read();

                int y = 2*x;

                System.out.println("write server .......");
                out.write(y);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
