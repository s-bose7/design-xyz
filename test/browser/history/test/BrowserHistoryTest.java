package browser.history.test;

import static org.junit.Assert.*;

import org.junit.Test;

import design.browser.histroy.BrowserHistory;

public class BrowserHistoryTest {

	@Test
	public void testBrowserHistory() {
		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		
		browserHistory.visit("google.com");
		browserHistory.visit("facebook.com");
		browserHistory.visit("youtube.com");  
		
		assertEquals("facebook.com", browserHistory.back(1));
		assertEquals("google.com", browserHistory.back(1));
		assertEquals("facebook.com", browserHistory.forward(1));
		browserHistory.visit("linkedin.com"); 
		assertEquals("linkedin.com", browserHistory.forward(2));
		assertEquals("google.com", browserHistory.back(2));
		assertEquals("leetcode.com", browserHistory.back(7));
		
	}

}
