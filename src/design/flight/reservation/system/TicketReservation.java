package design.flight.reservation.system;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

	private static final int CONFIRMEDLIST_LIMIT = 10;
	private static final int WAITINGLIST_LIMIT = 3;

	private List<Passenger> confirmedList = new ArrayList<>();
	private Deque<Passenger> waitingList = new ArrayDeque<>();

	// This getter is used only by the junit test case.
	public List<Passenger> getConfirmedList() {
		return this.confirmedList;
	}

	public Deque<Passenger> getWaitingList() {
		return this.waitingList;
	}

	public void setWaitingList(Deque<Passenger> waitingList) {
		this.waitingList = waitingList;
	}

	/**
	 * Returns true if passenger could be added into either confirmedList or
	 * waitingList. Passenger will be added to waitingList only if confirmedList is
	 * full.
	 * 
	 * Return false if both passengerList & waitingList are full
	 */
	public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,
			String confirmationNumber) {
		Passenger newPassenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
		if(this.confirmedList.size() < TicketReservation.CONFIRMEDLIST_LIMIT) {
			confirmedList.add(newPassenger);
			return true;
			
		}else if(this.waitingList.size() < TicketReservation.WAITINGLIST_LIMIT) {
			waitingList.add(newPassenger);
			return true;
		}
		return false;
	}

	/**
	 * Removes passenger with the given confirmationNumber. Passenger could be in
	 * either confirmedList or waitingList. The implementation to remove the
	 * passenger should go in removePassenger() method and removePassenger method
	 * will be tested separately by the uploaded test scripts.
	 * 
	 * If passenger is in confirmedList, then after removing that passenger, the
	 * passenger at the front of waitingList (if not empty) must be moved into
	 * passengerList. Use poll() method (not remove()) to extract the passenger from
	 * waitingList.
	 */
	public boolean cancel(String confirmationNumber) {
		boolean removed = removePassenger(confirmedList.iterator(), confirmationNumber);
		if(removed) {
			Passenger nextPassenger = waitingList.poll();
			if(nextPassenger != null) {
				confirmedList.add(nextPassenger);
			}
		}else {
			removed = removePassenger(waitingList.iterator(), confirmationNumber);
		}
		return removed;
	}

	/**
	 * Removes passenger with the given confirmation number. Returns true only if
	 * passenger was present and removed. Otherwise, return false.
	 */
	public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
		while(iterator.hasNext()) {
			Passenger currPassenger = iterator.next();
			if(currPassenger.getConfirmationNumber().equals(confirmationNumber)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

}
