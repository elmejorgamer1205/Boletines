import java.util.Scanner;

public class Ejercicio15 {
    //Crear un metodo que devuelva el número de casilla a la que corresponden unas
    //coordenadas. Es decir, el número de casilla empezando por la casilla [0,0], y recorriendo
    //primero por filas y luego por columnas. Por ejemplo, la casilla [1,5] en una matriz de 6x6
    //ocuparía el número 12. En la misma matriz, la casilla [4,0] ocuparía el número 25.
    //1 2 3 4 5 6
    //7 8 9 10 11 12
    //13 14 15 16 17 18
    //19 20 21 25 23 24
    //25 26 27 28 29 30
    //El metodo no debería recorrer el array con ningún tipo de bucle.
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cuantas columnas tiene tu matriz");
        int numColum = sc.nextInt();
        System.out.println("Ahora dime la fila en la que buscar");
        int fila = sc.nextInt();
        System.out.println("Y ahora la columna");
        int columna = sc.nextInt();
        while(columna>=numColum){
            System.out.println("La posicion de la columna tiene que ser como maximo un numero menor que el numero de columnas totales");
            columna = sc.nextInt();
        }
        int resultado = 0;
        resultado = fila * numColum + columna + 1;
        System.out.println(resultado);


    }
}
