import java.util.ArrayList;
import java.util.Collection;

public class Ejercicio1 {

    static void main(String[] args){
        Collection<String> nombres = new ArrayList<>();

        nombres.add("Jose");
        nombres.add("Juan");
        nombres.add("Rosa");

        for(String n : nombres){
            System.out.println(n);
        }

        if(nombres.contains("Juan")){
            nombres.remove("Juan");
        }

        for(String n : nombres){
            System.out.println(n);
        }
    }
}
