import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int numN = sc.nextInt();
        /*
        Math.pow(argumento, 1.0/2.0); // Esto es para sacar la raiz cuadrada
        Math.pow(argumento, 1.0/3.0); // Esto es para sacar la raiz cúbica
        Math.pow(X, (double)1/ n)
        El método pow espera double, realizar un casting... 
        si no realizas el casting (double) pues el compilador
        interpreta la división como un entero y el resultado 
        entero de la división 1/n para toda n es 0. 
        Por lo que amigo, en todo caso, el compilador muestra 
        el número elevado a la 0. Que en todos los casos es 1...
        */
        double raizQuadradaDeCinco = Math.pow(5, 1.0/2.0);
        double parteA = Math.pow(((1 + raizQuadradaDeCinco) / 2), numN);
        double parteB = Math.pow(((1 - raizQuadradaDeCinco) / 2), numN);
        double fibonacciDeN = (parteA - parteB) / raizQuadradaDeCinco;

        System.out.println(String.format("%.1f", fibonacciDeN));
	}
}