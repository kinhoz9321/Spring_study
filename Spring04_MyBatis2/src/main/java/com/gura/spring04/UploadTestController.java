package com.gura.spring04;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadTestController {
	@RequestMapping("/upload")
	public String upload(@RequestParam String title, MultipartFile myFile, HttpServletRequest request) {
		//원본파일명
		String orgFileName=myFile.getOriginalFilename();
		//파일의 크기
		long fileSize=myFile.getSize();
		//파일을 저장할 실제 경로
		String realPath=request.getServletContext().getRealPath("/upload");
		
		File f=new File(realPath);
		if(!f.exists()) {//만일 존재하지 않으면
			f.mkdir();//폴더를 만든다.
		}
		
		//저장할 파일명을 구성한다.
		String saveFileName=System.currentTimeMillis()+orgFileName;
		//저장할 파일의 전체 경로를 구성한다.
		String path=realPath+File.separator+saveFileName;
		
		try {
			File f2=new File(path);
			myFile.transferTo(f2);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//전송된 정보를 view page 에서 확인하기 위해 request scope 에 담기
		request.setAttribute("orgFileName", orgFileName);
		request.setAttribute("saveFileName", saveFileName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("path", path);
		request.setAttribute("title", title);
		
		return "upload";
	}
	
	@RequestMapping("/upload2")
	public String upload(FileDto dto, HttpServletRequest request) {
		//2개 추가
		//FileDto 에 있는 MultipartFile 객체의 참조값
		MultipartFile myFile=dto.getMyFile();
		//폼 전송된 title
		String title=dto.getTitle();
		
		//원본파일명
		String orgFileName=myFile.getOriginalFilename();
		//파일의 크기
		long fileSize=myFile.getSize();
		//파일을 저장할 실제 경로
		String realPath=request.getServletContext().getRealPath("/upload");
		
		File f=new File(realPath);
		if(!f.exists()) {//만일 존재하지 않으면
			f.mkdir();//폴더를 만든다.
		}
		
		//저장할 파일명을 구성한다.
		String saveFileName=System.currentTimeMillis()+orgFileName;
		//저장할 파일의 전체 경로를 구성한다.
		String path=realPath+File.separator+saveFileName;
		
		try {
			File f2=new File(path);
			myFile.transferTo(f2);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//전송된 정보를 view page 에서 확인하기 위해 request scope 에 담기
		request.setAttribute("orgFileName", orgFileName);
		request.setAttribute("saveFileName", saveFileName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("path", path);
		request.setAttribute("title", title);
		
		return "upload";
	}
}
