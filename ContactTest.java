package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@SuppressWarnings("unused")
class ContactTest {
//test creating a contact
	@Test
	void testContactcreation() {
		Contact contact = new Contact (
				"123456", 
				"Bilbo",
				"Baggins",
				"1001001000", 
				"256 sesame street"
	);
		
		assertEquals("123456",
				contact.getContactID());
		assertEquals("Bilbo",
				contact.getFirstName());
		assertEquals("Baggins",
				contact.getLastName());
		assertEquals("1001001000",
				contact.getPhone());
		assertEquals("256 sesame street",
				contact.getAddress());
	}

	

	//testing for First name over 10 letters
	@Test
	void testInvalidFirstName() {
		Contact contact = new Contact (
				"123456", 
				"Bibi",
				"Baggins",
				"1001001000", 
				"256 sesame street"
				);
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("bibibibibibibi");
		});
	}

	//testing null name
@Test
void testnullFirstName() {
	assertThrows(IllegalArgumentException.class, () -> {
		new Contact(
			"123456", 
			null,
			"Baggins",
			"1001001000", 
			"256 sesame street"
			);
	
			});
} 

//testing for Last name over 10 letters
	@Test
	void testInvalidLastName() {
		Contact contact = new Contact (
				"123456", 
				"Bibi",
				"Baggins",
				"1001001000", 
				"256 sesame street"
				);
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("FrodoBaggins");
		});
	}
	
//testing for invalid Address
	@Test
	void testInvalidAddress() {
		Contact contact = new Contact (
				"123456", 
				"Bibi",
				"Baggins",
				"1001001000", 
				"256 sesame street"
				);
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("1234567891011121314151617181910101919191919191919191919199119919191");
		});
	}
	

//testing for phone over 10 numbers
	@Test
	void testInvalidphone() {
		Contact contact = new Contact (
				"123456", 
				"Bibi",
				"Baggins",
				"1001001000", 
				"256 sesame street"
				);
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("11111111111");
		});
	}


//testing for empty phone 
	@Test
	void testInvalidphone2() {
		Contact contact = new Contact (
				"123456", 
				"Bibi",
				"Baggins",
				"1001001000", 
				"256 sesame street"
				);
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("");
		});
	}
	//testing null phone
	@Test
	void testnullPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"123456", 
				"bibi",
				"Baggins",
				null, 
				"256 sesame street"
				);
		
				});
	}
		//testing valid last name
		@Test
		void validLastName() {
			Contact contact = new Contact (
					"123456", 
					"Bibi",
					"Baggins",
					"1001001000", 
					"256 sesame street"
					);
			contact.setLastName("Bagginses");
			assertEquals("Bagginses",contact.getLastName());
			
	}
		//testing valid phone
		@Test
		void validPhone() {
			Contact contact = new Contact (
					"123456", 
					"Bibi",
					"Baggins",
					"1001001000", 
					"256 sesame street"
					);
			contact.setPhone("2002002000");
			assertEquals("2002002000",contact.getPhone());
			
		}		
		//test valid first name
			@Test
			void validFirstName() {
				Contact contact = new Contact (
						"123456", 
						"Bibi",
						"Baggins",
						"1001001000", 
						"256 sesame street"
						);
				contact.setFirstName("Sherlock");
				assertEquals("Sherlock",contact.getFirstName());
			}		
				//test valid first name
				@Test
				void validAddress() {
					Contact contact = new Contact (
							"123456", 
							"Bibi",
							"Baggins",
							"1001001000", 
							"256 sesame street"
							);
					contact.setAddress("345 counting Street");
					assertEquals("345 counting Street",contact.getAddress());
	}
}
