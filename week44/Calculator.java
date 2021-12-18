class Calculator {
    public static Fraction parse( String s ) {
        String[] tokens = s.split( " " );
        List list = new List( tokens );
        return parseSum( list );
    }  

    private static Fraction parseSum( List list ) {
        Fraction m = parseMult( list );
        while( !list.isEmpty() && ( list.head().equals( "+" ) || list.head().equals( "-" ) ) ) {
            String operator = list.head();
            list.tail();
            m = (operator.equals( "+" ) ? m.add( parseMult( list ) ) : m.subtract( parseMult( list ) ) );
        }
        return m;
    }

    private static Fraction parseMult( List list ) {
        Fraction t = parseToken( list );
        while( !list.isEmpty() && ( list.head().equals( "*" ) || list.head().equals( "/" ) ) ) {
            String operator = list.head();
            list.tail();
            t = ( operator.equals( "*" ) ? t.multiply( parseToken( list ) ) : t.divide( parseToken( list ) ) );
        }
        return t;
    }

    private static Fraction parseToken( List list ) {
        Fraction result;
        if ( list.head().equals( "(" ) ) {
            list.tail();
            result = parseSum( list );
            list.tail();
        } else {
            result = new Fraction( Integer.parseInt( list.head() ) );
            list.tail();
        }
        return result;
    }
}