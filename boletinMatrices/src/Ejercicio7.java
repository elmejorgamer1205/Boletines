public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matriz2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(comprobacionSiSonIguales(matriz1,matriz2));
    }

    public static boolean comprobacionSiSonIguales(int[][] matriz1, int[][] matriz2) {
        if (comprobacionTamaño(matriz1,matriz2)) {
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    if (matriz1[i][j] != matriz2[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean comprobacionTamaño(int[][] matriz1, int[][] matriz2){
        if (matriz1.length != matriz2.length) {
            return false;
        }
        for (int i = 0; i < matriz1.length; i++) {
            if (matriz1[i].length != matriz2[i].length) {
                return false;
            }
        }
        return true;
    }
}
