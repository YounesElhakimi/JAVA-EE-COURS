package SocketTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MinHTTPServer {


    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8081);
        while (true){
            Socket s = ss.accept();
            System.out.println("accept la connexion");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String ligne = br.readLine();
            while (ligne != null && !ligne.equals("")){
                System.out.println("reading : " + ligne);
                ligne = br.readLine();
            }

            PrintWriter pw = new PrintWriter(s.getOutputStream());
            pw.println("<html> <h1> Welcom to MIN HTTP SERVER </h1> </html>");

            System.out.println("Print to navg : <h1> Welcom to MIN HTTP SERVER </h1>");


        }

    }
}
