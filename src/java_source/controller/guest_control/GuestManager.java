package java_source.controller.guest_control;

import java_source.controller.abstracts.Manager;
import java_source.controller.customer_control.CustomerManager;
import java_source.model.Guest;

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
