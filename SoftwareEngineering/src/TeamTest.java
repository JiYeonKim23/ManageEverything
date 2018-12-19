import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.*;

class TeamTest {
    @BeforeAll
    static void createData() {
    	Manage_Everything m = new Manage_Everything();
    	Appointment app = new Appointment();
    	app.setTitle("title1");
    	app.setDate("2018-01-30");
		app.setPersons("Jane");
		app.setLocation("Bluesquare hall");
		m.appointList.put(app.getTitle(), app);
    }
	@Test
	void search_diff() {
		Manage_Everything m = new Manage_Everything();
		assertEquals("0", m.search_appointment("title"));
	}
	@Test
	void search_equal() {
		Manage_Everything m = new Manage_Everything();
		assertEquals("title1", m.search_appointment("title1"));
	}
	@Test
	void check_existing() {
		Manage_Everything m = new Manage_Everything();
		assertFalse(m.checkExisting("title1"));
	}
	@Test
	void check_notexisting() {
		Manage_Everything m = new Manage_Everything();
		assertTrue(m.checkExisting("title2"));
	}

}
