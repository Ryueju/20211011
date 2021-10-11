package co.eju.prj.board.command;

import java.util.ArrayList;
import java.util.List;

import co.eju.prj.board.service.BoardService;
import co.eju.prj.board.service.BoardVO;
import co.eju.prj.board.serviceImpl.BoardServiceImpl;

public class BoardList implements Command { //�Խñ� ��� ���� ���
	private List<BoardVO> list = new ArrayList<BoardVO>();
	private BoardService dao = new BoardServiceImpl();
	
	@Override
	public void execute() { //execute�޼ҵ�
		list = dao.boardSelectList();
		System.out.print("���� : �ۼ��� :       �ۼ�����:        ����:             ��ȸ��:     ");
		for(BoardVO vo : list) {
			System.out.print(vo.getbId() + "");
			System.out.print(vo.getbWriter() + "" );
			System.out.print(vo.getbWriterDate() + "");
			System.out.print(vo.getbTitle() + "");
			System.out.println(vo.getbHit() + "");
		}
	}

}
