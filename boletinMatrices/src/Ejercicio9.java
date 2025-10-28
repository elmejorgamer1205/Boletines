public class Ejercicio9 {
    public static void main(String[] args){
        int[][] matriz= {{1,3,5,6},{4,2,0,8},{4,2,0,8},{1,3,5,6}};
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
        for (int i = 0; i < matriz.length/2; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] != matriz[matriz.length-1-i][j]){
                    return false;

                }

            }

        }
        return true;
    }
}
