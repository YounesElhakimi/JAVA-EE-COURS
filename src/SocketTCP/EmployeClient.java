package SocketTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class EmployeClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket s = new Socket("127.0.0.1" , 8989);
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        Employe emp = new Employe("younes " , 34);
        System.out.println(emp);
        out.writeObject(emp);

        Employe emp2 = (Employe) in.readObject();
        System.out.println(emp2);

        s.close();

    }
}
