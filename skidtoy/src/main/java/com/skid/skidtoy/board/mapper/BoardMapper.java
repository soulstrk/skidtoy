package com.skid.skidtoy.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.skid.skidtoy.board.vo.BoardVo;

@Mapper
public interface BoardMapper {

	public List<BoardVo> selectAllList(Map<String, Object> map) throws Exception;
	
	public int selectRowCount() throws Exception;
	
	public void insBoardInfo(BoardVo boardVo) throws Exception;
	
	public BoardVo selBoardInfo(int bNum) throws Exception;
}
