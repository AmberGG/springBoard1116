package org.zerock.web;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MemberVO;
 
@Controller
@RequestMapping("/smem/*")
public class SmemController {
 
	
	//@GetMapping  //스프링4점대 버전에서 쓰임 
	@RequestMapping(value="/doA", method=RequestMethod.GET)
	public void doA(MemberVO vo, Model model){
		System.out.println("================");
		System.out.println(vo);
		model.addAttribute("vo", vo);
 
	}
	
	@RequestMapping(value="/doAA", method=RequestMethod.POST)
	public void doAA(MemberVO vo, Model model){
		System.out.println("---------------");
		System.out.println(vo);
		model.addAttribute("vo", vo);
		
	}
	
	@GetMapping("/doB/{bno}")
	public String doB(@PathVariable("bno") int bno){
		System.out.println("================");
		System.out.println(bno);
		
		return "view";
	}
	
	@GetMapping("/doC")
	public @ResponseBody MemberVO doC(){
		
		MemberVO vo = new MemberVO();
		vo.setUserid("이승우");
		vo.setUserpw("aaa");
		
		return vo;
		//responsebody 기본이 json
	}
	@GetMapping("/doD")
	public String doD(){
		System.out.println("doD called...");
		
		return "redirect:./doE";
	}
	@GetMapping("/doE")
	public void doE(){
		System.out.println("doE called...........");
	}
 	
}