package com.tang2988.gold.console.module.info.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUpload {
	
	@RequestMapping("fileUpload.do")
	@ResponseBody
	public String fileUpload(HttpServletRequest request,HttpServletResponse response){
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
		MultipartFile mf = mhsr.getFile("image");
		File file = new File("D:\\xxh"+"/"+mf.getOriginalFilename());
		
		try {
			
			byte[] by = mf.getBytes();
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(by);
			fileOutputStream.close();
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mf.getOriginalFilename();
	}
		
	
}
