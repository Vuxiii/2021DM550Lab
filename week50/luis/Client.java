import java.util.ArrayList;
import java.util.List;

public class Client{ 
    public static void main( String[] args ) {
        BinaryTree<Integer> t = new BinaryTree<>();
        t.add( 1 );
        t.add( 1 );
        t.add( 1 );
        t.add( 1 );
        t.add( 1 );
        t.add( 1 );
        System.out.println( sum( t ) );
    }


    public static double sum( BinaryTree<Integer> t ) {
        return t.root() + (!t.left().isEmpty() ? sum( t.left() ) : 0 ) + (!t.right().isEmpty() ? sum( t.right() ) : 0 );
    }

    public static int zeros( BinaryTree<Integer> t ) {
        if ( t.isEmpty() )
            return 0;
        return (t.root() == 0 ? 1 : 0) + zeros( t.left() ) + zeros( t.right() );
    }

    public static int count( BinaryTree<String> t, String s ) {
        if ( t.isEmpty() )
            return 0;
        return ( t.root().equals(s) ? 1 : 0 ) + count( t.left(), s ) + count( t.right(), s );
    }

    public static<E> List<E> toArrayList( BinaryTree<E> t ) {
        List<E> list = new ArrayList<>();
        toArrayListAux( t, list );
        return list;
    }

    private static<E> void toArrayListAux( BinaryTree<E> t, List<E> list ) {
        if ( t.size() != 0 ) {
            list.add( t.root() );
            toArrayListAux( t.left(), list );
            toArrayListAux( t.right(), list );
        }
    }

    public static List<Integer> selectLarger( BinaryTree<Integer> t, int n ) {
        List<Integer> list = new ArrayList<>();
        selectLargerAux( t, list, n );
        return list;
    }
    private static void selectLargerAux( BinaryTree<Integer> t, List<Integer> list, int n ) {
        if ( t.size() != 0 ) {
            if ( t.root() < n )
                list.add( t.root() );
            toArrayListAux( t.left(), list, n );
            toArrayListAux( t.right(), list, n );
        }
    }
    public static int mostLeftTurns( BinaryTree<?> t ) {
        if ( t.isEmpty() )
            return 0;
        int left = mostLeftTurns( t.left() ) + (t.left().isEmpty() ? 0 : 1);
        int right = mostLeftTurns( t.right() );
        return Math.max( left, right );
    }
}