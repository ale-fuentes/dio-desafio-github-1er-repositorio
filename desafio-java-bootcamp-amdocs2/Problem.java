import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
	
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter N of factorial: ");
    int numN = scanner.nextInt();
    int factorialN = 1;
    
    for(int serie = 0; serie < numN; serie++){
      factorialN *= numN-serie;
    }
    
    System.out.println(factorialN);

	}
}