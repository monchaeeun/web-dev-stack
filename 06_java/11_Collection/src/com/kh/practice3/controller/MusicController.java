package com.kh.practice3.controller;

import java.util.ArrayList;

import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();

	// 1. 특정 곡 추가
	public String addList(String MusicName, String SinggerName) {

		if(MusicName.equals(" ") && SinggerName.equals(" "))
		{
			return "추가 실패";
		}
		
		for (int i = 0; i < list.size(); i++) {
			
				if (list.get(i).getSong().equals(MusicName) && 
						list.get(i).getArtist().equals(SinggerName)) {

					return "추가 실패";
				}
			}
		Music m = new Music();
		m.setSong(MusicName);
		m.setArtist(SinggerName);
		list.add(m);
		return "추가 성공";
	}

	// 2. 전체 곡 목록 출력
	public void printAll() {

		for (Music m : list) {
			System.out.println(m);
		}

	}

	// 3. 특정 곡 / 가수 검색
	public String searchMusic(String MusicName) {

		for (int i = 0; i < list.size(); i++) {
			if (list != null && list.get(i).getArtist().contains(MusicName) || 
					list.get(i).getSong().contains(MusicName) ) {
				return "(" + list.get(i).getArtist() + "-" + list.get(i).getSong() + ")을 검색했습니다.";
			}
		}
		return "검색할 곡을 찾지 못했습니다.";
	}

	// 4. 특정 곡 수정
	public String updateMusic(String searchSong, String setSong, String setSingger) {
		for (int i = 0; i < list.size(); i++) {
			if (list != null && list.get(i).getSong().equals(searchSong)) {
				list.get(i).setArtist(setSingger);
				list.get(i).setSong(setSong);
				return "해당 곡이 수정되었습니다.";
			}
		}
		return "검색할 곡을 찾지 못했습니다.";
	}

	// 5. 특정 곡 삭제
	public String removeMusic(String songName) {

		for (int i = 0; i < list.size(); i++) {
			if (list != null && list.get(i).getSong().equals(songName)) {
				Music m = new Music();
				m.setSong(list.get(i).getSong());
				m.setArtist(list.get(i).getArtist());
				list.remove(i);
				return "(" + m.getArtist() + "-" + m.getSong() + ")을 삭제했습니다.";
			}
		}
		return "삭제할 곡이 없습니다.";
	}

}