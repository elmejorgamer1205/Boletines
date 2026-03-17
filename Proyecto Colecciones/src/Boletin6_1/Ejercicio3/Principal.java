package Boletin6_1.Ejercicio3;

public class Principal {
    public static void main(String[] args) {


        try {
            Profesor profesor1=new Profesor("11", "Pepe", 30);
            Profesor profesor2=new Profesor("12", "Pepa", 32);
            Alumno alumno1 = new Alumno("10","Moi",17,TipoEnsennanza.BACHILLERATO,1);
            Alumno alumno2 = new Alumno("13","Ber",18,TipoEnsennanza.BACHILLERATO,1);


            profesor1.enviarCorreo("Hola hola", profesor2);
            profesor1.enviarCorreo("Adios", profesor2);
            profesor2.enviarCorreo("lol",profesor1);
            alumno1.enviarCorreo("l",profesor1);
            alumno2.enviarCorreo("ll",alumno1);
            //alumno1.enviarCorreo("guapo",alumno2);

            System.out.println(profesor1.mostrarMensajesOrdenados());
            System.out.println(alumno1.mostrarMensajes());
            System.out.println(profesor2.mostrarMensajesOrdenados());


        } catch (IESException e) {
            System.out.println(e.getMessage());
        }
    }
}