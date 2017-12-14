package com.storm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.storm.Service.ChartService;
import com.storm.VO.GenreVO;

@Controller
//이 컨트롤러는 파일 업로드용 컨트롤러 역활만 하도록 약속했므로..
//파일 업로드 요청의 공통 사항을 미리 밝혀 주어서 다음 부터는 변경된 내용만
//처리하도록 하자.
@RequestMapping("/Chart")
public class ChartController {
	
	@Autowired
	private 	ChartService		chService;
	
	@RequestMapping("/ChartView")
	public ModelAndView ChartView(){

		ModelAndView	mv = new ModelAndView();
		ArrayList list = chService.GenreView();
		ArrayList lang = chService.LangView();
		
		ArrayList tag = chService.TagView();
		Gson gson = new Gson();
		String jtag = gson.toJson(tag);
		jtag=jtag.toLowerCase();
		
		mv.addObject("LANG",lang);
		mv.addObject("LIST", list);
		mv.addObject("TAG", jtag);
		
		mv.setViewName("Chart/ChartView");
		return mv;

	}
}
