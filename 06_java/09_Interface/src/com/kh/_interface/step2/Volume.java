package com.kh._interface.step2;

public interface Volume {
	//상수
	//인터페이스에서 멤버변수는 무조건 상수!
 	public static final int MIN_VOLUME = 0;
 	int MAX_VOLUME = 20;
 	
 	void setVolume(int volume);
}
