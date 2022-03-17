package SocketTCP;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EmployeServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(8989);
        Socket s = ss.accept();

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        Employe emp = (Employe) in.readObject();
        emp.setAge(100);
        emp.setName("server name");

        out.writeObject(emp);

        s.close();

    }

}
