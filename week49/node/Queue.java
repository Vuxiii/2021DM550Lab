import java.util.Iterator;



public class Queue<E> implements MyCollection<E>, Iterable<E> {
    private static class Node<T> {
        T val;
        Node<T> next;
        
        public Node( T val ) {
            next = null;
            this.val = val;
        }

        public boolean contains( T el ) {
            return val.equals( el ) || ( next != null && next.contains( el ) );
        }

        public static int size( Node<?> current ) {
            return current == null ? 0 : 1 + Node.size( current.next );
        }

        public Node<T> copy() {
            Node<T> n = new Node<>(val);
            n.next = next == null ? null : next.copy();
            return n;
        }

        public String toString() {
            return next == null ? val.toString() : val.toString() + ", " + next.toString();
        }

        public boolean equals( Object other ) {
            if ( other == null )
                return false;
            if ( ! (other instanceof Node) )
                return false;
            Node<?> on = (Node<?>) other;
            return val.equals( on.val ) && (
                ( next == null && on.next == null ) || 
                ( next != null && next.equals( on.next ) ) );
        }

    }

    private Node<E> head, tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public E next() {
        E val = head.val;
        head = head.next;
        return val;
    }

    @Override
    public void add(E e) {
        if ( head == null ) {
            head = new Node<E>( e );
            tail = head;
        } else {
            tail.next = new Node<E>( e );
            tail = tail.next;
        }        
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(E el) {
        return head != null && head.contains( el );
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return Node.size( head );
    }

    private class Ite implements Iterator<E> {
        Node<E> current;
        public Ite() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E val = current.val;
            current = current.next;
            return val;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Ite();
    }

    public Queue<E> copy() {
        Queue<E> q = new Queue<>();
        q.head = head == null ? null : head.copy();
        
        Node<E> t = null;

        for( Node<E> cur = q.head; cur != null; cur = cur.next )
            t = cur;
        q.tail = t;
        
        return q;
    }

    public String toString() {
        return head == null ? "[]" : "[ " + head.toString() + " ]";
    }

    public boolean equals( Object other ) {
        if ( other == null ) 
            return false;
        if ( ! (other instanceof Queue<?>) )
            return false;
        if ( other == this )
            return true;
        Queue<?> q = (Queue<?>) other;
        return head == null && q.head == null ? true : head.equals( q.head );
    }
}
