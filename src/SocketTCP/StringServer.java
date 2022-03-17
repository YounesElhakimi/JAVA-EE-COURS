package SocketTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class StringServer {

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
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String ligne =  br.readLine();
                String upperLigne = ligne.toUpperCase();
                OutputStream out = s.getOutputStream();

                PrintWriter pw = new PrintWriter(s.getOutputStream());

                System.out.println("write server .......");
                pw.println(upperLigne);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        StringServer server = new StringServer();
    }
}
