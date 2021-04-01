package com.myspring.pro27.board;

public class Paging {
	
	private int listSize = 10;
	private int rangeSize = 5;
	private int page;
	private int range;
	private int listCnt;
	private int pageCnt;
	private int startPage;
	private int startList;
	private int endPage;
	private boolean prev;
	private boolean next;
	private String search;
	
	public void pageInfo(int page, int range, int listCnt){
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		
		//전체 페이지 수
		this.pageCnt = (int)Math.ceil((float)listCnt/(float)listSize);
		System.out.println("pageCnt : " + pageCnt);
		
		//시작페이지
		this.startPage = (range - 1) * rangeSize + 1;
		
		//끝 페이지
		this.endPage = range * rangeSize;
		
		//게시판 시작번호
		this.startList = (page - 1) * listSize + 1;
		
		this.listSize = startList + 9;
		
		//이전 버튼 상태
		this.prev = startList == 1 ? false : true;
		
		//다음 버튼 상태
		this.next = page < pageCnt ? true : false;
		if(this.endPage > this.pageCnt){
			this.endPage = this.pageCnt;
		}
		
	}
	
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getRangeSize() {
		return rangeSize;
	}
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getListCnt() {
		return listCnt;
	}
	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getStartList() {
		return startList;
	}
	public void setStartList(int startList) {
		this.startList = startList;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}
