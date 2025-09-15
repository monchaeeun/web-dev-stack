package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.dto.PageDTO;
import com.kh.upload.Service.BoardService;
import com.kh.upload.dto.BoardDTO;
import com.kh.upload.dto.PageDTO;
import com.kh.upload.vo.Board;

@Controller
public class BoardController {
	private final CustomErrorController customErrorController;
	BoardController(CustomErrorController customErrorController) {
		this.customErrorController = customErrorController;
	}

	private String path =  "\\\\192.168.0.35\\upload\\";
	
    @Autowired
    private BoardService service;
    
    public String fileUpload(MultipartFile file)
    {
    	UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() +"_"+ file.getOriginalFilename();
		System.out.println(fileName);
		File copyFile = new File(path+ fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
    	return fileName;
    }
    
    //파일 삭제
    public void deleteFile(int no)
    {
    	Board board = service.select(no);
		String url = path + board.getUrl();
		File file = new File(url);
		file.delete();
    }
    
    
    
//	@GetMapping("/")
//	public String index()
//	{
//		return "/index";
//	}
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
	
	@GetMapping("/list")
	public String list(Model model, PageDTO paging) 
	{
		List<BoardDTO> list =  service.showBoard(paging);
		model.addAttribute("list",list);
		model.addAttribute("paging", new PageDTO(paging.getPage(), service.total(), paging.getKeyword()));
		return "list";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		String file = fileUpload(dto.getFile());
		Board board = new Board();
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		board.setUrl(file);
		service.insert(board);
		return "redirect:/view?no="+ board.getNo();
	}
	
	
	@GetMapping("/view")
	public String view(int no, Model model) {
	    Board board = service.select(no);
	    model.addAttribute("board", board);
	    return "view"; // → /WEB-INF/view.jsp로 이동
	}
	
	@ResponseBody
	@PostMapping("/update")
	public int updateInfo(BoardDTO dto)
	{
		if(dto.getFile() == null 
				&& dto.getTitle().equals("")
				&& dto.getContent().equals(""))
		{
			System.out.println("해당 페이지가 없습니다.");
			return -1;
		}
		
		
		//만약 파일이 있으면
		if(!dto.getFile().isEmpty())
		{
			//파일 삭제
			deleteFile(dto.getNo());
			
			String newUrl = fileUpload(dto.getFile());
			dto.setUrl(newUrl);	
		}
		//파일 생성 및 정보 업데이트
		int success= service.update(dto);
		
		if(success > 0)
		{
			return dto.getNo();			
		}
		return 0;
	}
	
	@ResponseBody
	@PostMapping("/delete")
	public int deleteInfo(int no)
	{
		deleteFile(no);
		int success= service.delete(no);
		if(success > 0)
		{
			return no;			
		}
		return 0;
	}
	
	@GetMapping("/delete")
	public String delete(int no)
	{
		deleteFile(no);
		service.delete(no);
		return "redirect:/";
	}
	
	@PostMapping("/search")
	public String search(Model model,PageDTO paging)
	{
		List<BoardDTO> list = service.search(paging);
		if(paging.getKeyword().trim().isEmpty()|| paging.getKeyword() == null)
		{
			return "redirect:/list";
		}
		int total = service.searchTotal(paging.getKeyword());
		model.addAttribute("list", list);
		model.addAttribute("paging", new PageDTO(paging.getPage(), total, paging.getKeyword()));
		return "/list";
	}
	
	@GetMapping("/search")
	public String searchPage(Model model,PageDTO paging)
	{
		List<BoardDTO> list = service.search(paging);
		if(paging.getKeyword().trim().isEmpty()|| paging.getKeyword() == null)
		{
			return "redirect:/list";
		}
		int total = service.searchTotal(paging.getKeyword());
		model.addAttribute("list", list);
		model.addAttribute("paging", new PageDTO(paging.getPage(), total, paging.getKeyword()));
		return "/list";
	}
	
	
}
