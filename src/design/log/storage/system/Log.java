package design.log.storage.system;

public class Log {
	
	private int _id;
	private String value;
	private String timeStamp;
	
	public Log(int id, String value, String timestamp) {
		this._id = id;
		this.value = value;
		this.timeStamp = timestamp;
	}

	public int get_id() {
		return _id;
	}

	public String getValue() {
		return value;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
	
}
