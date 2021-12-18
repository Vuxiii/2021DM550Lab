import java.util.Spliterators.AbstractIntSpliterator;

public class Perm {
    public static void main( String[] args ) {
        permutations( args[0] );
    }

    public static void permutations( String s ) {
        boolean[] used = new boolean[ s.length() ];
        for ( int i = 0; i < used.length; i++ ) 
            used[i] = false;
        auxPerm( s.toCharArray(), "", used, 0 );
    }   

    public static void auxPerm( char[] cs, String out, boolean[] used, int depth ) {
        if ( depth == cs.length ) {
            System.out.println( out );
        }
        for ( int i = 0; i < cs.length; i++ ) {
            if ( !used[i] ) {
                used[i] = true;
                auxPerm( cs, out + cs[i], used, depth+1 );
                used[i] = false;
            }
        }
    }
}