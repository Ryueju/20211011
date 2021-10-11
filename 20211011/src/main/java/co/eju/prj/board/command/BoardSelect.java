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
		System.out.println("��ȸ�� �� ��ȣ�� �Է��ϼ��� >>>");
		
		board.setbId(scb.nextInt()); //1���� ��������
		board = dao.boardSelect(board);
		
		System.out.println("��ȣ: " + board.getbId());
		System.out.println("�ۼ��� : " +board.getbWriter());
		System.out.println("�ۼ����� : " + board.getbWriterDate());
		System.out.println("���� : "  + board.getbTitle());
		System.out.println("��ȸ�� : " + board.getbHit());
	scb.close();
	
	}

}
