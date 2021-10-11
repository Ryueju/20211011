package co.eju.prj.board.command;

import co.eju.prj.board.service.BoardService;
import co.eju.prj.board.serviceImpl.BoardServiceImpl;

public interface Command {
	public BoardService dao = new BoardServiceImpl();
	public void execute();
	

}
