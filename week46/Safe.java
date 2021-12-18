class Safe {
    private int lockPointer = 0;
    private int[] lock;

    private String secret = "";

    public Safe( int[] key ) {
        lock = new int[key.length];
        for ( int i = 0; i < key.length; i++ )
            lock[i] = key[i];
    }

    /**
     * Checks whether this safe is locked.
     * @return whether this safe is locked.
     */
    public boolean locked() {
        return lockPointer != lock.length;
    }

    /**
     * If the this safe is unlocked, store the given secret
     * @param sec the secret to be stored.
     */
    public void store( String sec ) {
        if ( !locked() )
            secret = sec;
    }

    /**
     * Returns the contents of this safe if it is unlocked.
     * @return the contents of this safe.
     */
    public String contents() {
        if ( !locked() )
            return secret;
        return null;
    }

    /**
     * Inputs a single number into this safe.
     * @param n the number to be inputted.
     */
    public void insert( int n ) {
        if ( lockPointer >= lock.length )
            lockPointer = 0;
        else if ( lock[ lockPointer ] == n )
            lockPointer++;
        else
            lockPointer = 0;
    }

    /**
     * Fully locks this safe.
     */
    public void reset() {
        lockPointer = 0;
    }
}