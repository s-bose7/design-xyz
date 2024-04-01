package log.storage.system.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import design.log.storage.system.Logger;



public class LoggerTest {

    @Test
    public void testStore() {
        Logger logger = new Logger();
        assertTrue(logger.store(1, "2017:01:01:23:59:59", generateRandomString(4)));
        assertTrue(logger.store(2, "2017:01:24:22:10:15", generateRandomString(4)));
        assertTrue(logger.store(3, "2017:01:24:22:59:59", generateRandomString(4)));
        assertTrue(logger.store(4, "2017:02:01:23:59:59", generateRandomString(4)));
        
    }
    
    public static String generateRandomString(int length) {
    	Random random = new Random();
    	StringBuilder sb = new StringBuilder();
    	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
    
    @Test
    public void testQuery() {
        Logger logger = new Logger();
        logger.store(1, "2017:01:01:23:59:59", generateRandomString(5));
        logger.store(2, "2017:01:01:22:59:59", generateRandomString(5));
        logger.store(3, "2016:01:01:00:00:00", generateRandomString(4));
        List<Integer> results = logger.Query("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        assertEquals(3, results.size());
        assertEquals(1, (int) results.get(0));
        assertEquals(2, (int) results.get(1));
        assertEquals(3, (int) results.get(2));
        results = logger.Query("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
        assertEquals(2, results.size());
        assertEquals(1, (int) results.get(0));
        assertEquals(2, (int) results.get(1));
    }
}
