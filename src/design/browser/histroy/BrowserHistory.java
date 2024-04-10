package design.browser.histroy;

import java.util.ArrayList;
import java.util.List;

/**
 * BrowserHistory class represents a simple browser history functionality.
 * It allows users to navigate through visited tabs using back and forward operations.
 */
public class BrowserHistory {
	
	// List to store the tab history
    private List<String> tabHistory;
    // Current index in the tab history
    private int index;
    // Length of the tab history
    private int length;

    /**
     * Constructor to initialize the browser history with a homepage.
     * @param homepage The homepage URL to start with.
     */
    public BrowserHistory(String homepage) {
        // Initialize index to 0
        this.index = 0;
        // Initialize the tabHistory list with an ArrayList
        this.tabHistory = new ArrayList<String>();
        // Add the homepage URL to the tabHistory list
        tabHistory.add(homepage);
        // Set the length of the tab history to 1
        this.length = 1;
    }

    /**
     * Visit a new URL, adding it to the tab history.
     * @param url The URL to visit.
     */
    public void visit(String url) {
        // Add the new URL to the tab history at the next index
        tabHistory.add(++index, url);
        // Update the length of the tab history
        length = index + 1;
    }

    /**
     * Navigate backward in the tab history by the given number of steps.
     * @param steps The number of steps to move backward.
     * @return The URL after moving backward in history.
     */
    public String back(int steps) {
        // Update the index to move backward by the given steps, 
    	// ensuring it does not go below 0
        index = Math.max(index - steps, 0);
        // Return the URL at the updated index
        return tabHistory.get(index);	        
    }

    /**
     * Navigate forward in the tab history by the given number of steps.
     * @param steps The number of steps to move forward.
     * @return The URL after moving forward in history.
     */
    public String forward(int steps) {
        // Update the index to move forward by the given steps, 
    	// ensuring it does not exceed the length of the tab history
        index = Math.min(index + steps, length - 1);
        // Return the URL at the updated index
        return tabHistory.get(index);
    }
}





