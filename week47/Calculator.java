class Calculator {
    public static Fraction parse( String s ) throws CalculatorException {
        for ( char c : s.toCharArray() )
            if ( !( Character.isDigit( c ) || c == '(' || c == ')' || c == '+' || c == '-' || c == '/' || c == '*' || c == ' ' ) ) 
                throw new CalculatorException( "Only didgets and operators are allowed!" );

        String[] tokens = s.split( " " );
        List list = new List( tokens );
        Fraction out = parseSum( list );
        if ( !list.isEmpty() ) throw new CalculatorException( "Bad expression!" );
        return out;
    }  

    private static Fraction parseSum( List list ) throws CalculatorException {
        Fraction m = parseMult( list );
        while( !list.isEmpty() && ( list.head().equals( "+" ) || list.head().equals( "-" ) ) ) {
            String operator = list.head();
            list.tail();
            m = (operator.equals( "+" ) ? m.add( parseMult( list ) ) : m.subtract( parseMult( list ) ) );
        }
        return m;
    }

    private static Fraction parseMult( List list ) throws CalculatorException {
        Fraction t = parseToken( list );
        while( !list.isEmpty() && ( list.head().equals( "*" ) || list.head().equals( "/" ) ) ) {
            String operator = list.head();
            list.tail();
            if ( operator.equals( "*" ) ) {
                t = t.multiply( parseToken( list ) );
            } else {
                Fraction other = parseToken( list );
                if ( other.numerator() == 0 ) throw new CalculatorException( "Division by zero!" );
                t = t.divide( other );
            }
            // t = ( operator.equals( "*" ) ? t.multiply( parseToken( list ) ) : t.divide( parseToken( list ) ) );
        }
        return t;
    }

    private static Fraction parseToken( List list ) throws CalculatorException {
        Fraction result;
        if ( list.isEmpty() ) throw new CalculatorException( "Incomplete equation!" );
        if ( list.head().equals( "(" ) ) {
            list.tail();
            result = parseSum( list );
            list.tail();
        } else {
            for ( char c : list.head().toCharArray() ) 
                if ( !Character.isDigit( c ) )
                    throw new CalculatorException( "Cannot parse operator " + list.head() + " as integer"); 
            result = new Fraction( Integer.parseInt( list.head() ) );
            list.tail();
        }
        return result;
    }
}