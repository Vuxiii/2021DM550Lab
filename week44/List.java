import java.util.ArrayList;

class List {
    private ArrayList< String > list;
    List( String[] s ) {
        list = new ArrayList< String >();
        for ( String e : s )
            list.add( e );
    } 

    /**
     * Checks whether this List is empty.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the first element.
     */
    public String head() {
        return list.get( 0 );
    }

    /**
     * Removes the first element.
     */
    public void tail() {
        list.remove( 0 );
    }

    /**
     * Returns a String representation of this List
     */
    public String toString() {
        String a = "";
        for ( String s : list )
            a += s + " ";
        return a;
    }
}