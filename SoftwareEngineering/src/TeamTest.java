import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.HashMap;

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
		
		Contact contact = new Contact();
		contact.setName("Julia");
		contact.setNumber("01012345678");
		contact.setEmail("julia_gmail.com");
		m.HashmapContact.put(contact.getName(), contact);
		
		TodoList todo = new TodoList();
		todo.setTitle("JiYeon");
		todo.setCreate_date("2018-12-21");
		todo.setDescription("do SWEngineering HW");
		todo.setDue("2018-12-21");
		m.HashMapTodoList.put(todo.getTitle(),todo);
		todo.setTitle("NoYeon");
		m.HashMapTodoList.put("NoYeon", todo);
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
	
	@Test
	void possibleToDelete() {
		Manage_Everything m = new Manage_Everything();
		assertEquals(1, m.deleteOrNot(true, "Julia"));
	}
	
	@Test
	void testContactExistence() {
		Manage_Everything m = new Manage_Everything();
		assertTrue(m.checkContactExistence("Julia"));
	}
	
	@Test
	void testTodolistSearch() {
		Manage_Everything m = new Manage_Everything();
		assertEquals("JiYeon",m.todoSearch("JiYeon"));
	}
	
	void testTodolistDeleteSuccess() {
		Manage_Everything m = new Manage_Everything();
		assertTrue(m.todoDeleteAndCheck("NoYeon"));
	}
	
	void testTodolistUpdateSuccess() {
		Manage_Everything m = new Manage_Everything();
		assertFalse(m.todoCheckUpdateSuccess("JiYeon","changed",2));
	}
}
