package contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test // test to add a single contact successfully
	void addContactTest() {

		ContactService service = new ContactService();
		service.addContact("3456345655", "John", "Watson", "1231231231", "221B Bakers street");

		List<Contact> list = service.getContactList();
		boolean test = false;
		for (Contact c : list) {
			if (c.getContactID().equals("3456345655")) {
				test = true;
			}
		}
		assertTrue(test);
	}

//Adding multiple contacts without conflicts
	@Test
	void addMultipleContactsTest() {

		ContactService service = new ContactService();
		service.addContact("3456345655", "John", "Watson", "1231231231", "221B Bakers street");
		service.addContact("3456355655", "Freddy", "Krugger", "1231231321", "446 Elm Street");

		assertEquals(2, service.getContactList().size());
	}

//Handling duplicate contact ID errors appropriately

	@Test
	void duplicateIDErrorsTest() {
		ContactService service = new ContactService();

		service.addContact("3456345655", "John", "Watson", "1231231231", "221B Bakers street");

		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("3456345655", "Freddy", "Krugger", "1231231321", "446 Elm Street");
		});

	}

//Adding a contact and successfully retrieving it
	@Test
	void addingContactAndRetrievingTest() {

		ContactService service = new ContactService();
		service.addContact("3456345655", "John", "Watson", "1231231231", "221B Bakers street");

		Contact retrieved = service.getContactList().get(0);

		assertEquals("John", retrieved.getFirstName());
		assertEquals("Watson", retrieved.getLastName());
	}

//Updating existing contact information

	@Test
	void updateExistingContactTest() {
		ContactService service = new ContactService();
		service.addContact("3456345655", "John", "Watson", "1231231231", "221B Bakers street");
		service.updateContact("3456345655", "Sherlock", "Holmes", "4444444444", "Westschire Street");

		Contact updated = service.getContactList().get(0);

		assertEquals("Sherlock", updated.getFirstName());
		assertEquals("Holmes", updated.getLastName());
		assertEquals("4444444444", updated.getPhone());
		assertEquals("Westschire Street", updated.getAddress());
	}


//Deleting contacts from the service

	@Test
	void DeletingContactTest() {

		ContactService service = new ContactService();
		service.addContact("3456345655", "John", "Watson", "1231231231", "221B Bakers street");
		assertEquals(1, service.getContactList().size());

		service.deleteContact("3456345655");
		assertEquals(0, service.getContactList().size());
	}
}

