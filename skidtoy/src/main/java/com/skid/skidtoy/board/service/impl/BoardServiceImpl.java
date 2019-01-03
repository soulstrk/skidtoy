package com.skid.skidtoy.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skid.skidtoy.board.mapper.BoardMapper;
import com.skid.skidtoy.board.service.BoardService;
import com.skid.skidtoy.board.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Resource
	private BoardMapper boardMapper;

	@Override
	public List<BoardVo> selAllList(Map<String, Object> map) throws Exception {
		return boardMapper.selectAllList(map);
	}

	@Override
	public int selRowCount() throws Exception {
		return boardMapper.selectRowCount();
	}

}
