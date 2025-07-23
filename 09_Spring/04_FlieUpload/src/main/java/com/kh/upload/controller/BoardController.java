package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.Service.BoardService;

@Controller
public class BoardController {

    private final CustomErrorController customErrorController;

    
    
    BoardController(CustomErrorController customErrorController) {
        this.customErrorController = customErrorController;
    }
    
    @Autowired
    private BoardService service;
    public String fileUpload(MultipartFile file)
    {
    	UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() +"_"+ file.getOriginalFilename();
		System.out.println(fileName);
		File copyFile = new File("\\\\192.168.0.35\\upload\\"+ fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
    	return fileName;
    }
    
    
	@GetMapping("/")
	public String index()
	{
		return "/index";
	}
	@PostMapping("/upload")
	public String upload(MultipartFile file)
	{
		System.out.println("파일명 : "+file);
		
		String name = file.getOriginalFilename();		
		System.out.println("파일명 : "+ name);
		
		long size = file.getSize();
		System.out.println("파일명 : "+ size);
		
		String param = file.getName();
		System.out.println("파라미터 명 : " + param);
		
		String fileName = fileUpload(file);
		//http://localhost:8081/ + fileName <- url
		return "redirect:/";
	}
	
	//List <MultipartFile>
	@PostMapping("/multyUpload")
	public String multyUpload(List <MultipartFile> file)
	{
			//중복 방지를 위한 UUID 적용
			for(MultipartFile li : file)
			{
				String fileName = fileUpload(li);
				
			}
		return "redirect:/";
	}
}
