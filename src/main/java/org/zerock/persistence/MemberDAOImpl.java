package org.zerock.persistence;

import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl extends AbstractDAO<MemberVO, String> implements MemberDAO{
	
	public MemberDAOImpl() {
		this.NAME = "org.zerock.dao.MemberMapper";
		
	}

}

