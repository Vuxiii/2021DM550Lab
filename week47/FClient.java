import java.util.Scanner;
class FClient {
    public static void main( String[] args ) {
        
        Scanner in = new Scanner( System.in );

        System.out.print( "Please enter an expression to be calculated.\nEvery token must be seperated with a space like this: 2 + 2 * 6\n> " );

        String exp = in.nextLine();
        
        try {
            System.out.println( exp + " = " + Calculator.parse( exp ) );
        } catch (CalculatorException e) {
            
            e.printStackTrace();
        }
        in.close();
    }
}