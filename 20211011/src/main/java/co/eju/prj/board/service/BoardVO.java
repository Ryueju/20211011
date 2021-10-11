package co.eju.prj.board.service;

import java.sql.Date;

public class BoardVO {
	private int bId;
	private String bWriter;
	private Date bWriterDate;
	private String bContents;//java.sql 타입 선택하기
	private String bTitle;
	private int bHit; //조회수
	
	public BoardVO() {
		 //생성자 만들기 GETTER AND SETTER
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public Date getbWriterDate() {
		return bWriterDate;
	}

	public void setbWriterDate(Date bWriterDate) {
		this.bWriterDate = bWriterDate;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public void setbContents(String bContents) {
		this.bContents = bContents;
		// TODO Auto-generated method stub
		
	}

	public String getbContents() {
		return bContents;
	}
}
