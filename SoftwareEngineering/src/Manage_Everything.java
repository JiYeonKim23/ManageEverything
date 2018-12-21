import java.util.*;
import java.io.*;

class Contact {
	private String name;
	private String number;
	private String email;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
}

class TodoList{
	private String title;
	private String create_date;
	private String due;
	private String description;
	
	public String getTitle() {return title;	}
	public void setTitle(String title) {this.title = title;}
	public String getCreate_date() {return create_date; }
	public void setCreate_date(String create_date) {this.create_date = create_date;	}
	public String getDue() {return due;}
	public void setDue(String due) {this.due = due;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;	}
}

class Appointment{
	private String title;
	private String date;
	private String persons;
	private String location;
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	public String getPersons() {return persons;}
	public void setPersons(String persons) {this.persons = persons;}
	public String getLocation() {return location;}
	public void setLocation(String location) {this.location = location;}
}

public class Manage_Everything {
	static Scanner scanner = new Scanner(System.in);
	static HashMap<String, Contact> HashmapContact = new HashMap<String, Contact>();
	static HashMap<String,Appointment> appointList = new HashMap<String, Appointment>();
	static HashMap<String,TodoList> HashMapTodoList = new HashMap<String,TodoList>();
    static String contact = "c:\\Temp\\contact.txt";
	static String appointment = "c:\\Temp\\appointment.txt";
	//==============================contact=====================================
	private static Boolean searchContact() {
		String name = scanner.nextLine();
		
		return checkContactExistence(name);
	}
	
	public static boolean checkContactExistence(String name) {
		if (HashmapContact.get(name)==null) 
			return false;
		else
			return true;
	}
	
	public static int contactCreate() {
		Contact contact = new Contact();
		System.out.print("Name>> ");
		String name = scanner.nextLine();
		if (HashmapContact.get(name)==null) {
			contact.setName(name);
		}
		else {
			System.out.println("That name already exist.");
			return 0;
		}
		
		System.out.print("Phone number>> ");
		contact.setNumber(scanner.nextLine());
		System.out.print("E-mail>> ");
		contact.setEmail(scanner.nextLine());
		HashmapContact.put(name, contact);
		System.out.println("create success");
		return 1;
	}
	
	public static int contactDelete() {
		System.out.print("Enter the name of contact which you want to delete>>");
		boolean existence;
		String name = scanner.next();
		if (HashmapContact.get(name)==null) 
			existence = false;
		else
			existence = true;
		int returnValue = deleteOrNot(existence, name);
		return returnValue;
	}
	
	public static int deleteOrNot(boolean existence, String name) {
		if( existence == false ) {
			System.out.println("That contact doesn't exist");
			return 0;
		}
		else {
			HashmapContact.remove(name);
			System.out.println("delete success");
			return 1;
		}
	}
	
	public static void contactView() {
		int num;
		Set<String> keys = HashmapContact.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String name = it.next();
			Contact contact = new Contact();
			contact = HashmapContact.get(name);
			System.out.println("[Name: " + name + 
					" Phone number: " + contact.getNumber() +
					" E-mail: " + contact.getEmail() + "]");
		}
		
		System.out.print("Enter 0 >> ");
		
		while((num = scanner.nextInt())!=0) {
			System.out.print("Enter 0 >> ");
			continue;
		}
	}
	
	public static int contactUpdate() {
		System.out.print("Enter the name of contact which you want to update>>");
		String name = scanner.next();
		
		if (HashmapContact.get(name)==null) {
			System.out.println("That contact doesn't exist");
			return 0;
		}
		
		Contact contact = new Contact();
		System.out.print("1. Name, 2. Phone number, 3. E-mail >>");
		int num = scanner.nextInt();
		System.out.print("Enter what you want to update: ");
		
		if (num == 1) {
			String new_name = scanner.next();
			contact = HashmapContact.get(name);
			contact.setName(new_name);
			HashmapContact.put(new_name, contact);
			HashmapContact.remove(name);
		} else if (num == 2) {
			String new_number = scanner.next();		
			contact = HashmapContact.get(name);
			contact.setNumber(new_number);
		} else if (num == 3) {
			String new_email = scanner.next();
			contact = HashmapContact.get(name);
			contact.setEmail(new_email);
		}
		
		System.out.println("update success");
		return 1;
	}
	
	private static void file_open_contact() {
		try {
			Scanner scan = new Scanner(new FileReader(contact));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				StringTokenizer st = new StringTokenizer(line,",");
				Contact contact = new Contact();
				contact.setName(st.nextToken());
				contact.setNumber(st.nextToken());
				contact.setEmail(st.nextToken());
				HashmapContact.put(contact.getName(), contact);
			}
			scan.close();
		}
		catch(IOException e) {
			;
		}
	}
	
	private static void file_store_contact() {
		Set<String> keys = HashmapContact.keySet();
		Iterator<String> it = keys.iterator();
		try {
			FileWriter fout = new FileWriter(contact);
			while(it.hasNext()) {
				String name = it.next();
				Contact contact = new Contact();
				contact = HashmapContact.get(name);
				String line = name + "," + contact.getNumber() + "," + contact.getEmail();
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		}catch(IOException e) {
			return;
		}
	}
	
	//==============================todoList=====================================
	public static String todoSearch(String name) {	//>>delete,update
		if (HashMapTodoList.get(name)==null) { 
			System.out.println("That to-do list doesn't exist");
			return "0";
		}
		else
			return name;
	}
	
	public static int todoCreate() {
		TodoList todoItem = new TodoList();
		System.out.print("Title: ");
		String name = scanner.nextLine();
		if (HashMapTodoList.get(name)==null)	
			todoItem.setTitle(name);
		else {
			System.out.println("That title already exists.");
			return 0;
		}
		System.out.print("Create date: ");
		todoItem.setCreate_date(scanner.nextLine());
		System.out.print("Due date: ");
		todoItem.setDue(scanner.nextLine());
		System.out.print("Description: ");
		todoItem.setDescription(scanner.nextLine());
		HashMapTodoList.put(todoItem.getTitle(), todoItem);
		return 1;
	}
	
	public static Boolean todoDeleteAndCheck(String title) {
		HashMapTodoList.remove(title);
		if (HashMapTodoList.get(title)==null)
			return true;
		else
			return false;
	}
	
	public static int todoDelete() {	
		System.out.print("Title: ");
		String title = scanner.nextLine();
		title = todoSearch(title);
		if ( title=="0")
			return 0;
		else {
			Boolean result = todoDeleteAndCheck(title);
			if ( result == true)
				return 1;
			else
				return 0;
		}
	}
	public static void todoView() {
		Set<String> keys = HashMapTodoList.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			TodoList todoItem = new TodoList();
			todoItem = HashMapTodoList.get(name);
			System.out.println("[title:"+name+", create date:"+todoItem.getCreate_date()+", due date:"+todoItem.getDue()+",description:"+todoItem.getDescription()+"]");
			
		}
		int num;
		do{
			System.out.print("Enter 0>>");
			num=scanner.nextInt();
		} while (num!=0);
	}
	
	public static Boolean todoCheckUpdateSuccess(String title, String updatedSentence, int index) {
		boolean existence = title.equals(todoSearch(title));
		TodoList todoItem = HashMapTodoList.get(title);
		
		if ( existence == false )
			return false;
		else if ( index == 2 ) {
			String createDateOftodoItem = todoItem.getCreate_date();
			if ( createDateOftodoItem.equals(updatedSentence) )
				return true;
		}
		else if ( index == 3) {
			String dueDateOftodoItem = todoItem.getDue();
			if ( dueDateOftodoItem.equals(updatedSentence) )
				return true;			
		}
		else if ( index == 4) {
			String descriptionOftodoItem = todoItem.getDescription();
			if ( descriptionOftodoItem.equals(updatedSentence) )
				return true;			
		}
		return false;
	}

	public static int todoUpdate() { 
		System.out.print("Title that you want to update: ");
		String title = scanner.nextLine();
		title = todoSearch(title);
		if (title == "0")
			return 0;
		TodoList todoItem = HashMapTodoList.get(title);
		System.out.print("        ");
		System.out.println("1. Title, 2. Create date, 3. Due 4. Description");
		System.out.print("Enter what you want to update: ");
		int num=Integer.parseInt(scanner.nextLine());	
		Boolean check=false;
		if (num == 1) {
			System.out.print("Title: ");
			String updated_title = scanner.nextLine();	
			todoItem.setTitle(updated_title);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(updated_title, todoItem);
			if ( updated_title.equals( todoSearch(updated_title) ) )
				check = true;
			else
				check = false;
		} else if (num == 2) {
			System.out.print("Create Date: ");
			String createDate = scanner.nextLine();
			todoItem.setCreate_date(createDate);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
			check = todoCheckUpdateSuccess(title, createDate, 2);
		} else if (num == 3) {
			System.out.print("Due date: ");
			String updated_due = scanner.nextLine();
			todoItem.setDue(updated_due);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
			check = todoCheckUpdateSuccess(title,updated_due,3);			
		} else if (num == 4) {
			System.out.print("Description: ");
			String updated_description = scanner.nextLine();
			todoItem.setDescription(updated_description);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
			check = todoCheckUpdateSuccess(title,updated_description,4);
		}
		if ( check == true)
			return 1;
		else
			return 0;
	}
	
	private static void file_store_todolist(String address) {
		Set<String> keys = HashMapTodoList.keySet();
		Iterator<String> it = keys.iterator();
		try {
			FileWriter fout = new FileWriter(address);
			while (it.hasNext()) {
				String name = it.next();
				TodoList list = new TodoList();
				list = HashMapTodoList.get(name);
				String line = name + "," + list.getCreate_date() + "," + list.getDue() + "," + list.getDescription();
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		} catch (Exception e) {
			return;
		}
	}
	
	private static void file_open_todolist(String address) {
		try {
			Scanner scan = new Scanner(new FileReader(address));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				
				StringTokenizer st = new StringTokenizer(line,",");
				TodoList item = new TodoList();
				item.setTitle(st.nextToken());
				item.setCreate_date(st.nextToken());
				item.setDue(st.nextToken());
				item.setDescription(st.nextToken());
				HashMapTodoList.put(item.getTitle(), item);
			}
			scan.close();
		}
		catch(IOException e) {
		}
	}
	//==============================Appointment=====================================
	public static int appoCreate() {
		Appointment app = new Appointment();
		System.out.print("title >> ");
		String title = scanner.nextLine();
		if(checkExisting(title))
			app.setTitle(title);
		else {
			System.out.println("That title already exists.");
			return 0;
		}
		System.out.print("date >> ");
		app.setDate(scanner.nextLine());
		System.out.print("persons >> ");
		app.setPersons(scanner.nextLine());
		System.out.print("location >> ");
		app.setLocation(scanner.nextLine());
		appointList.put(app.getTitle(), app);
		System.out.println("create success");
		return 1;
	}
	
	public static Boolean checkExisting(String title) {
		if(appointList.get(title)==null)
			return true;
		else
			return false;
	}
	
	public static int appoDelete() {
		System.out.print("title >> ");
		String title_input = scanner.nextLine();
		String title = search_appointment(title_input);
		if(title == "0") {
			System.out.println("That appointment doesn't exist");
			return 0;
		}
		else {
			appointList.remove(title);
			System.out.println("delete success");
			return 1;
		}
	}
	
	public static void appoView() {
		int num;
		Set<String>keys = appointList.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String title = it.next();
			Appointment appoint = new Appointment();
			appoint = appointList.get(title);
			System.out.println("[Title: "+title+", Date: "+appoint.getDate()+", Persons: "+appoint.getPersons()+", Location: "+appoint.getLocation()+"]");
		}
		System.out.print("Enter 0 >> ");
		while((num = Integer.parseInt(scanner.nextLine()))!=0) {
			System.out.print("Enter 0 >> ");
			continue;
		}
	}
	
	public static int appoUpdate() {
		System.out.print("title >> ");
		String title_input = scanner.nextLine();
		String title = search_appointment(title_input);
		Appointment appoint = new Appointment();
		if(title == "0") {	
			System.out.println("That appointment doesn't exist");
			return 0;
		}
		else {
			System.out.print("1. Title, 2. Date, 3. Persons, 4. Location >>");
			int num = Integer.parseInt(scanner.nextLine());
			if(num == 1) {
				System.out.println("Enter what you want to update: ");
				String new_title = scanner.nextLine();
				appoint = appointList.get(title);
				appoint.setTitle(new_title);
				appointList.put(new_title, appoint);
				appointList.remove(title);
			}
			else if(num == 2) {
				System.out.println("Enter what you want to update: ");
				String new_date = scanner.nextLine();
				appoint = appointList.get(title);
				appoint.setDate(new_date);
			}
			else if(num == 3) {
				System.out.println("Enter what you want to update: ");
				String new_persons = scanner.nextLine();
				appoint = appointList.get(title);
				appoint.setPersons(new_persons);
			}
			else if(num == 4) {
				System.out.println("Enter what you want to update: ");
				String new_location = scanner.nextLine();
				appoint = appointList.get(title);
				appoint.setLocation(new_location);
			}
			return 1;
		}
	}
	
	private static void file_open_appointment() {
		try {
			Scanner scan = new Scanner(new FileReader(appointment));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				StringTokenizer st = new StringTokenizer(line,",");
				Appointment appoint = new Appointment();
				appoint.setTitle(st.nextToken());
				appoint.setDate(st.nextToken());
				appoint.setPersons(st.nextToken());
				appoint.setLocation(st.nextToken());
				appointList.put(appoint.getTitle(), appoint);
			}
		}catch(IOException e) {
			return;
		}
	}
	
	private static void file_store_appointment() {
		Set<String> keys = appointList.keySet();
		Iterator <String> it = keys.iterator();
		try {
			FileWriter fout = new FileWriter(appointment);
			while(it.hasNext()) {
				String title = it.next();
				Appointment appoint = new Appointment();
				appoint = appointList.get(title);
				String line = title + "," + appoint.getDate()+","+appoint.getPersons()+","+appoint.getLocation();
				fout.write(line,0,line.length());
				fout.write("\r\n",0,2);
			}
			fout.close();
		}catch(Exception e) {
			return;
		}
	}
	
	public static String search_appointment(String title) {
		if(appointList.get(title)==null) {
			return "0";
		}
		else {
			Appointment appoint = new Appointment();
			appoint = appointList.get(title);
			return title;
		}
	}
	//==============================main=====================================
	public static void main_contact() {
		while (true) {
			System.out.print("1.Create, 2.View, 3.Update, 4.Delete, 5.Return to main >>");
			int num = scanner.nextInt();
			file_open_contact();
			
			if (num == 1) {
				contactCreate();
			} else if (num == 2) { 
				contactView();
			} else if (num == 3) {
				contactUpdate();
			} else if (num == 4) { 
				contactDelete();
			} else if (num == 5) {
				file_store_contact();
				break;
			}
			file_store_contact();
		}
	}
	public static void main_todolist() {
		String address = "c:\\Temp\\todoList.txt";
		file_open_todolist(address);
			while (true) {
			System.out.print("1.Create, 2.View, 3.Update, 4.Delete, 5.Return to main >>");
			int num = scanner.nextInt();
			if (num >= 1 && num <= 5)
				scanner.nextLine();
			if (num == 1) { 
				if ( todoCreate()==1 )
					System.out.println("create success");
			} else if (num == 2) { 
				todoView();
			} else if (num == 3) {
				if ( todoUpdate()==1 )
					System.out.println("update success");
			} else if (num == 4) { 
				if ( todoDelete()==1 )
				System.out.println("delete success");
			} else if (num == 5) {
				file_store_todolist(address);
				break;
			}
			file_store_todolist(address);	
		}
	}
	public static void main_appointment() {
		while(true) {
			System.out.print("1.Create, 2.View, 3.Update, 4.Delete, 5.Return to main >>");
			int num = Integer.parseInt(scanner.nextLine());
			file_open_appointment();
			if(num == 1){
				appoCreate();
			}
			else if(num == 2) {
				appoView();
			}
			else if(num == 3) {
				appoUpdate();
			}
			else if(num == 4) {
				appoDelete();
			}
			else if(num == 5) {
				file_store_appointment();
				break;
			}
			file_store_appointment();	
		}


	}

	//===================================================================
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("1. Manage contact, 2. Manage to do list, 3. Manage appointment, 4. Exit >>");
			int num = Integer.parseInt(scanner.nextLine());
			if ( num==1)
				main_contact();
			else if ( num==2 )
				main_todolist();
			else if ( num==3 )
				main_appointment();
			else if ( num==4 )
				break;
		}
	}
}
