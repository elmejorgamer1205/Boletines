public class suma_1_al_10 {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 1; i < 101; i=i+2){
            suma += i;
        }
        System.out.println("La suma de los diez primeros numeros es " + suma);
    }

}
