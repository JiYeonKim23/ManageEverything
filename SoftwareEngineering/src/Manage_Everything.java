import java.util.HashMap;

class Contact {
	private String name;
	private String number;
	private String email;
	public String getName() {return name;}
	public void setName() {this.name = name;}
	public String getNumber() {return number;}
	public void setNumber() {this.name = number;}
	public String getEmail() {return email;}
	public void setEmail() {this.name = email;}
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
<<<<<<< HEAD
=======
	static HashMap<String,Appointment> appointList = new HashMap<String, Appointment>();
	static FileWriter fout = null;
	FileReader fin = null;
	static String appointment = "c:\\Temp\\appointment.txt";
>>>>>>> appointment
	//==============================contact=====================================
	private static String contactSearch() {	
		System.out.print("Enter name:");
		String name = scanner.nextLine();
		if (HashMapContact.get(name)==null) { //해당 이름이 없을 경우
			System.out.println("No corresponding name exists.");
			return "0";
		}
		else {
			return name;
		}
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
		
		return 1;
	}
	public static int contactDelete() {
		//성공 시 1 반환
		//실패 시 0 반환
		String name = contactSearch();
		if ( name=="0")//없다면
			return 0;
		else {
			HashMapContact.remove(title);
			return 1;
		}
	}
	public static void contactView() {
		Set<String> keys = contactList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String name = it.next();
			Contact contact = new Contact();
			contact = HashmapContact.get(name);
			System.out.println("[Name: " + name + 
					" Phone number: " + contact.getNumber() +
					" E-mail: " + contact.getEmail() + "]");
		}
		
	}
	public static int contactUpdate() {
		//성공 시 1 반환
		//실패 시 0 반환
		String name = contactSearch();
		if (name == "0")
			return 0;
		// 수정하고 싶은 것을 입력받은 후 결정
		Contact contact = HashMapContact.get(name);
		System.out.println("1. Name, 2. Phone number, 3. E-mail");
		System.out.print("Enter the number you want to modify>>");
		int num = scanner.nextInt();		//==================================오류 발생 가능성
		if (num == 1) {
			System.out.println("Name>");
			String updated_name = scanner.next();		//==================================오류 발생 가능성
			todoContact.setName(updated_name);
			HashMapContact.remove(name);
			HashMapContact.put(updated_name, contact);
		} else if (num == 2) {
			System.out.println("Phone number>");
			String number = scanner.next();		//==================================오류 발생 가능성
			contact.setNumber(number);
			HashMapContact.remove(name);
			HashMapContact.put(name,contact);
		} else if (num == 3) {
			System.out.println("E-mail>");
			String email = scanner.next();		//==================================오류 발생 가능성
			contact.setEmail(email);
			HashMapContact.remove(name);
			HashMapContact.put(name,contact);
		}
		return 1;
		return 0;
	}
	public static int contactDelete() {
		return 0;
	}
	public static void contactView() {
		
	}
	public static int contactUpdate() {
		return 0;
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
<<<<<<< HEAD
		return 0;
=======
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
>>>>>>> appointment
	}
	
	public static int appoDelete() {
<<<<<<< HEAD
		return 0;
=======
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
>>>>>>> appointment
	}
	
	public static void appoView() {
		int num;
		Set<String>keys = appointList.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String title = it.next();
			Appointment appoint = new Appointment();
			appoint = appointList.get(title);
			System.out.println("[제목: "+title+", 날짜: "+appoint.getDate()+", 이름: "+appoint.getPersons()+", 장소: "+appoint.getLocation()+"]");
		}
		System.out.print("Enter 0 >> ");
		while((num = Integer.parseInt(scanner.nextLine()))!=0) {
			System.out.print("Enter 0 >> ");
			continue;
		}
	}
	
	public static int appoUpdate() {
<<<<<<< HEAD
		return 0;
=======
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
			System.out.println("Failed to open");
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
			System.out.println("Failed to Store");
			return;
		}
>>>>>>> appointment
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
