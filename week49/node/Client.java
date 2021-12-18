public class Client{
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
        for ( int i : q ) {
            System.out.println( i );
        }
        

        Queue<Integer> q2 = q.copy();
        
        q2.next();
        
        System.out.println( q2.equals( q ));
        for ( int i : q2 ) {
            System.out.println( i );
        }
    }
}