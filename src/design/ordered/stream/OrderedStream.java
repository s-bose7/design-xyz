package design.ordered.stream;

import java.util.List;
import java.util.ArrayList;

public class OrderedStream {
	
	private int iter;
	private String[] stream;
	// Size of the stream should be kept at this
	private final int STREAM_SIZE;
	
	public OrderedStream(int n) {
		// TODO Auto-generated constructor stub
		this.STREAM_SIZE = n;
		this.iter = 0;
		this.stream = new String[STREAM_SIZE];
	}
	
	
	public List<String> insert(int id, String value) {
		// TODO Auto-generated method stub
		List<String> orderedChunks = new ArrayList<>();
		if(id-1 >= STREAM_SIZE) {
			orderedChunks.add("Stream is at capacity");
			return orderedChunks;
		}
		stream[id-1] = value;
		if(id-1 == iter) {
			while(iter < STREAM_SIZE && stream[iter] != null) {
				orderedChunks.add(stream[iter++]);
			}
		}
		return orderedChunks;
	}
	
}
