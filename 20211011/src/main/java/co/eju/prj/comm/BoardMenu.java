package co.eju.prj.comm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.eju.prj.board.command.BoardList;
import co.eju.prj.board.command.BoardSelect;
import co.eju.prj.board.command.Command;

public class BoardMenu {
	private Scanner sc = new Scanner(System.in);
	// hashmap�̿�����
	private Map<String, Command> map = new HashMap<String, Command>();
	
	public BoardMenu() {
		map.put("boardList", new BoardList());
		map.put("boardSelect", new BoardSelect());
		//���⿡ command��ü�� ������ ���� �߰��ϸ� �ȴ�.
		
	}
	
	
	private void boardTitle() {
		System.out.println("======================");
		System.out.println("==== 1.�������� ��� ====");
		System.out.println("==== 2.�������� ��ȸ ====");
		System.out.println("==== 3.�������� ��� ====");
		System.out.println("==== 4.�������� ���� ====");
		System.out.println("==== 5.�������� ���� ====");
		System.out.println("==== 6.�� �� �� ��  ====");
		System.out.println("���ϴ� �۾���ȣ�� �����ϼ���>>");
	}
	
	private void menu() {
		while(true) {
			boardTitle();
			int job = sc.nextInt(); sc.nextLine();
			switch(job) {
			case 1: 
				commandRun("boardList");
				break;
			case 2: 
				commandRun("boardSelcet");
				break;
			case 3: 
				commandRun(null);
				break;
			case 4: 
				commandRun(null);
				break;
			case 5: 
				commandRun(null);
				break;
			case 6: 
				System.out.println("GOOD BYE ~~~");
				sc.close();
				return;
			}
		} //while end
	}//method end

	private void commandRun(String comm) {
		
		//����� ó���ϴ� ����
		Command command = map.get(comm);
		command.execute();
		
	}
	public void run() {
		menu();
	}
}//class end
