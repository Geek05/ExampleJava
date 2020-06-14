package loggging;

import lombok.extern.java.Log;

import java.util.logging.Logger;

/**
 * @author Bharath.MC
 * @since Mar-2020
 */
public class LogExample {

    private static final Logger log = Logger.getLogger(LogExample.class.getName());

    public static void main(String... args) {

        System.setProperty("java.util.logging.config.file", "src/main/lib/abc.log");
        System.out.println(System.getProperty("java.util.logging.config.file") + " , " + System.getenv("java.util.logging.config.file"));
        log.info("Something's wrong here");
    }
}