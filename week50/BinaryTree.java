import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<E> implements MyCollection<E>, Iterable<E> {

    private static class Node< T > {
        public T data;

        public Node<T> left, right;

        public Node( T data ) {
            this( data, null, null );
        }

        public Node( T data, Node<T> left, Node<T> right ) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public static<T> void add( Node<T> node, T data ) {
            int leftHeight = minHeight( node.left );
            int rightHeight = minHeight( node.right );
            if ( leftHeight == 0 )
                node.left = new Node<T>( data );
            else if ( rightHeight == 0 )
                node.right = new Node<T>( data );
            else {
                if ( leftHeight <= rightHeight )
                    add( node.left, data );
                else
                    add( node.right, data );
            } 

        };

        public static int minHeight( Node<?> subtree ) {
            if ( subtree == null )
                return 0;
            return Math.min( minHeight( subtree.left ), minHeight( subtree.right ) ) + 1;
        }

        public static int maxHeight( Node<?> node ) {
            if ( node == null )
                return 0;
            return Math.max( maxHeight( node.left ), maxHeight( node.right ) ) + 1;
        }

        public static<T> boolean contains( Node<T> node, T data ) {
            if ( node == null )
                return false;
            return node.data.equals( data ) || 
                contains( node.left, data ) || 
                contains( node.right, data );
        }

        public static int size( Node<?> node ) {
            if ( node == null )
                return 0;
            return 1 + size( node.left ) + size( node.right );
        }

        public static<T> Node<T> copy( Node<T> node ) {
            if ( node == null )
                return null;
            return new Node<T>( node.data, copy(node.left), copy(node.right) );
        }

        public static<T> void mirror( Node<T> node ) {
            if ( node != null ) {
                // Swap
                Node<T> lP = node.left;
                node.left = node.right;
                node.right = lP;
                
                mirror( node.left );
                mirror( node.right );
            }
        }

        public String toString() {
            return data.toString();
            // String s =  "value: " + data.toString();
            // if ( left != null )
            //     s += "\nleft: " + left.toString();
            // if ( right != null )
            //     s += "\nright: " + right.toString();
            // return "[" + s + "]";
        }
    }

    private Node< E > root;
    
    public BinaryTree() {
        root = null;
    }

    /**
     * Returns the element at the root.
     * Precondition: BinaryTree is not empty
     * @return
     */
    public E root() {
        return root.data;
    }

    public BinaryTree<E> left() {
        BinaryTree<E> t = new BinaryTree<>();
        t.root = Node.copy( root.left );
        return t;
    }

    public BinaryTree<E> right() {
        BinaryTree<E> t = new BinaryTree<>();
        t.root = Node.copy( root.right );
        return t;
    }

    /**
     * This method returns the length of the longest path from root to leaf.
     * @return the height of the tree.
     */
    public int height() {
        return Node.maxHeight( root );
    }

    public static void mirror( BinaryTree<?> t ) {
        Node.mirror( t.root );
    }

    @Override
    public void add(E e) {
        if ( root == null )
            root = new Node<E>( e );
        else 
            Node.add( root, e );
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(E e) {
        return Node.contains( root, e );
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return Node.size( root );
    }

    private class postOrderIterator implements Iterator<E> {

        private Stack< Node< E > > nodes;

        public postOrderIterator() {
            nodes = new Stack<>();
            nodes.add( Node.copy(root) );
        }

        @Override
        public boolean hasNext() {
            return !nodes.empty();
        }

        @Override
        public E next() {
            Node< E > node = nodes.pop();

            while ( !(node.left == null && node.right == null) ) {
                nodes.add( node );
                if ( node.right != null ) {
                    nodes.add( node.right );
                    node.right = null;
                }
                if ( node.left != null ) {
                    nodes.add( node.left );
                    node.left = null;
                }
                node = nodes.pop();
            }

            return node.data;
        }
    }

    private class preOrderIterator implements Iterator<E> {

        private Stack< Node< E > > nodes;

        public preOrderIterator() {
            nodes = new Stack<>();
            nodes.add( root );
        }

        @Override
        public boolean hasNext() {
            return !nodes.empty();
        }

        @Override
        public E next() {
            Node<E> node = nodes.pop();
            
            // move nodes to holder
            Stack< Node<E> > holder = new Stack<>();
            
            while ( !nodes.empty() ) {
                holder.add( nodes.pop() );
            }
            // add children to nodes.

            if ( node.right != null )
                nodes.add( node.right );
            if ( node.left != null )
                nodes.add( node.left );

            // Move holder to nodes.
            while ( !holder.empty() )
                nodes.add( holder.pop() );
            
            return node.data;
        }
    }

    private class inOrderIterator implements Iterator<E> {

        private Stack< Node< E > > nodes;

        public inOrderIterator() {
            nodes = new Stack<>();
            if ( root != null )
                nodes.add( Node.copy( root ) );
        }

        @Override
        public boolean hasNext() {
            return !nodes.empty();
        }

        @Override
        public E next() {
            // System.out.println( "Before loop\t" + nodes.toString() );
            Node< E > current = nodes.pop();
            while ( current.left != null ) {
                
                // System.out.println( "Start loop\t" + nodes.toString() );
                
                nodes.add( current );
                nodes.add( current.left );
                // System.out.println( "After add\t" + nodes.toString() );
                current.left = null;
                current = nodes.pop();
                
                // System.out.println( "End loop\t" + nodes.toString() + "\nCurrent  \t" + current.toString() + "\n------------");
            }
            // System.out.println( "Finish  \t" + nodes.toString() + "\nReturning\t" + current.toString() + "\n=========" );
            
            if ( current.right != null )
                nodes.add( current.right );
            return current.data;

        }
        
    }

    @Override
    public Iterator<E> iterator() {
        return new inOrderIterator();
    }

    public Iterator<E> inOrder() {
        return new inOrderIterator();
    }

    public Iterator<E> postOrder() {
        return new postOrderIterator();
    }

    public Iterator<E> preOrder() {
        return new preOrderIterator();
    }

    public BinaryTree<E> copy() {
        BinaryTree<E> t = new BinaryTree<>();
        t.root = Node.copy( root );
        return t;
    }

    public String toString() {
        return "Tree:\n" + root != null ? root.toString() : "IS EMPTY";
    }

    public int hashCode() {
        return 1;
    }

    public boolean equals( Object other ) {
        return false;
    }


}