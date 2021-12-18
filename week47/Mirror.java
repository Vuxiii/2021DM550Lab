import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Mirror{ 
    public static void main( String[] args ) {

        if ( args.length != 1 )
            return;
        
        try {
            Scanner reader = new Scanner( new File( args[0] ) );
            BufferedWriter out = new BufferedWriter( new FileWriter( reverse(args[0]) ) ); 

            while( reader.hasNextLine() ) {
                out.write( reverse( reader.nextLine() ) );
                out.newLine();
            }

            reader.close();
            out.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( "The given file " + args[0] + " was not found." );
        } catch( IOException e ) {
            System.out.println( "Something happend trying to write to file " + reverse( args[0] ) );
        }
    }

    public static String reverse( String s ) {
        String out = "";
        for ( char c : s.toCharArray() )
            out = c + out;
        return out;
    }
}