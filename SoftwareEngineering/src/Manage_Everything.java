import java.io.*;
import java.util.*;

class contact {
		
}

class todoList{
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
	
}

public class Manage_Everything {
	static Scanner scanner = new Scanner(System.in);
	//==============================contact=====================================
	public static int contactCreate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
	}
	public static int contactDelete() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
	}
	public static void contactView() {
		
	}
	public static int contactUpdate() {
		//���� �� 1 ��ȯ
		//���� �� 0 ��ȯ
		return 0;
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