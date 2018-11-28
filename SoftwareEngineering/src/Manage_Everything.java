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

class todoList{
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
	static HashMap<String, Contact> HashmapContact = new
			Hashmap<String, Contact>();
	//==============================contact=====================================
private static String searchContact() {
		System.out.print("name>>");
		String name = scanner.nextLine();
		if (HashmapContact.get(name)==null) {
			System.out.println("That name doesn't exist.");
			return "0";
		}
		else
			return name;
	}
	
	
	public static int contactCreate() {
		//성공 시 1 반환
		//실패 시 0 반환
		Contact contact = new contact();
		System.out.print("Name: ");
		String name = scanner.nextLine();
		if (HashmapContact.get(name)==null) {
			contact.setName(name);
		}
		else {
			System.out.println("This is a duplicate name. Please re-enter.");
			return 0;
		}
		
		System.out.print("Phone number: ");
		contact.setNumber(scanner.nextLine());
		System.out.print("E-mail: ");
		contact.setEmail(scanner.nextLine());
		HashmapContact.put(name, Contact);
		System.out.println("create success");
		return 1;
	}
	public static int contactDelete() {
		//성공 시 1 반환
		//실패 시 0 반환
		System.out.print("name >> ");
		String name = contactSearch();
		if ( name=="0") {
			System.out.println("delete success");
			return 0;
		}
		else {
			HashMapContact.remove(name);
			System.out.println("That name doesn't exist.");
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
		while((num = Integer.parseInt(scanner.nextLine()))!=0) {
			System.out.print("Enter 0 >> ");
			continue;
		}
		
	}
	public static int contactUpdate() {
		//성공 시 1 반환
		//실패 시 0 반환
		System.out.print("name >> ");
		String name = contactSearch();
		if (name == "0") {
			System.out.println("That appointment doesn't exist");
			return 0;
		}
		
		// 수정하고 싶은 것을 입력받은 후 결정
		Contact contact = HashMapContact.get(name);
		System.out.println("1. Name, 2. Phone number, 3. E-mail");
		System.out.print("Enter what you want to update: ");
		int num = scanner.nextInt();
		if (num == 1) {
			System.out.println("Name>");
			String updated_name = scanner.next();
			todoContact.setName(updated_name);
			HashMapContact.remove(name);
			HashMapContact.put(updated_name, contact);
		} else if (num == 2) {
			System.out.println("Phone number>");
			String number = scanner.next();		
			contact.setNumber(number);
			HashMapContact.remove(name);
			HashMapContact.put(name,contact);
		} else if (num == 3) {
			System.out.println("E-mail>");
			String email = scanner.next();		
			contact.setEmail(email);
			HashMapContact.remove(name);
			HashMapContact.put(name,contact);
		}
		return 1;
	}
	
	private static void file_store_contact(String address) {
		Set<String> keys = HashmapContact.keySet();
		Iterator<String> it = keys.iterator();
		try {
			FileWriter fout = new FileWriter(address);
			while(it.hasNext()) {
				String name = scan.nextLine();
				Contact contact = new Contact();
				contact = HashmapContact.get(name);
				String line = name + "," + list.getNumber() + "," + list.getEmail());
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
		}catch(IOException e) {
			return;
		}
	}
	
	private static void file_open(String address) {
		try {
			Scanner scan = new Scanner(new FileReader(address));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				
				StringTokenizer st = new StringTokenizer(line,",");
				Contact contact = new Contact();
				contact.setTitle(st.nextToken());
				contact.setCreate_date(st.nextToken());
				contact.setDue(st.nextToken());
				HashMapContact.put(contact.getName(), contact);
			}
			scan.close();
		}
		catch(IOException e) {
			System.out.println("입출력오류");
		}
	}
	
	//==============================todoList=====================================
	public static int todoCreate() {
		return 0;
	}
	public static int todoDelete() {
		return 0;
	}
	public static void todoView() {
		
	}
	public static int todoUpdate() {
		return 0;
	}
	//==============================Appointment=====================================
	public static int appoCreate() {

		Appointment app = new Appointment();
		System.out.print("title >> ");
		String title = scanner.nextLine();
		if(appointList.get(title)==null)
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
	
	public static int appoDelete() {

		System.out.print("title >> ");
		String title = search_appointment();
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
		String title = search_appointment();
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
			fout = new FileWriter(appointment);
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
	
	private static String search_appointment() {
		String title = scanner.nextLine();
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
		
	}
	public static void main_todolist() {

	}
	public static void main_appointment() {
		while(true) {
			System.out.print("1. Create, 2. View, 3. Update, 4. Delete, 5. Return to main >>");
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
