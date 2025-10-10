public class Ejercicio1 {
    public static void main(String[] args){
        int[] x = {1,2,3,4,5};
        int suma = 0;
        for (int i = 0; i < x.length; i+=2) {
            suma += x[i];

        }
        System.out.printf("La suma de los números pares del array es %d",suma);
        //Recorres el array pero sólo las posiciones pares, y sumar el contenido a suma
    }
}
