package co.eju.prj.board.service;

import java.util.List;

public interface BoardService {
	//dao랑 연결하기위해서
	List<BoardVO> boardSelectList(); //전체목록가져오기
	BoardVO boardSelect(BoardVO board); //한개 글 조회하기
	int boardInsert(BoardVO board); //게시글 등록(삽입)
	int boardUpdate(BoardVO board); //게시글 수정
	int boardDelete(BoardVO board); //게시글 삭제

	
}
