package co.eju.prj;

import java.io.IOException;

import co.eju.prj.board.command.BoardList;
import co.eju.prj.board.command.BoardSelect;
import co.eju.prj.board.command.Command;
import co.eju.prj.comm.BoardMenu;

public class MainApp {
	
	public static void main(String[] args) throws IOException{
	//	System.out.println("Hello!");
		
	// �Խ��� ������Ʈ
		//1.VO��ü����,DAO����
		//2.Interface����
		//3.headface ����ü ����
		
	//	BoardListCommand blist = new BoardListCommand();
	//	blist.execute();
		
	//	Command command = new BoardSelect();
	//	command.execute();
		
		BoardMenu boardMenu = new BoardMenu();
		boardMenu.run();
	}

}
