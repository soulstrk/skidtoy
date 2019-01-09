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
import org.springframework.web.multipart.MultipartFile;

import com.skid.skidtoy.board.service.BoardService;
import com.skid.skidtoy.board.vo.BoardVo;
import com.skid.skidtoy.upload.service.UploadService;
import com.skid.skidtoy.upload.vo.FileUploadVo;
import com.skid.skidtoy.util.PageUtil;
import com.skid.skidtoy.util.UploadFileUtils;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardSerivce;
	
	@Resource
	private UploadService uploadService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String init() {
		return "home";
	}
	
	@RequestMapping(value="/board", method= { RequestMethod.POST, RequestMethod.GET })
	public String boardInit(@RequestParam(defaultValue = "1") String pageNum, Model model) throws Exception {
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
	
	@RequestMapping(value = "/board/write")
	public String boardWrite() {
		return "write";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/board/upload", method=RequestMethod.POST)
	public String boardUpload(BoardVo boardVo, MultipartFile file) throws Exception{
		FileUploadVo fileUploadVo = null;
		
		if (file.getSize() != 0 || file.getOriginalFilename() != "") {
			String originalName = file.getOriginalFilename();
			byte[] fileData = file.getBytes();
			
			Map<String, String> map = UploadFileUtils.uploadFile(uploadPath, originalName, fileData);			
			
			boardSerivce.insBoardInfo(boardVo);
			
			fileUploadVo = new FileUploadVo(0, boardVo.getbNum(), originalName, map.get("savedFileName"), String.valueOf(file.getSize()));
			
			uploadService.insUploadFile(fileUploadVo);
		} else { 
			boardSerivce.insBoardInfo(boardVo);
		}
		
		return "forward:/board";
	}
	
	@RequestMapping(value = "/board/upload/proc", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> ajaxUpload(BoardVo boardVo, MultipartFile file) throws Exception{
		FileUploadVo fileUploadVo = new FileUploadVo();
		
		Map<String, Object> map = new HashMap<>();
		
		return map;
	}
}










