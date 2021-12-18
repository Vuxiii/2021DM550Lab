public class Client {
    public static void main( String[] args ) {
        Queue<Integer> q = new Queue<>();

        q.add( 1 );
        q.add( 2 );
        q.add( 3 );
        q.add( 4 );
        q.add( 5 );
        q.add( 6 );
        q.add( 7 );
        q.add( 8 );
        q.add( 9 );
        q.add( 10 );
        q.add( 11 );

        for ( Integer i : q ) {
            System.out.println( i );
        }

        System.out.println( q.contains( 2 ) );
        while( !q.isEmpty() )
            System.out.println( q.next() );

        System.out.println( q.contains( 2 ) );
    }
}
