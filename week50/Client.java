import java.util.Iterator;

public class Client {
    public static void main( String[] args ) {
        BinaryTree<Integer> tree = new BinaryTree<>();


        tree.add( 4 );
        tree.add( 2 );
        tree.add( 6 );
        tree.add( 1 );
        tree.add( 3 );
        tree.add( 5 );
        tree.add( 7 );

        System.out.println( "Inorder" );
        for ( int i : tree ) {
            System.out.println( i );
        }

        tree = new BinaryTree<>();

        tree.add( 1 );
        tree.add( 2 );
        tree.add( 3 );
        tree.add( 4 );
        tree.add( 5 );
        tree.add( 6 );
        tree.add( 7 );

        System.out.println( "Preorder" );
        Iterator<Integer> ite = tree.preOrder();
        while ( ite.hasNext() ) {
            System.out.println( ite.next() );
        }

        tree = new BinaryTree<>();

        tree.add( 7 );
        tree.add( 3 );
        tree.add( 6 );
        tree.add( 1 );
        tree.add( 2 );
        tree.add( 4 );
        tree.add( 5 );

        System.out.println( "PostOrder" );
        ite = tree.postOrder();
        while ( ite.hasNext() ) {
            System.out.println( ite.next() );
        }
    }
}
