package com.kh.paging.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PagingDTO {

	private int offset = 0;// 시작 위치
	private int limit = 10;// 개수
	private int page = 1;// 현재 페이지
	private int pageSize = 10; // 한 페이지당 페이지 개수
	private int endPage = this.pageSize; // 한 페이지의 마지막 페이지 수
	private int startPage = endPage - this.pageSize + 1; // 한 페이지의 첫 페이지 수 
	/*
	 * page : 1 ~ 10 -? end page = 10
	 * page : 11 ~ 20 -? end page = 20
	 * page : 21 ~ 30 -? end page = 30
	 * 
	 */			
	private boolean prev;
	private boolean next;
	
	//페이지 들어감
	public PagingDTO(int page, int total)
	{
		this.page = page;
		this.endPage = (int)(Math.ceil((double)page/this.pageSize) * this.pageSize);
		this.startPage = this.endPage - this.pageSize + 1;
		
		//전체 개수를 통해서 마지막 페이지
		int lastPage = (int)Math.ceil((double) total/ this.limit); 

		if(lastPage < this.endPage)
		{
			this.endPage = lastPage;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
	}

}
