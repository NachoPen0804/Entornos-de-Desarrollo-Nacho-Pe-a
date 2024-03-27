package calculadora;

import java.beans.PropertyEditorSupport;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int num1 = preguntarNumeros(1);
        int num2 = preguntarNumeros(2);

        System.out.println("Seleccione la operación: ");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        int opcion = 0;
        try {
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor introduzca un número entero");
        }

        int resultado = 0;
        switch (opcion) {
            case 1:
                resultado = sumar(num1, num2);
                System.out.println(num1 + " + " + num2 + " = " + resultado);
                break;
            case 2:
                resultado = restar(num1, num2);
                System.out.println(num1 + " + " + num2 + " = " + resultado);
                break;

            case 3:
                resultado = multiplicar(num1, num2);
                System.out.println(num1 + " + " + num2 + " = " + resultado);
                break;

            case 4:
                try {
                    resultado = dividir(num1, num2);
                    System.out.println(num1 + " + " + num2 + " = " + resultado);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Error: Opción invalida");
                break;
        }


        sc.close();
    }

    public static int sumar(int num1, int num2) {
        int resultado = num1 + num2;
        return resultado;
    }

    public static int restar(int num1, int num2) {
        int resultado = num1 - num2;
        return resultado;
    }

    public static int multiplicar(int num1, int num2) {
        int resultado = num1 * num2;
        return resultado;
    }

    public static int dividir(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            throw new ArithmeticException("Syntax Error: No se puede dividir entre 0");
        }

        int resultado = num1 / num2;
        return resultado;
    }

    private static int preguntarNumeros(int fase) {
        if (fase == 1) {
            System.out.println("Introduzca el primer número: ");
        } else {
            System.out.println("Introduzca el segundo número: ");
        }
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor introduzca un número entero");
        }
        return num;
    }
}
