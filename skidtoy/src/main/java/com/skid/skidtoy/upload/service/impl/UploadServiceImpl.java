package com.skid.skidtoy.upload.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skid.skidtoy.upload.mapper.UploadMapper;
import com.skid.skidtoy.upload.service.UploadService;
import com.skid.skidtoy.upload.vo.FileUploadVo;

@Service
public class UploadServiceImpl implements UploadService{
	
	@Resource
	private UploadMapper uploadMapper;

	@Override
	public void insUploadFile(FileUploadVo fileUploadVo) throws Exception {
		uploadMapper.insUploadFile(fileUploadVo);
	}
	
}
