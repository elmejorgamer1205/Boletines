public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] jardin =
                {
                        {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
                        {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
                        {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
                        {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
                        {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
                        {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                        {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
                        {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
                        {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
                        {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
                        {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
                        {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
                };

        recorreJardin(jardin);
    }

    public static void recorreJardin(int[][] jardin) {
        for (int i = 0; i < jardin.length; i++) {
            for (int j = 0; j < jardin[i].length; j++) {
                if (jardin[i][j] == 1) {

                    if (florece(jardin, i, j)) {
                        System.out.printf("La flor de la posición %d,%d florecerá\n", i, j);
                    }

                }
            }
        }
    }

    public static boolean florece(int[][] jardin, int fila, int columna) {
        if (hayAgua(jardin, fila, columna) && hayAbeja(jardin, fila, columna) && (!hayMalaHierba(jardin, fila, columna) || hayGusanoComeHierba(jardin, fila, columna) && hayMalaHierba(jardin, fila, columna))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hayAgua(int[][] jardin, int fila, int col) {
        for (int i = fila - 1; i <= fila + 1; i++) {  //Dentro del rango de filas y columnas detecta las adyacentes incluidas las diagonales
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (i == fila && j == col) continue;
                    if (jardin[i][j] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hayAbeja(int[][] jardin, int fila, int col) {
        for (int i = fila - 3; i <= fila + 3; i++) {  //Dentro del rango de filas y columnas detecta las adyacentes incluidas las diagonales
            for (int j = col - 3; j <= col + 3; j++) {
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (i == fila && j == col) continue;
                    if (jardin[i][j] == 5) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static boolean hayMalaHierba(int[][] jardin, int fila, int col) {
        for (int i = fila - 1; i <= fila + 1; i++) {  //Dentro del rango de filas y columnas detecta las adyacentes incluidas las diagonales
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (i == fila && j == col) continue;
                    if (jardin[i][j] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hayGusanoComeHierba(int[][] jardin, int fila, int col) {
        for (int i = fila - 1; i <= fila + 1; i++) {  //Dentro del rango de filas y columnas detecta las adyacentes incluidas las diagonales
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (i == fila && j == col) continue;
                    if (jardin[i][j] == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
