package design.time.map;

import java.util.HashMap;
import java.util.Map;

/**
 * TimeMap is a data structure that stores time-based key-value pairs.
 * It allows storing multiple values for the same key at different timestamps
 * and retrieving the value of a given key at a certain timestamp.
 */
public class TimeMap {

    // Map to store key-value pairs where the value is a list of values associated with timestamps
    Map<String, TimeBasedValues> timeBasedKeyValueStoreMap;

    /**
     * Constructs a new TimeMap object.
     */
    public TimeMap() {
        // Initialize the map
        this.timeBasedKeyValueStoreMap = new HashMap<String, TimeBasedValues>();
    }

    /**
     * Stores the given key-value pair at the specified timestamp.
     *
     * @param key       The key to store.
     * @param value     The value to store.
     * @param timestamp The timestamp associated with the value.
     */
    public void set(String key, String value, String timestamp) {
        // If key is not present in the map, create a new entry
        if (!timeBasedKeyValueStoreMap.containsKey(key)) {
            TimeBasedValues newTimeBasedValues = new TimeBasedValues();
            newTimeBasedValues.values.add(value);
            newTimeBasedValues.timestamp.add(timestamp);
            timeBasedKeyValueStoreMap.put(key, newTimeBasedValues);
            return;
        }
        // If key is present, add the value to the existing entry
        TimeBasedValues localStoredTimeBasedValues = timeBasedKeyValueStoreMap.get(key);
        localStoredTimeBasedValues.values.add(value);
        localStoredTimeBasedValues.timestamp.add(timestamp);
    }

    /**
     * Retrieves the value of the given key at the specified timestamp.
     *
     * @param key       The key to retrieve.
     * @param timestamp The timestamp to retrieve the value at.
     * @return The value associated with the given key and timestamp.
     */
    public String get(String key, String timestamp) {
        // Retrieve the stored values for the given key
        TimeBasedValues localTimeBasedValues = timeBasedKeyValueStoreMap.get(key);
        if (localTimeBasedValues == null) {
            return "";
        }
        // If no timestamp is less than or equal to the specified timestamp, return ""
        if (localTimeBasedValues.timestamp.get(0).compareTo(timestamp) <= 0) {
            return "";
        }
        // Find the largest timestamp previous to the specified timestamp and return its associated value
        StringBuilder valueString = getLargestTimeStampPrevious(timestamp, localTimeBasedValues);
        return valueString.toString();
    }

    /**
     * Finds the largest timestamp previous to the specified timestamp and returns its associated value.
     *
     * @param timestamp The timestamp to find the previous value for.
     * @param localTvalues The TimeBasedValues object containing the timestamps and values.
     * @return The value associated with the largest timestamp previous to the specified timestamp.
     */
    private StringBuilder getLargestTimeStampPrevious(String timestamp, TimeBasedValues localTvalues) {
        if (localTvalues == null) {
            throw new IllegalArgumentException("values can't be null");
        }

        int size = localTvalues.timestamp.size();
        int left = 0, right = size - 1;
        // Binary search to find the largest timestamp previous to the specified timestamp
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String localTimeStamp = localTvalues.timestamp.get(mid);
            if (localTimeStamp.compareTo(timestamp) <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new StringBuilder(localTvalues.values.get(right));
    }
}
