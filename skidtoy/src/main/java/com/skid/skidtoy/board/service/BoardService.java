package com.skid.skidtoy.board.service;

import java.util.List;
import java.util.Map;

import com.skid.skidtoy.board.vo.BoardVo;

public interface BoardService {
	
	public List<BoardVo> selAllList(Map<String, Object> map) throws Exception;
	
	public int selRowCount() throws Exception;
	
	public void insBoardInfo(BoardVo boardVo) throws Exception;
	
	public BoardVo selBoardInfo(int bNum) throws Exception;
	
}
