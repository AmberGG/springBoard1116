package org.zerock.web;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDAOImpl;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardDAOImpl dao;
	
	@RequestMapping("/regist")
	public void registPage(BoardVO vo) throws Exception {
		
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public void regist(BoardVO vo) throws Exception {
		dao.create(vo);
	}
	
	@RequestMapping("/list")
	public void listPage(int page, Model model) throws Exception {
		
		model.addAttribute("list",dao.list(page));
	}
	
	@RequestMapping("/view")
	public void view(int bno, Model model) throws Exception {
		
		model.addAttribute("vo",dao.read(bno));
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(int bno) throws Exception {
		
		dao.delete(bno);
		
		return "redirect:list?page=1&result=s"; 
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO vo, Model model) throws Exception {
		
		dao.update(vo);
		return "redirect:view?bno="+vo.getBno()+"&result=s";
	}
	
	
}
