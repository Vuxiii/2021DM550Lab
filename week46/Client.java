class Client {
    public static void main( String[] args ) {
        Safe safe = new Safe( new int[] { 3, -3, 2, 0 } );

        safe.insert( 3 );
        safe.insert( -3 );
        safe.insert( 2 );
        safe.insert( 0 );
        safe.store( "Abekat" );
        System.out.println( safe.contents() );
        safe.insert( 2 );
        safe.reset();
        System.out.println( safe.contents() );

    }

    /**
     * Hej med jer H7.
     * Precondition: Det her skal gælde!
     * @param asd asd is the source
     * @param abe The monkey.
     * @return Returns true if a otherwise false.
     */
    public boolean cirkus( String asd, String abe ) {
        return false;
    }
}