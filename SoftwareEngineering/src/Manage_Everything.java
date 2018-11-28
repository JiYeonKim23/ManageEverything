import java.io.*;
import java.util.*;

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
		return 0;
	}
	public static int appoDelete() {
		return 0;
	}
	public static void appoView() {

	}
	public static int appoUpdate() {
		return 0;
	}
	
	//==============================main=====================================
	public static void main_contact() {
		
	}
	public static void main_todolist() {

	}
	public static void main_appointment() {

	}

	//===================================================================
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			int num=scanner.nextInt();
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
