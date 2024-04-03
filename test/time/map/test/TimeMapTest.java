package time.map.test;

import static org.junit.Assert.*;

import org.junit.Test;
import design.time.map.TimeMap;

public class TimeMapTest {

	@Test
	public void TimeMap() {
		TimeMap tMap = new TimeMap();
		tMap.set("foo", "bar", "2027:09:26:00:00:01");
		
		assertEquals("bar", tMap.get("foo", "2027:09:26:00:00:00"));
		assertEquals("bar", tMap.get("foo", "2027:09:26:00:00:03"));
		
		tMap.set("foo", "bar2", "4");
		
		assertEquals("bar2", tMap.get("foo", "2027:09:26:00:00:04"));
		assertEquals("bar2", tMap.get("foo", "2027:09:26:00:00:05"));
	}
	

}
