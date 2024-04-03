package design.time.map;

import java.util.ArrayList;
import java.util.List;

/**
 * TimeBasedValues represents a container for storing values associated with timestamps.
 * It provides methods to manage lists of values and timestamps.
 */
public class TimeBasedValues {
    
    // List to store values associated with timestamps
    protected List<String> values;
    // List to store timestamps
    protected List<String> timestamp;
    
    /**
     * Constructs a new TimeBasedValues object.
     */
    protected TimeBasedValues() {
        // Initialize lists to store values and timestamps
        this.timestamp = new ArrayList<>();
        this.values = new ArrayList<String>();
    }
}

