package com.skid.skidtoy.upload.service;

import com.skid.skidtoy.upload.vo.FileUploadVo;

public interface UploadService {
	
	public void insUploadFile(FileUploadVo fileUploadVo) throws Exception;
	
}
