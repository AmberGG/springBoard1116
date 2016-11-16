package org.zerock.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@Controller
@RequestMapping("/smem/*")
public class SmemController {
	
	@Inject
	MemberDAO dao;
	
	@RequestMapping("/regist")
	public void registPage(MemberVO vo, Model model) throws Exception {
	
		
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public void regist(MemberVO vo, Model model) throws Exception {
	
		dao.create(vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //4.1~1�������� Request.GET�� ���� , POST�� ����
	@GetMapping("/doA") 
//	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public void doA(MemberVO vo, Model model) {
		System.out.println("==========================");
		System.out.println(vo);
		System.out.println("==========================");
		model.addAttribute("vo", vo);

//		 return "hi";
	}
	
	@RequestMapping(value = "/doAA", method = RequestMethod.POST)
	public void doAA(MemberVO vo, Model model) {
		System.out.println("----------------");
		System.out.println(vo);
		System.out.println("----------------");
		model.addAttribute("vo", vo);
	
	}

	@GetMapping("/doB/{bno}") // doB/���� ������ �ش��ǰ�������� ���� ��
	public String doB(@PathVariable("bno") int bno) {
		System.out.println("===================");
		System.out.println("bno");
		System.out.println("===================");
		return "view";

	}

	//ResponseBody �⺻�� JSON
	@GetMapping("/doC")
	public @ResponseBody MemberVO doC() {
		MemberVO vo = new MemberVO();
		vo.setUserid("ȫ�浿");
		vo.setUserpw("aaa");
		return vo;

	}
	
	@GetMapping("/doD")
	public String doD(){
		System.out.println("doD called....");
		return "redirect:/doE";
	}
	
	@GetMapping("/doE")
	public void doE(){
		System.out.println("doE called....");
		
	}
	
	
	
}
