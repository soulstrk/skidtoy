package com.skid.skidtoy.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skid.skidtoy.board.service.BoardService;
import com.skid.skidtoy.board.vo.BoardVo;
import com.skid.skidtoy.util.PageUtil;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardSerivce;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String init() {
		return "home";
	}
	
	@RequestMapping(value="/board", method= { RequestMethod.POST, RequestMethod.GET })
	public String boardInit(@RequestParam(defaultValue = "1") String pageNum, Model model) throws Exception {
		System.out.println(pageNum);
		Map<String, Object> boardMap = new HashMap<>();
		
		int totalRowCount = boardSerivce.selRowCount();
		
		PageUtil pu = new PageUtil(Integer.parseInt(pageNum), totalRowCount, 5, 5);
		
		boardMap.put("pu", pu);
		
		List<BoardVo> list = boardSerivce.selAllList(boardMap);
		
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		
		return "board";
	}
	
	@RequestMapping(value="/board/proc", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> boardProc(String pageNum) {
		Map<String, Object> boardMap = new HashMap<>();
		
		try {
			int totalRowCount = boardSerivce.selRowCount();
			
			PageUtil pu = new PageUtil(Integer.parseInt(pageNum), totalRowCount, 5, 5);
			
			boardMap.put("pu", pu);
			
			List<BoardVo> list = boardSerivce.selAllList(boardMap);
			
			boardMap.put("list", list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			boardMap.put("err", "error");
		}
		
		return boardMap;
	}
}










