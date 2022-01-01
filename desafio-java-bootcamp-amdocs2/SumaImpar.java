import java.io.IOException;import java.util.Locale;
import java.util.Scanner;

public class SumaImpar {

	public static void main(String[] args)  throws IOException {
		Scanner sc = new Scanner(System.in);

        int numX = sc.nextInt();  
		int numY = sc.nextInt(); 
        int minorN = numX;
        int majorN = numY;
        int sumOdd = 0;
        if(numY<numX){
            minorN = numY;
            majorN = numX;
        }

        for(int serie = minorN + 1; serie < majorN; serie++){
            if(serie % 2 != 0)
                sumOdd += serie;

        }

        System.out.println(sumOdd);
	}
}