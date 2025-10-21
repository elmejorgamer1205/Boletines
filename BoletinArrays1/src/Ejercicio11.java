import java.util.Arrays;

public class Ejercicio11 {
    public static void main(String[] args) {
        //Creo dos Arrays que van a ser los que compare para sacar los comunes y se cree un Array nuevo con esos comunes
        int[] array1 ={1,2,3,4,5,6,7,8,9,10};
        int[] array2 ={1,4,3,12,10,9,5,8};
        //Imprimo por pantalla la mezcla de los dos Arrays con solo los números repetidos
        System.out.println(Arrays.toString(mezclaArrays1y2(array1,array2)));
    }

    /**mezcla de Arrays 1 y 2
     *
     * @param array1
     * @param array2
     * @return
     */
    public static int[] mezclaArrays1y2(int[] array1,int[] array2){
        int size= 0;
        int[] numComunes = new int[array1.length];
        int numeros = Math.min(array1.length,array2.length);
        for (int i = 0; i < numeros; i++) {
            if(contieneElemento(array1,array2[i])){
                numComunes[size] = array2[i];
                size++;
            }
        }
        numComunes = Arrays.copyOf(numComunes,size);
        return numComunes;
    }
    public static boolean contieneElemento(int[] array, int elementoABuscar) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementoABuscar) {
                return true;
            }
        }
        return false;
    }
}