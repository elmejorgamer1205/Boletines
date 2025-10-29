public class Ejercicio16 {
    public static void main(String[] args){
        int[][] matriz = {{1,2,3,4,5},{6,7,8,9,0},{3,2,1,4,5},{9,5,8,6,7},{0,9,8,5,4}};
    }
    public static int[][] comprobarMatrizEnteros(int[][] matriz){
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,1,0,1};
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int contador = 0;
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni >= 0 && ni < matriz.length && nj >= 0 && nj < matriz[0].length) {
                        if (matriz[ni][nj] % 2 == 0) {
                            contador++;
                        }
                    }
                }
                nuevaMatriz[i][j] = contador;
            }
        }
        return nuevaMatriz;
    }
}

