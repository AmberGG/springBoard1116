package org.zerock.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

@Repository
public class BoardDAOImpl extends AbstractDAO<BoardVO, Integer> implements BoardDAO {

	
	public BoardDAOImpl() {
		this.NAME = "org.zerock.dao.BoardMapper";
		
	}

	//page를 갖고 와야함.
	public List<BoardVO> list(int page) throws Exception {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = sqlSession.selectList(NAME + ".list", page);
		return list;
	}

	
	
}
