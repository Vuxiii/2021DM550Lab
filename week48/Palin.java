public class Palin {
    public static void main( String[] args ) {
        System.out.println( palindrome( "BooB") );
        System.out.println( palindrome( "BoOoB" ) );
        System.out.println( palindrome( "BoOob" ) );
        System.out.println( palindrome( "William" ) );
    }


    public static boolean palindrome( String s ) {
        return auxPalin( s, 0, s.length()-1 );
    }

    private static boolean auxPalin( String s, int left, int right ) {
        if ( left >= right ) return true;
        return s.charAt(left) == s.charAt(right) && auxPalin(s, left+1, right-1);
    }
}
