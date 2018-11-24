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
	static HashMap<String, Contact> contactList = new
			Hashmap<String, Contact>();
	//==============================contact=====================================
	public static int contactCreate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		Contact contact = new contact();
		System.out.print("�̸�: ");
		String name = scanner.nextLine();
		if (contactList.get(name)==null) {
			contact.setName(name);
		}
		else {
			System.out.println("�ߺ��Ǵ� �̸��Դϴ�. �ٽ� �Է��Ͻʽÿ�.");
			return 0;
		}
		
		System.out.print("��ȭ��ȣ: ");
		contact.setNumber(scanner.nextLine());
		System.out.print("E-mail: ");
		contact.setEmail(scanner.nextLine());
		contactList.put(name, Contact);
		
		return 1;
	}
	public static int contactDelete() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		System.out.print("�̸� �Է�: ");
		String contactName = scanner.nextLine();
		if (contactList.get(name)==null) {
			System.out.println("That contact doesn't exist");
			return 0;
		}
		else {
			Contact contact = new Contact();
			contact = contactList.get(name);
			contactList.remove(name);
			System.out.println("delete success");
		}
		return 1;
	}
	public static void contactView() {
		Set<String> keys = contactList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String name = it.next();
			Contact contact = new Contact();
			contact = contactList.get(name);
			System.out.println("[�̸�: " + name + 
					" ��ȭ��ȣ: " + contact.getNumber() +
					" Email: " + contact.getEmail() + "]");
		}
		
	}
	public static int contactUpdate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		System.out.print("�̸�: ");
		String name = scanner.nextLine();
		if (contactList.get(name)==null) {
			System.out.println("That contact doesn't exist");
			return 0;
		}
		else {
			Contact contact = new Contact();
			contact = contactList.get(name);
			System.out.println("1. Name, 2.Phone number, 3. E-mail");
			int num = scanner.nextInt();
			System.out.print("Enter what you want to update": );
			if (num == 1) {
				System.out.print("Name>");
				String updated_name = scanner.next();
				contact.setName(updated_name);
				contactList.remove(name);
				contactList.put(updated_name, contact);
			}
			else if (num == 2) {
				System.out.print("Phone number>");
				String updated_number = scanner.next();
				contact.setNumber(updated_number);
				contactList.remove(number);
				contactList.put(updated_number, contact);
			}
			else if (num == 3) {System.out.print("E-mail>");
				System.out.print("E-mail>");
				String updated_email = scanner.next();
				contact.setEmail(updated_email);
				contactList.remove(email);
				contactList.put(updated_email, contact);
			}
		}
		
		return 1;
	}
	
	
	//==============================todoList=====================================
	public static int todoCreate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
	}
	public static int todoDelete() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
	}
	public static void todoView() {
		
	}
	public static int todoUpdate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
	}
	//==============================Appointment=====================================
	public static int appoCreate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
	}
	public static int appoDelete() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
	}
	public static void appoView() {

	}
	public static int appoUpdate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
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