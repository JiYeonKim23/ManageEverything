import java.io.*;
import java.util.*;

class contact {
		
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
	
}

public class Manage_Everything {
	static Scanner scanner = new Scanner(System.in);
	static HashMap<String,TodoList> todoList = new HashMap<String,TodoList>();
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
	public static int todoCreate() { //���� �� 1 ��ȯ , ���� �� 0 ��ȯ
		TodoList todoItem = new TodoList();
		System.out.print("����:");
		String name = scanner.nextLine();
		if (todoList.get(name)==null)	// �ߺ����� �ʴ´ٸ�
			todoItem.setTitle(name);
		else {
			System.out.println("�ߺ��˴ϴ� �ٽ� �Է��Ͻʽÿ�.");
			return 0;
		}
		System.out.print("���� ��¥:");
		todoItem.setCreate_date(scanner.nextLine());
		System.out.print("���� ��¥:");
		todoItem.setDue(scanner.nextLine());
		System.out.print("�� ����:");
		todoItem.setDescription(scanner.nextLine());
		todoList.put(todoItem.getTitle(), todoItem);
		return 1;
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
		while (true) {
			System.out.print("1.Create 2.View 3.Update 4.Delete 5.Return to main\n�޴��Է�>>");
			int num = scanner.nextInt();
			if (num >= 1 && num <= 5)
				scanner.nextLine();
			// file_open();
			if (num == 1) { // ����
				todoCreate();
			} else if (num == 2) { // ����
				todoView();
			} else if (num == 3) { // ����
				todoUpdate();
			} else if (num == 4) { // ����
				todoDelete();
			} else if (num == 5) { // ����
				// file_store();
				break;
			}
			// file_store();
		}
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