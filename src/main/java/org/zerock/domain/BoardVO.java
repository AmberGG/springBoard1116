package org.zerock.domain;

import java.util.Date;

public class BoardVO {

	private Integer bno, replycnt;
	private String writer, title, content;
	private Date regdate, updatedate;
	
	
	
	public Integer getBno() {
		return bno;
	}



	public void setBno(Integer bno) {
		this.bno = bno;
	}



	public Integer getReplycnt() {
		return replycnt;
	}



	public void setReplycnt(Integer replycnt) {
		this.replycnt = replycnt;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}



	public Date getUpdatedate() {
		return updatedate;
	}



	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}



	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", replycnt=" + replycnt + ", writer=" + writer + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
	
}
