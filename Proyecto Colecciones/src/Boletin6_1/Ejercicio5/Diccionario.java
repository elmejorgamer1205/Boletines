package Boletin6_1.Ejercicio5;

import java.util.*;

public class Diccionario {

    private Map<String, List<String>> diccionario;

    public Diccionario() {
        //inicializamos el mapa
        diccionario = new HashMap<>();
    }


    public void addPalabra(String palabra, String significado) {
        if(diccionario.containsKey(palabra)){
            diccionario.get(palabra).add(significado);
        }
        else {
            List<String> nuevaLista = new ArrayList<>();
            nuevaLista.add(significado);
            diccionario.put(palabra, nuevaLista);
        }
    }

    public List<String> buscarPalabra(String palabra) {
        return diccionario.get(palabra);
    }


    public void borrarPalabra(String palabra) {
        diccionario.remove(palabra);
    }

    public List<String> listadoPalabras(String comienzaPor) {
        List<String> palabraQueEmpiezanPor = new LinkedList<>();

        for (String k: diccionario.keySet()){
            if(k.startsWith(comienzaPor)){
                palabraQueEmpiezanPor.add(k);
            }
        }
        palabraQueEmpiezanPor.sort(null);
        return  palabraQueEmpiezanPor;
    }
}
