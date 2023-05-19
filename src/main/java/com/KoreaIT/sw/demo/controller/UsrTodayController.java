package com.KoreaIT.sw.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.sw.demo.service.TodayService;
import com.KoreaIT.sw.demo.util.Ut;
import com.KoreaIT.sw.demo.vo.todayeat;

@Controller
public class UsrTodayController {
	
	@Autowired
	private TodayService todayService;
	
	@RequestMapping("/usr/today/menu")
	@ResponseBody
	public String doEat(String menu, String location, String shop) {
		return Ut.jsReplace("맛있게 드세요!", "/");	}
	
	@RequestMapping("/usr/today/whopay")
	public  String whopay() {
		return "usr/whopay/whopay";
	}
	
	@RequestMapping("/usr/today/doEat")
	@ResponseBody
	public String doEat(ArrayList<Map<String, Object>> eatmembers) {
		String date;
		String location;
		String menu;
		String usergender;
		int userage;
		return "usr/whopay/~!~!";
	}
	@RequestMapping("/usr/today/getRankList")
	public String getRankLists(String listElement, String listValue, Model model){
		List<todayeat> rankLists=todayService.getRankLists(listElement, listValue);
		model.addAttribute("rankList", rankLists);
		
		return "asds";
	}
	
	@RequestMapping("/usr/today/whopaynum")
	public String whopaynum(String number, Model model) {
		model.addAttribute("num", number);
		return "usr/whopay/whopaynum";
	}
	
	@RequestMapping("/usr/today/where")
	public String where() {
		return "usr/menuselec/menuselec";
	}
}
