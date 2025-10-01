import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Introduzca un número");
       int num1 = sc.nextInt();
       System.out.println("Introduzca un segundo número");
       int num2 = sc.nextInt();
       System.out.println("Introduzca un tercer número");
       int num3 = sc.nextInt();

       if((num1>num2) && (num2>num3)){
           System.out.println("El orden de los números introducidos es "+ num1 +" "+ num2 +" "+ num3);
       } else if((num1 > num3) && (num3 > num2)){
           System.out.println("El orden correcto es " + num1 + " " + num3 + " " + num2);
       } else if ((num2 > num1) && (num1 > num3)){
           System.out.println("El orden correcto es " + num2 + " " + num1 + " " + num3);
       } else if ((num2 > num3) && (num3 > num1)){
           System.out.println("El orden correcto es " + num2 + " " + num3 + " " + num1);
       } else if((num3 > num2) && (num2 > num1)){
           System.out.println("El orden correcto es " + num3 + " " + num2 + " " + num1);
       } else{
           System.out.println("El orden correcto es " + num3 + " " + num1 + " " + num2);
       }      

   }
}
