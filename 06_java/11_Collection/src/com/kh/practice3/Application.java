package com.kh.practice3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.kh.practice3.compare.SongAscending;
import com.kh.practice3.controller.MusicController;
import com.kh.practice3.model.Music;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();


	public static void main(String[] args) {
		
		Application app = new Application();
		app.menu();

	}
	
	public void menu() {
		try {
			boolean check = true;
			while(check) {
				System.out.println("===== 메인메뉴 =====");
				System.out.println("1. 특정 곡 추가");
				System.out.println("2. 전체 곡 목록 출력");
				System.out.println("3. 특정 곡 검색");
				System.out.println("4. 특정 곡 수정");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 종료");
				System.out.println("7. 가수명 내림차순");
				System.out.println("8. 곡명 오름차순");
				System.out.print("메뉴 번호 입력 : ");
				switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						addList();
						break;
					case 2:
						printAll();
						break;
					case 3:
						searchMusic();
						break;
					case 4:
						updateMusic();
						break;
					case 5:
						removeMusic();
						break;
					case 6:
						System.out.println("종료");
						check = false;
						break;
					case 7:
						descArtist();
						break;
					case 8:
						descArtist2();
						break;
					default: 
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			menu();
		}
	}
	
	//1. 특정 곡 추가
	public void addList() {
		/*
		 * ****** 특정 곡 추가 ******
		 * 곡명 : 
		 * 가수명 : 
		 * 
		 * 곡 추가 성공하면 "추가 성공"
		 *        실패하면 "추가 실패" -> 기존 똑같은 곡과 가수가 있을 시 
		 * */
		System.out.println("****** 특정 곡 추가 ******");
		System.out.print("곡 명 : ");
		String MusicName =sc.nextLine();
		System.out.print("가수 명 : ");
		String SinggerName =sc.nextLine();
		System.out.println(mc.addList(MusicName, SinggerName)); 
		
		
	}
	
	//2. 전체 곡 목록 출력
	public void printAll() {
		/*
		 * ****** 전체 곡 목록 출력 ******
		 * */
		System.out.println("****** 전체 곡 목록 출력 ******");
		mc.printAll();
	}
	
	//3. 특정 곡 검색
	public void searchMusic() {
		/*
		 * ****** 특정 곡 검색 ******
		 * 검색할 곡명 : 
		 * 
		 * 검색할 곡이 있다면 "(가수 - 곡)을 검색했습니다."
		 *          없다면 "검색할 곡을 찾지 못했습니다."
		 * */
		System.out.println("****** 특정 곡 검색(가수 / 곡) ******");
		System.out.print("키워드 : ");
		String songName = sc.nextLine();
		//equalsIgnoreCase <- 대소문자 무시
		ArrayList< Music> result = mc.searchMusic(songName);
		if(!result.isEmpty())
		{
			for(Music music : result)
			{
				System.out.println( "(" + music.getArtist() + "-" + music.getSong() + ")을 검색했습니다.");
			}
		}
		System.out.println(mc.searchMusic(songName));
		
	}
	
	//4. 특정 곡 수정(여러 결과가 나왔을 시)
	public void updateMusic() {
		/*
		 * ****** 특정 곡 수정 ******
		 * 검색할 곡명 : 
		 * 수정할 곡명 : 
		 * 수정할 가수명 : 
		 * -> 수정할 곡명/ 가수명을 입력했을 시 기존리스트에 있는 경우 수정 x
		 * 수정에 성공한다면 "(바꾸기 전 가수 - 바꾸기 전 곡)의 값이 변경되었습니다."
		 *       실패한다면 "곡을 수정하지 못했습니다."
		 * */
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡명 : ");
		String searchSong = sc.nextLine();
		
		ArrayList<Music> result = mc.checkMusic(searchSong);
		String searchArtist = null;
		if(result.size() > 1)
		{
			for(Music music : result)
			{
				System.out.println(music);
			}
			System.out.println("가수명 입력 : ");
			searchArtist = sc.nextLine();
		}
		
		System.out.print("수정할 곡명 : ");
		String setSong = sc.nextLine();
		System.out.print("수정할 가수명 :");
		String setSingger = sc.nextLine();
		System.out.println(mc.updateMusic(searchSong, setSong, searchArtist ,setSingger)); 
		
	}
	
	//5. 특정 곡 삭제
	public void removeMusic() {
		/*
		 * ****** 특정 곡 삭제 ******
		 * 삭제할 곡명 : 
		 * 
		 * 삭제에 성공한다면 "(삭제한 가수 - 삭제한 곡)을 삭제했습니다."
		 *      실패한다면 "삭제할 곡이 없습니다."
		 * */	
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡명 : ");
		String songName = sc.nextLine();
		System.out.println(mc.removeMusic(songName));
	}
	//가수명 내림차순
	public void descArtist()
	{
		System.out.println("****** 가수명 내림차순 정렬 ******");
		ArrayList<Music> list = mc.a();
		Collections.sort(list);
		Collections.reverse(list);
		for(Music music : list)
		{
			System.out.println(music);
		}
	}
	//곡명 오름차순
	public void descArtist2()
	{
		System.out.println("****** 곡명 오름차순 정렬 ******");
		ArrayList<Music> list = mc.a();
		Collections.sort(list, new SongAscending());
		
		for(Music music : list)
		{
			System.out.println(music);
		}
	}
}