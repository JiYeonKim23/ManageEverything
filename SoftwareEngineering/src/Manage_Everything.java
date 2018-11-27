import java.io.*;
import java.util.*;

class Contact {
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
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	public static int contactDelete() {
		//성공 시 1 반환
		//실패 시 0 반환
		return 0;
	}
	public static void contactView() {
		
	}
	public static int contactUpdate() {
		//성공 시 1 반환
		//실패 시 0 반환
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
