import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements MyCollection<E>, Iterable<E> {

    private E[] v;
    private int insertPointer, retPointer;

    public Queue() {
        v = (E[]) new Object[10];
        insertPointer = 0;
        retPointer = 0;
    }

    public E next() {
        E val =v[retPointer]; 
        retPointer = ( retPointer + 1) % v.length;
        return val;
    }

    public void add( E el ) {
        v[insertPointer] = el;
        insertPointer = ( insertPointer + 1 ) % v.length;

        if ( insertPointer == retPointer ) {
            E[] hold = (E[]) new Object[v.length * 2];
            for ( int i = 0; i < v.length; i++ )
                hold[i] = v[( retPointer + i ) % v.length];
            retPointer = 0;
            insertPointer = v.length;
            v = hold;
        }
    }

    private class Ite implements Iterator<E> {
        private int pointer;
        @Override
        public boolean hasNext() {
            return pointer != insertPointer;
        }

        @Override
        public E next() throws NoSuchElementException {
            if ( !hasNext() ) throw new NoSuchElementException( "No Elements left" );
            E val = v[pointer];
            pointer = (pointer + 1) % v.length;
            return val;
        }
        
    }

    @Override
    public Iterator<E> iterator() {
        return new Ite();
    }

    @Override
    public void clear() {
        insertPointer = 0;
        retPointer = 0;
    }

    @Override
    public boolean contains(E e) {
        boolean found = false;
        for ( int i = retPointer; i != (retPointer + size()) % v.length; i = (i+1) % v.length ) {
            if ( v[i].equals( e ) ) 
                found = true;
        }
        return found;
    }

    @Override
    public boolean isEmpty() {
        return retPointer == insertPointer;
    }

    @Override
    public int size() {
        if ( retPointer > insertPointer )
            return insertPointer + ( v.length - retPointer );
        else    
            return insertPointer - retPointer;
    }

}