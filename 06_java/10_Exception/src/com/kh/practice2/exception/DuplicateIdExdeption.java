package com.kh.practice2.exception;

public class DuplicateIdExdeption extends Exception{

	public DuplicateIdExdeption() {
		this("중복된 사람이 있어서 에러 발생!");
	}
	public DuplicateIdExdeption(String messege) {
		super(messege);
	}
	
	
	
}
