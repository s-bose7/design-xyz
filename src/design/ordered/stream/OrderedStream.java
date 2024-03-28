package design.ordered.stream;

import java.util.List;
import java.util.ArrayList;

public class OrderedStream{
	
	private int iter;
	private String[] stream;
	// Size of the stream should be kept at this
	private final int STRAM_SIZE;
	
	public OrderedStream(int n) {
		// TODO Auto-generated constructor stub
		this.STRAM_SIZE = n;
		this.iter = 0;
		this.stream = new String[STRAM_SIZE];
	}
	
	
	public List<String> insert(int id, String value) {
		// TODO Auto-generated method stub
		stream[id-1] = value;
		List<String> orderedChunks = new ArrayList<>();
		if(id == iter) {
			while(iter < id && stream[iter] != null) {
				orderedChunks.add(stream[iter++]);
			}
		}
		
		return orderedChunks;
	}

}
