package co.eju.prj;

import java.io.IOException;

import co.eju.prj.board.command.BoardList;
import co.eju.prj.board.command.BoardSelect;
import co.eju.prj.board.command.Command;
import co.eju.prj.comm.BoardMenu;

public class MainApp {
	
	public static void main(String[] args) throws IOException{
	//	System.out.println("Hello!");
		
	// 霸矫魄 橇肺璃飘
		//1.VO按眉积己,DAO积己
		//2.Interface积己
		//3.headface 备泅眉 积己
		
	//	BoardListCommand blist = new BoardListCommand();
	//	blist.execute();
		
	//	Command command = new BoardSelect();
	//	command.execute();
		
		BoardMenu boardMenu = new BoardMenu();
		boardMenu.run();
	}

}
