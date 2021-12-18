public class ImageCoder {

    public static void addRectangle( Image image, int x, int y, int width, int height, int red, int green, int blue ) {
        for ( int j = y; j < y+height; j++ ) {
            for ( int i = x; i < x+width; i++ ) {
                image.setPixel( i, j, red, green, blue );
                
            }
        }
    }

    public static void addCircle( Image image, int x, int y, int r, int red, int green, int blue ) {
        for ( int j = y-r; j < y+r; j++ ) {
            for ( int i = x-r; i < x+r; i++ ) {
                if ( (i - x)*(i - x) + (j - y)*(j - y) <= r*r ) {
                    image.setPixel( i, j, red, green, blue );
                }
            }
        }
    }
    /**
    public static void encrypt( Image image, String key ) {
        int index = 0;
        for ( int y = 0; y < image.height(); y++ ) {
            for ( int x = 0; x < image.width(); x++ ) {
                if ( !(y == 0 && x == 0) ) {
                    int xIndex = (x == 0 ? image.width()-1 : x-1);
                    int yIndex = (xIndex == x-1 ? y : y-1);
                    int red = (image.red( xIndex, yIndex ) + image.red( x, y ) + key.charAt( index )) % 256 ;
                    int green = (image.green( xIndex, yIndex ) + image.green( x, y ) + key.charAt( index )) % 256 ;
                    int blue = (image.blue( xIndex, yIndex ) + image.blue( x, y ) + key.charAt( index )) % 256 ;
                    image.setPixel( x, y, red, green, blue );
                    index = ( index + 1 ) % key.length();
                }
            }   
        }
    }

    public static void decrypt( Image image, String key ) {
        int index = 0; // ( image.height() * image.width() - 1) % key.length()

        for ( int y = 0; y < image.height(); y++ ) {
            for ( int x = 0; x < image.width(); x++ ) {
                if ( !(y == 0 && x == 0) ) {
                    int xIndex = (x == 0 ? image.width()-1 : x-1);
                    int yIndex = (xIndex == x-1 ? y : y-1);
                    int red = 512 + image.red( x, y ) - image.red( xIndex, yIndex ) - key.charAt( index );
                    int green = 512 + image.green( x, y ) - image.green( xIndex, yIndex ) - key.charAt( index );
                    int blue = 512 + image.blue( x, y ) - image.blue( xIndex, yIndex ) - key.charAt( index );
                    red = red % 256;
                    green = green % 256;
                    blue = blue % 256;
                    // while ( red < 0 )
                    //    red = red + 256;
                    //while ( green < 0 )
                    //    green = green + 256;
                    //while ( blue < 0 )
                    //    blue = blue + 256;
                    
                    
                    image.setPixel( x, y, red, green, blue );
                    index = (index + 1) % key.length(); //  = ( index == 0 ? key.length()-1 : index - 1)
                }
            }   
        }
    }
    */
     /*
     * Encrypts the picture with a given key.
     */
    public static void encrypt(Image image, String key) {
        int index = 0, red = 0, green = 0, blue = 0;
        for (int i=0; i<image.width(); i++)
            for (int j=0; j<image.height(); j++) {
            red = (red + image.red(i,j) + key.charAt(index%key.length()))%256;
            index ++;
            green = (green + image.green(i,j) + key.charAt(index%key.length()))%256;
            index ++;
            blue = (blue + image.blue(i,j) + key.charAt(index%key.length()))%256;
            index ++;
            image.setPixel(i,j,red,green,blue);
            }
        }
    
        /*
         * Decrypts the picture with a given key.
         */
        public static void decrypt(Image image, String key) {
        int index = 0, red = 0, green = 0, blue = 0, oldRed = 0, oldGreen = 0, oldBlue = 0;
        for (int i=0; i<image.width(); i++)
            for (int j=0; j<image.height(); j++) {
            red = (512 + image.red(i,j) - oldRed - key.charAt(index%key.length()))%256;
            index ++;
            green = (512 + image.green(i,j) - oldGreen - key.charAt(index%key.length()))%256;
            index ++;
            blue = (512 + image.blue(i,j) - oldBlue - key.charAt(index%key.length()))%256;
            index ++;
            oldRed = image.red(i,j);
            oldGreen = image.green(i,j);
            oldBlue = image.blue(i,j);
            image.setPixel(i,j,red,green,blue);
            }
        }


}