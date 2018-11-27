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
	private static String contactSearch() {	
		System.out.print("Enter name:");
		String name = scanner.nextLine();
		if (HashMapContact.get(name)==null) { //�ش� �̸��� ���� ���
			System.out.println("No corresponding name exists.");
			return "0";
		}
		else {
			return name;
		}
	}
	
	public static int contactCreate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
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
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		String name = contactSearch();
		if ( name=="0")//���ٸ�
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
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		String name = contactSearch();
		if (name == "0")
			return 0;
		// �����ϰ� ���� ���� �Է¹��� �� ����
		Contact contact = HashMapContact.get(name);
		System.out.println("1. Name, 2. Phone number, 3. E-mail");
		System.out.print("Enter the number you want to modify>>");
		int num = scanner.nextInt();		//==================================���� �߻� ���ɼ�
		if (num == 1) {
			System.out.println("Name>");
			String updated_name = scanner.next();		//==================================���� �߻� ���ɼ�
			todoContact.setName(updated_name);
			HashMapContact.remove(name);
			HashMapContact.put(updated_name, contact);
		} else if (num == 2) {
			System.out.println("Phone number>");
			String number = scanner.next();		//==================================���� �߻� ���ɼ�
			contact.setNumber(number);
			HashMapContact.remove(name);
			HashMapContact.put(name,contact);
		} else if (num == 3) {
			System.out.println("E-mail>");
			String email = scanner.next();		//==================================���� �߻� ���ɼ�
			contact.setEmail(email);
			HashMapContact.remove(name);
			HashMapContact.put(name,contact);
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