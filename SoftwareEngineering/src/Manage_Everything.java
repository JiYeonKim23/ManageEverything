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
	static Hashmap<String, Contact> contactList = new
			Hashmap<String, Contact>();
	static String contactAddress = "C:\\Temp\\Contact.txt"
	//==============================contact=====================================
	public static int contactCreate() {
		//성공 시 1 반환
		//실패 시 0 반환
		Contact contact = new contact();
		System.out.print("이름: ");
		String name = scanner.nextLine();
		if (contactList.get(name)==null) {
			contact.setName(name);
		}
		else {
			System.out.println("중복되는 이름입니다.");
			return;
		}
		
		System.out.print("전화번호: ");
		contact.setNumber(scanner.nextLine());
		System.out.print("Email: ");
		contact.setEmail(scanner.nextLine());
		contactList.put(name, Contact);
		
		return 0;
	}
	public static int contactDelete() {
		//성공 시 1 반환
		//실패 시 0 반환
		System.out.print("이름 입력: ");
		String contactName = scanner.nextLine();
		if (contactList.get(name)==null) 
			System.out.println("That contact doesn't exist");
		else {
			Contact contact = new Contact();
			contact = contactList.get(name);
			contactList.remove(name);
			System.out.println("delete success");
		}
		return 0;
	}
	public static void contactView() {
		Set<String> keys = contactList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String name = it.next();
			Contact contact = new Contact();
			contact = contactList.get(name);
			System.out.println("[이름: " + name + 
					" 전화번호: " + contact.getNumber() +
					" Email: " + contact.getEmail() + "]");
		}
		
	}
	public static int contactUpdate() {
		//성공 시 1 반환
		//실패 시 0 반환
		System.out.print("이름: ");
		String name = scanner.nextLine();
		if (contactList.get(name)==null) {
			System.out.println("That contact doesn't exist");
		}
		else {
			Contact contact = new Contact();
			contact = contactList.get(name);
			System.out.println("1. Name, 2.Phone number, 3. E-mail");
			int num = scanner.nextInt();
			System.out.print("Enter what you want to update": );
			if (num == 1) {
				contact.setName(scanner.nextLine());
			}
			else if (num == 2) {
				contact.setNumber(scanner.nextLine());
			}
			else if (num == 3) {
				contact.setEmail(scanner.nextLine());
			}
		}
		
		return 0;
	}
	
	
	//==============================todoList=====================================
	public static int todoCreate() {
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	public static int todoDelete() {
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	public static void todoView() {
		
	}
	public static int todoUpdate() {
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	//==============================Appointment=====================================
	public static int appoCreate() {
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	public static int appoDelete() {
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	public static void appoView() {

	}
	public static int appoUpdate() {
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	
	//==============================main=====================================
	public static void main_contact() {
		Scanner scanner = new Scanner(System.in);
		int numOfContactMenu;
		
		file_open();
		
		System.out.print("\n1. Create, 2. View, 3. Update, 4. Delete, 5. Return to main");
		numOfContactMenu = scanner.nextInt();
		
		while (numOfContactMenu != 5) {
			if (numOfContactMenu == 1)
				contactCreate();
			else if (numOfContactMenu == 2)
				contactView();
			else if (numOfContactMenu == 3)
				contactUpdate();
			else if (numOfContactMenu == 4)
				contactDelete();
		
			System.out.print("\n1. Create, 2. View, 3. Update, 4. Delete, 5. Return to main");
			numOfContactMenu = scanner.nextInt();
		}
		
		file_store();
		scanner.close();
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