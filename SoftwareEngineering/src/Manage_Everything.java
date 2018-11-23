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
	private static String todoSearch() {	//검색 >>delete,update
		System.out.print("제목 입력:");
		String name = scanner.nextLine();
		if (HashMapTodoList.get(name)==null) { //해당 이름이 없을 경우
			System.out.println("해당하는 item이 없습니다.");
			return "0";
		}
		else {
			return name;
		}
	}
	
	public static int todoCreate() {	 //성공 시 1 반환 , 실패 시 0 반환
		TodoList todoItem = new TodoList();
		System.out.print("제목:");
		String name = scanner.nextLine();
		if (HashMapTodoList.get(name)==null)	// 중복되지 않는다면
			todoItem.setTitle(name);
		else {
			System.out.println("중복됩니다 다시 입력하십시오.");
			return 0;
		}
		System.out.print("생성 날짜:");
		todoItem.setCreate_date(scanner.nextLine());
		System.out.print("마감 날짜:");
		todoItem.setDue(scanner.nextLine());
		System.out.print("상세 설명:");
		todoItem.setDescription(scanner.nextLine());
		HashMapTodoList.put(todoItem.getTitle(), todoItem);
		return 1;
	}
	
	public static int todoDelete() {	//성공 시 1 반환, 실패 시 0 반환
		String title = todoSearch();
		if ( title=="0")//없다면
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
			System.out.println("[제목:"+name+", 생성 날짜:"+todoItem.getCreate_date()+", 마감 날짜:"+todoItem.getDue()+",상세 설명:"+todoItem.getDescription()+"]");
		}
	}

	public static int todoUpdate() { // 성공 시 1 반환, 실패 시 0 반환
		String title = todoSearch();
		if (title == "0")// 없다면
			return 0;
		// 수정하고 싶은 것을 입력받은 후 결정
		TodoList todoItem = HashMapTodoList.get(title);
		System.out.println("1. Title, 2. Create date, 3. Due 4. Description");
		System.out.print("수정하고 싶은 번호를 입력하시오 >> ");
		int num = scanner.nextInt();		//==================================오류 발생 가능성
		if (num == 1) {
			System.out.println("Title>");
			String updated_title = scanner.next();		//==================================오류 발생 가능성
			todoItem.setTitle(updated_title);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(updated_title, todoItem);
		} else if (num == 2) {
			System.out.println("생성날짜>");
			String createDate = scanner.next();		//==================================오류 발생 가능성
			todoItem.setCreate_date(createDate);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
		} else if (num == 3) {
			System.out.println("마감날짜>");
			String updated_due = scanner.next();		//==================================오류 발생 가능성
			todoItem.setDue(updated_due);
			HashMapTodoList.remove(title);
			HashMapTodoList.put(title,todoItem);
			
		} else if (num == 4) {
			System.out.println("상세설명>");
			String updated_description = scanner.next();		//==================================오류 발생 가능성
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
			// System.out.println(address+"에 저장되었습니다.");
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
			//System.out.println(address+"로부터 정보를 불러왔습니다.");
		}
		catch(IOException e) {
			//System.out.println("입출력오류");
		}
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
		while (true) {
			System.out.println("======================================================================");
			System.out.println("======================================================================");
			System.out.print("1.Create 2.View 3.Update 4.Delete 5.Return to main\n메뉴입력>>");
			int num = scanner.nextInt();
			if (num >= 1 && num <= 5)
				scanner.nextLine();
			String address = "c:\\Temp\\todoList.txt";
			file_open(address);
			if (num == 1) { // 생성
				todoCreate();
			} else if (num == 2) { // 보기
				todoView();
			} else if (num == 3) { // 수정
				todoUpdate();
			} else if (num == 4) { // 삭제
				todoDelete();
			} else if (num == 5) { // 종료
				file_store(address);
				break;
			}
			//file_store(address);	//여긴 사실 필요없을 수도 있음
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