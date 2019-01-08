package com.skid.skidtoy.upload.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.skid.skidtoy.upload.vo.FileUploadVo;

@Mapper
public interface UploadMapper {
	
	void insUploadFile(FileUploadVo fileUploadVo) throws Exception;
	
}
