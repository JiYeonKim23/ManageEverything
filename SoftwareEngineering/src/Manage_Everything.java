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
	static HashMap<String,TodoList> HashMapTodoList = new HashMap<String,TodoList>();
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
	private static String todoSearch() {	//�˻� >>delete,update
		System.out.print("���� �Է�:");
		String name = scanner.nextLine();
		if (HashMapTodoList.get(name)==null) { //�ش� �̸��� ���� ���
			System.out.println("�ش��ϴ� item�� �����ϴ�.");
			return "0";
		}
		else {
			return name;
		}
	}
	
	public static int todoCreate() {	 //���� �� 1 ��ȯ , ���� �� 0 ��ȯ
		TodoList todoItem = new TodoList();
		System.out.print("����:");
		String name = scanner.nextLine();
		if (HashMapTodoList.get(name)==null)	// �ߺ����� �ʴ´ٸ�
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
		HashMapTodoList.put(todoItem.getTitle(), todoItem);
		return 1;
	}
	
	public static int todoDelete() {	//���� �� 1 ��ȯ, ���� �� 0 ��ȯ
		String title = todoSearch();
		if ( title=="0")//���ٸ�
			return 0;
		else {
			HashMapTodoList.remove(title);
			return 1;
		}
	}
	public static void todoView() {
		Set<String> keys = HashMapTodoList.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			TodoList todoItem = new TodoList();
			todoItem = HashMapTodoList.get(name);
			System.out.println("[����:"+name+", ���� ��¥:"+todoItem.getCreate_date()+", ���� ��¥:"+todoItem.getDue()+",�� ����:"+todoItem.getDescription()+"]");
		}
	}

	public static int todoUpdate() { // ���� �� 1 ��ȯ, ���� �� 0 ��ȯ
		String title = todoSearch();
		if (title == "0")// ���ٸ�
			return 0;
		// �����ϰ� ���� ���� �Է¹��� �� ����
		TodoList todoItem = HashMapTodoList.get(title);
		System.out.println("1. Title, 2. Create date, 3. Due 4. Description");
		System.out.print("�����ϰ� ���� ��ȣ�� �Է��Ͻÿ� >> ");
		int num = scanner.nextInt();		//==================================���� �߻� ���ɼ�
		if (num == 1) {
			System.out.println("Title>");
			String updated_title = scanner.next();		//==================================���� �߻� ���ɼ�
			todoItem.setTitle(updated_title);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(updated_title, todoItem);
		} else if (num == 2) {
			System.out.println("������¥>");
			String createDate = scanner.next();		//==================================���� �߻� ���ɼ�
			todoItem.setCreate_date(createDate);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
		} else if (num == 3) {
			System.out.println("������¥>");
			String updated_due = scanner.next();		//==================================���� �߻� ���ɼ�
			todoItem.setDue(updated_due);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
			
		} else if (num == 4) {
			System.out.println("�󼼼���>");
			String updated_description = scanner.next();		//==================================���� �߻� ���ɼ�
			todoItem.setDescription(updated_description);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
		}
		return 1;
	}
	
	private static void file_store(String address) {
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
			// System.out.println(address+"�� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			return;
		}
	}
	
	private static void file_open(String address) {
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
				//item.setDescription(Integer.parseInt(st.nextToken()));
				HashMapTodoList.put(item.getTitle(), item);
			}
			scan.close();
			//System.out.println(address+"�κ��� ������ �ҷ��Խ��ϴ�.");
		}
		catch(IOException e) {
			//System.out.println("����¿���");
		}
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
			System.out.println("======================================================================");
			System.out.println("======================================================================");
			System.out.print("1.Create 2.View 3.Update 4.Delete 5.Return to main\n�޴��Է�>>");
			int num = scanner.nextInt();
			if (num >= 1 && num <= 5)
				scanner.nextLine();
			String address = "c:\\Temp\\todoList.txt";
			file_open(address);
			if (num == 1) { // ����
				todoCreate();
			} else if (num == 2) { // ����
				todoView();
			} else if (num == 3) { // ����
				todoUpdate();
			} else if (num == 4) { // ����
				todoDelete();
			} else if (num == 5) { // ����
				file_store(address);
				break;
			}
			//file_store(address);	//���� ��� �ʿ���� ���� ����
		}
	}
	public static void main_appointment() {

	}

	//===================================================================
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			int num=2;//int num=scanner.nextInt();
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