package co.eju.prj.board.service;

import java.util.List;

public interface BoardService {
	//dao�� �����ϱ����ؼ�
	List<BoardVO> boardSelectList(); //��ü��ϰ�������
	BoardVO boardSelect(BoardVO board); //�Ѱ� �� ��ȸ�ϱ�
	int boardInsert(BoardVO board); //�Խñ� ���(����)
	int boardUpdate(BoardVO board); //�Խñ� ����
	int boardDelete(BoardVO board); //�Խñ� ����

	
}
