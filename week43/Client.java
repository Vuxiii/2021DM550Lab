public class Client {
    public static void main( String[] args ) {
        Image img = new Image( "cat.jpg" );

        ImageCoder.addRectangle( img, 100, 100, 100, 100, 255, 0, 0 );
        ImageCoder.addCircle( img, 75, 75, 50, 0, 255, 255);
        img.display();
        ImageCoder.encrypt( img, "aæsaihfæoaiwhfnlsanflaf" );
        img.display();
        ImageCoder.decrypt( img, "aæsaihfæoaiwhfnlsanflaf" );
        img.display();
    }
}
