package co.eju.prj.board.command;

import java.util.Scanner;

import co.eju.prj.board.service.BoardService;
import co.eju.prj.board.service.BoardVO;
import co.eju.prj.board.serviceImpl.BoardServiceImpl;

public class BoardSelect implements Command {
	private Scanner scb = new Scanner(System.in);
	
	@Override
	public void execute() {
		
		BoardService dao = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		System.out.println("==================");
		System.out.println("조회할 글 번호를 입력하세요 >>>");
		
		board.setbId(scb.nextInt()); //1번글 가져오기
		board = dao.boardSelect(board);
		
		System.out.println("번호: " + board.getbId());
		System.out.println("작성자 : " +board.getbWriter());
		System.out.println("작성일자 : " + board.getbWriterDate());
		System.out.println("제목 : "  + board.getbTitle());
		System.out.println("조회수 : " + board.getbHit());
	scb.close();
	
	}

}
