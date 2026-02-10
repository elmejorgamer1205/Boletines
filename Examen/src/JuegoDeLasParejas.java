public class JuegoDeLasParejas {

    private static String descripcionJuego = "¡¡¡Bienvenido al Juego de las parejas!!!,\nel juego consiste en encontrar" +
            "todas las parejas antes de que se te agoten los intentos. \nTienes un total de 6 intentos, si los agotas has perdido,\n" +
            "pero si encuentras todas las parejas habrás ganado el juego.\n\nBuena suerte.\n";

    public static void main(String[] args) {

        String[][] tableroOculto =
                {{"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                };

        int[][] tableroDestapado =
                {{1, 4, 3, 1},
                {2, 7, 8, 6},
                {6, 5, 4, 8},
                {2, 7, 3, 5}
                };

        //Imprime una descripción del juego
        System.out.println(descripcionJuego);

        //Imprime el tablero oculto
        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto[i].length; j++) {
                System.out.print("[" + tableroOculto[i][j] + "]" + " ");
            }
            System.out.println();
        }

        //Solicita las coordenadas al usuario del primer número
        int f1 = MiEntradaSalida.solicitarEnteroPositivo("\nIntroduce tú primera coordenada del primer número (fila): ");
        int c1 = MiEntradaSalida.solicitarEnteroPositivo("\nIntroduce tú segunda coordenada del primer número (columna): ");

    }

    /**
     * Recorro las mátrices tableroOculto y tableroDestapado para ver si los números introducidos por el usuario
     * coinciden en el tablero de juego
     *
     * @param tableroOculto
     * @param tableroDestapado
     */

    public static void mostrarTableroConCoordenadas(String[][] tableroOculto, int[][] tableroDestapado) {
        //recorro la mátriz tableroOculto tanto filas como columnas
        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto[i].length; j++) {
            }
        }
        //recorro la mátriz tableroDestapado tanto las filas cómo las columnas
        for (int i = 0; i < tableroDestapado.length; i++) {
            for (int j = 0; j < tableroDestapado[i].length; j++) {
            }
        }
    }
}
