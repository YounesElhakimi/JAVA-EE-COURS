
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BufferedReaderDemo {

    BufferedReader br;

    {
        try {

            br = new BufferedReader(new FileReader("persones.csv"));
            String ligne = br.readLine();
            while (ligne != null){
                System.out.println(ligne);
                ligne = br.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

      public static void main(String[] args){
        BufferedReaderDemo brd = new BufferedReaderDemo();
        
    }


}