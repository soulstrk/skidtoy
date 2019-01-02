package com.skid.skidtoy.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skid.skidtoy.board.service.BoardService;
import com.skid.skidtoy.board.vo.BoardVo;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardSerivce;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String boardInit() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", 0);
		map.put("endRow", 10);
		List<BoardVo> list = boardSerivce.selAllList(map);
		
		System.out.println(list.get(0));
		
		return "home";
	}
}
