package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

	private ArrayList<Contact> contactList;

	public ContactService() {
		contactList = new ArrayList<>();
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		for (Contact c : contactList) {
			if (c.getContactID().equals(contactID)) {
				throw new IllegalArgumentException("duplicate contactID");
			}

		}
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		contactList.add(newContact);
	}

	public void deleteContact(String contactID) {
		contactList.removeIf(c -> c.getContactID().equals(contactID));
	}

	public void updateContact(String contactID, String newFirstName, String newLastName, String newPhone,
			String newAddress) {
		boolean found = false;
		for (Contact c : contactList) {
			if (c.getContactID().equals(contactID)) {
				found = true;
				c.setFirstName(newFirstName);
				c.setLastName(newLastName);
				c.setPhone(newPhone);
				c.setAddress(newAddress);
				break;
			}
		}
		if (!found) {
			throw new IllegalArgumentException("Given ID does not exist");
		}
	}
}
