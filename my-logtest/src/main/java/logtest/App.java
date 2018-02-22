package logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static void main( String[] args ) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");
        System.out.println( "Hello World!" );
    }
}
