import java.io.*;

public class Ejercicio1 {
    static void main(String[] args) throws FileNotFoundException {
        File f = new File("leeme.txt");

        try (FileReader fr = new FileReader(f);
        BufferedReader bre = new BufferedReader(fr)){

        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
