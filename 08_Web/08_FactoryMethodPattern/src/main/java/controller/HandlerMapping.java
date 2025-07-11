package controller;

import controller.component.AllMemberController;
import controller.component.LogInController;
import controller.component.LogOutController;
import controller.component.RegisterController;
import controller.component.SearchController;

/*
 * Controller 들을 만들어내는 공장
 * DispatcherServlet에서 보내주는 command 값에 따라서 생성하는 Controller가 달라진다.
 * 여러 개의 Controller들을 만들어내지만 공장에 해당하는 HandlerMapping 은
 * 단 하나면 충분하기 때문에 싱글톤 패턴 작성
 */
public class HandlerMapping 
{
	private static HandlerMapping handler = new HandlerMapping();
	
	private HandlerMapping(){
	
	}
	
	public static HandlerMapping getInstance()
	{
		return handler;
	}
	
	public Controller createController(String command)
	{
		System.out.println("들어온 command : "+ command);
		Controller controller = null;
		if(command.equals("register.do"))
		{
			controller = new RegisterController();
		}
		else if(command.equals("login.do"))
		{	
			controller = new LogInController();
		}
		else if(command.equals("allMember.do"))
		{
			controller = new AllMemberController();
		}
		else if(command.equals("search.do"))
		{
			controller = new SearchController();
		}
		else if(command.equals("logout.do"))
		{
			controller = new LogOutController();
		}
		
		return controller;			
	}
	
}
