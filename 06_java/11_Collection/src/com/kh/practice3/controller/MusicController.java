package com.kh.practice3.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();

	// 1. 특정 곡 추가
	public String addList(String MusicName, String SinggerName) {

		if (MusicName.trim().equals(" ") || SinggerName.trim().equals(" ")) {
			return "추가 실패";
		}

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getSong().equals(MusicName) && list.get(i).getArtist().equals(SinggerName)) {

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

		if (list != null) {
			for (Music m : list) {
				System.out.println(m);
			}
		} else {
			System.out.println("곡이 없습니다.");
		}
	}

	// 3. 특정 곡 / 가수 검색
	public ArrayList<Music> searchMusic(String MusicName) {
		ArrayList<Music> result = new ArrayList<Music>();
		for (Music music : list) {
			// equalsIgnoreCase <- 대소문자 무시
			// toLowerCase <- 단어를 전부 소문자로 바꿔서 비교
			if (list != null && music.getSong().toLowerCase().contains(MusicName.toLowerCase())
					|| music.getArtist().toLowerCase().contains(MusicName.toLowerCase())) {
				result.add(music);
			}
		}
		return result;
	}

	// 4. 특정 곡 수정
	public String updateMusic(String searchSong, String setSong, String searchArtist, String setSingger) {
		// 만약 수정하려는 곡이 이미 있다면
		for (Music music : list) {
			if (music.getSong().equals(setSong) && music.getArtist().equals(setSingger)) {

				return "이미 존재하는 곡 입니다.";
			}
			
		}
		//수정할 곡에 빈칸으로 제출한다면
		if(setSong.trim().equals("") || setSingger.trim().equals(""))
		{
			return "존재하지 않는 곡 입니다.";
		}
			
			//곡 수정
			for (Music music : list) {
				//곡 명이 안겹치는 경우
				if (list != null && searchArtist == null && music.getSong().equals(searchSong)) {
					
					music.setArtist(setSingger);
					music.setSong(setSong);
					return "해당 곡이 수정되었습니다.";
				//곡 명이 겹치는 경우
				} else if (list != null && music.getArtist().equals(searchArtist)
						&& music.getSong().equals(searchSong))
				{
					music.setArtist(setSingger);
					music.setSong(setSong);
					return "해당 곡이 수정되었습니다.";
				}
			}
		
		return "곡 수정에 실패하였습니다.";

	}

	// 곡 검색 시 중복된 경우
	public ArrayList<Music> checkMusic(String song) {
		ArrayList<Music> result = new ArrayList<Music>();
		for (Music music : list) {
			if (music.getSong().equals(song)) {
				result.add(music);
			}
		}
		return result;
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
	
	public ArrayList<Music> a() {

		if (list != null) {
		return list;
		}
		return null;
	}

}