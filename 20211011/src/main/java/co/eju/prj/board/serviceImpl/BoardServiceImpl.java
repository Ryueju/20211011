package co.eju.prj.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.eju.prj.board.service.BoardService;
import co.eju.prj.board.service.BoardVO;
import co.eju.prj.comm.DataSource;

public class BoardServiceImpl implements BoardService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<BoardVO> boardSelectList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO board;
		String sql = "select * from board";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setbId(rs.getInt("bid"));
				board.setbWriter(rs.getString("bwriter"));
				board.setbWriterDate(rs.getDate("bwirterdate"));
				board.setbTitle(rs.getString("btitle"));
				//contents�� ������ �ʿ� ����
				board.setbHit(rs.getInt("bhit"));
				list.add(board);
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO board) { //���õ� �Ѱ��� �� ��������
		String sql = "select * from board where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,board.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				board.setbWriter(rs.getString("bwriter"));
				board.setbWriterDate(rs.getDate("bwriterdate"));
				board.setbTitle(rs.getString("btitle"));
				board.setbContents(rs.getString("bcontents"));
				board.setbHit(rs.getInt("bhit"));
				hitUpdate(board.getbId());
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return board; //board�� ���ϵǾ�� ��
	}

	@Override
	public int boardInsert(BoardVO board) {
		int n = 0;
		String sql = " insert into board values(b_squ.nextval,?,sysdate,?,?,0)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getbWriter());
			psmt.setString(2, board.getbTitle());
			psmt.setString(3, board.getbContents());
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int boardUpdate(BoardVO board) {
		int n = 0;
		String sql = "update board set bcontents = ? where bid=?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getbContents());
			psmt.setInt(2, board.getbId());
			n= psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO board) {
		int n = 0;
		String sql = " delete from board where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getbId());
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
	}
	private void hitUpdate(int bId) { //��ȸ�� ������Ʈ
		String sql = "update board set bhit = bhit +1 where bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bId);
			psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
