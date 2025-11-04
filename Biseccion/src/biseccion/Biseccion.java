/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biseccion;
import java.util.Scanner;
public class Biseccion {
      public static double funcion(double x) {
        return Math.pow(x, 3) - 4 * x - 9; // Ejemplo: f(x) = x^3 - 4x - 9
    }
    public static void MetodoBiseccion(double Xi, double Xs, double tolerancia, int iteracionesMax) {
        double Xm = 0;
        int iteraciones = 0;
        
        if (funcion(Xi) * funcion(Xs) >= 0) {
            System.out.println("La función no cambia de signo en el intervalo dado. Verifique los valores de Xi y Xs.");
            return;
        }
        System.out.println("Iteración\tXi\tXm\tXs\tError");
        
        double error = Double.MAX_VALUE;
        while (error > tolerancia && iteraciones < iteracionesMax) {
            double XmAnterior = Xm;
            Xm = (Xi + Xs) / 2;
            
            if (funcion(Xm) == 0.0) {
                break; // Se encontró la raíz exacta
            }
            
            if (funcion(Xi) * funcion(Xm) < 0) {
                Xs = Xm;
            } else {
                Xi = Xm;
            }
            
            // Cálculo del error
            error = Math.abs((Xm - XmAnterior) / Xm) * 100;
            
            System.out.printf("%d\t%.5f\t%.5f\t%.5f\t%.5f%%\n", iteraciones + 1, Xi, Xm, Xs, error);
            
            iteraciones++;
        }
        
        System.out.println("Raíz aproximada: " + Xm);
        System.out.println("Iteraciones realizadas: " + iteraciones);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el valor de Xi (límite inferior): ");
        double Xi = scanner.nextDouble();
        
        System.out.print("Ingrese el valor de Xs (límite superior): ");
        double Xs = scanner.nextDouble();
        
        System.out.print("Ingrese la tolerancia deseada: ");
        double tolerancia = scanner.nextDouble();
        
        System.out.print("Ingrese el número máximo de iteraciones: ");
        int iteracionesMax = scanner.nextInt();
        
        MetodoBiseccion(Xi, Xs, tolerancia, iteracionesMax);
        
       
    }
    
}
