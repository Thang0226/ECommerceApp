package java.controller;

import java.model.Guest;

public class GuestManager extends Manager<Guest> {
	private static GuestManager guestManager;

	private GuestManager(String filePath) {
		super(filePath);
	}
	// Singleton
	public static GuestManager getInstance(String filePath) {
		if (guestManager == null) {
			synchronized (CustomerManager.class) {
				if (guestManager == null) {
					guestManager = new GuestManager(filePath);
				}
			}
		}
		return guestManager;
	}
}
