public class Ejercicio6 {
    public static void main(String[] args){
        int[] miArray = {1,2,3,4,5};
        if (contieneElemento(miArray, 7) ){
            System.out.println("El elemento esta contenido");
        }else {
            System.out.println("El elemento no esta contenido");
        }
    }
    public static boolean contieneElemento (int[] array, int elementoABuscar){
        for (int i = 0; i < array.length; i++) {
            if( array[i] == elementoABuscar){
                return true;
            }
        }
        return false;
    }
}
