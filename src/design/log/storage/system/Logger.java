package design.log.storage.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Logger class represents a log storage system that supports storing logs and querying logs based on 
 * a timestamp range and granularity.
 */
public class Logger {
	
	private List<Log> logStore;
	private int size;
	private Map<String, Integer> granularityToIndexMap;
	private static final int MAX_CAPACITY = 100000;
	/**
     * Constructs a Logger object with an empty log store and initializes the granularity to index map.
     */
	public Logger() {
		this.size = 0;
		this.logStore = new ArrayList<Log>();
		this.granularityToIndexMap = new HashMap<>();
		startGranularityMapper();
	}
	/**
     * Initializes the granularity to index map with predefined granularities and their corresponding 
     * index in the timestamp string.
     */
	private void startGranularityMapper() {	
		int[] granularityIndex = new int[] {4, 7, 10, 13, 16, 19};
		String[] granularities = new String[] {"Year", "Month", "Day", "Hour", "Minuite", "Second"};
		for(int i=0; i<granularities.length; i++) {
			granularityToIndexMap.put(granularities[i], granularityIndex[i]);
		}
	}
	/**
     * Stores a log with the given id, timestamp, and value in the log store.
     * @param id The unique identifier of the log.
     * @param timestamp The timestamp of the log.
     * @param value The value string of the log.
     * @return true if the log is successfully stored, false otherwise.
     */
	public boolean store(int id, String timestamp, String value) {
		if(size == MAX_CAPACITY) {
			return false;
		}
		logStore.add(new Log(id, value, timestamp));
		++size;
		return true;
	}
	/**
     * Queries logs within the specified timestamp range and granularity.
     * @param startTime The start timestamp of the query range.
     * @param endTime The end timestamp of the query range.
     * @param granularity The granularity of the query (e.g., "Year", "Month", "Day").
     * @return A list of log id whose timestamp are within the specified range and granularity.
     */
	public List<Integer> Query(String startTime, String endTime, String granularity){
		List<Integer> results = new ArrayList<>();
		if(!granularityToIndexMap.containsKey(granularity)) {
			return results;
		}
		int index = granularityToIndexMap.get(granularity);
		String start = startTime.substring(0, index);
		String end = endTime.substring(0, index);
		for(Log log : logStore) {
			String timestampString = log.getTimeStamp().substring(0, index);
			// compare them lexicographically
			if(start.compareTo(timestampString) <= 0 && timestampString.compareTo(end) <= 0) {
				results.add(log.get_id());
			}
		}
		return results;
	}
	
	
	
	
}
