package org.zerock.domain;

public class MemberVO {
	
	private String userid, userpw;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + "]";
	}
	
	

}
