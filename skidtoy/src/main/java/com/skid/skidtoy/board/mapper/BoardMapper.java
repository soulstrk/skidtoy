package com.skid.skidtoy.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.skid.skidtoy.board.vo.BoardVo;

@Mapper
public interface BoardMapper {

	public List<BoardVo> selectAllList(Map<String, Object> map);
}
