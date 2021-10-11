package co.eju.prj.comm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.eju.prj.board.command.BoardList;
import co.eju.prj.board.command.BoardSelect;
import co.eju.prj.board.command.Command;

public class BoardMenu {
	private Scanner sc = new Scanner(System.in);
	// hashmap이용하자
	private Map<String, Command> map = new HashMap<String, Command>();
	
	public BoardMenu() {
		map.put("boardList", new BoardList());
		map.put("boardSelect", new BoardSelect());
		//여기에 command객체로 생성한 것을 추가하면 된다.
		
	}
	
	
	private void boardTitle() {
		System.out.println("======================");
		System.out.println("==== 1.공지사항 목록 ====");
		System.out.println("==== 2.공지사항 조회 ====");
		System.out.println("==== 3.공지사항 목록 ====");
		System.out.println("==== 4.공지사항 수정 ====");
		System.out.println("==== 5.공지사항 삭제 ====");
		System.out.println("==== 6.그 만 하 기  ====");
		System.out.println("원하는 작업번호를 선택하세요>>");
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
		
		//명령을 처리하는 구문
		Command command = map.get(comm);
		command.execute();
		
	}
	public void run() {
		menu();
	}
}//class end
