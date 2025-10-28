public class Ejercicio10 {
    public static void main(String[] args){
        int[][] matriz= {{1,3,0,3,1},{4,2,7,2,4},{6,1,9,1,6},{0,8,8,8,0}};
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+ "]"+" ");
            }
            System.out.println();
        }
        if(comprobarSiEsSimetrica(matriz)){
            System.out.println("La matriz es simétrica");
        }else {
            System.out.println("La matriz no es simétrica");
        }


    }
    public static boolean comprobarSiEsSimetrica(int[][] matriz){
        for (int j = 0; j < matriz[0].length/2; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if(matriz[i][j] != matriz[i][matriz[i].length-1-j]) {
                    return false;

                }
            }
        }
        return true;
    }
}
