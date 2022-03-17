package SocketTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StringClient {

    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost" , 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        pw.println("salam alykom ");
        String result = br.readLine();

        System.out.println(result);
    }


}
