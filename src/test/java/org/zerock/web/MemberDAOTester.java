package org.zerock.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTester {

	
	@Autowired
	private MemberDAO dao;

	@Test
	public void testDAO1() {
		System.out.println(dao);

	}

	@Test
	public void testInsert() throws Exception {
		MemberVO vo = new MemberVO();
		
		vo.setUserid("user1");
		vo.setUserpw("uwer1");

		dao.create(vo);

	}
	
	@Test
	public void testUpdate() throws Exception {
		MemberVO vo = new MemberVO();
		
		vo.setUserid("user1");
		vo.setUserpw("user1");

		dao.update(vo);

	}
	
	@Test
	public void testDelete() throws Exception {


		dao.delete("¸ÛÃ»ÀÎµð");

	}

}
