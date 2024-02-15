package com.groupb.cuiz.support.util.pager;

public class Pager {
	
	private Long startRow;
	private Long lastRow;
	private Long perPage=10L; //10개씩 조회로 설정함
	private Long page;
	
	private Long totalPage;
	private Long startNum;
	private Long lastNum;
	
	//블록이 없으면 true
	private boolean start;
	private boolean last;
		
	//검색
	private String search;
	private String kind;
	private String searchItem;
	private String member_Id;
	private String sort;
	
	

	//startRow, lastRow 계산
	public void makeRow() {
		this.lastRow=this.getPage()*this.getPerPage();
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		
	}
	
	public void makeNum(Long totalCount) {
		if(totalCount<1) {
			totalCount=1L;
		}
		Long totalPage=0L;
		totalPage=totalCount/this.getPerPage();
		
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}
		
		this.setTotalPage(totalPage);
		
		//블럭수
		Long perBlock=5L; //블럭당 5개로 설정함
		Long totalBlock=0L;
		totalBlock=totalPage/perPage;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		//현재 블럭 번호
		Long curBlock=0L; //블럭 번호
		curBlock=this.getPage()/perBlock;
		if(this.getPage()%perBlock !=0) {
			curBlock++;
		}
		
		//시작번호 끝 번호
		Long startNum=0L;
		Long lastNum=curBlock*perBlock;
		startNum=lastNum-perBlock+1;
		
		this.setStartNum(startNum);
		this.setLastNum(lastNum);
	
		//블럭 유무
		if(curBlock==1) {
			this.setStart(true);
			
		}
		if(curBlock==totalBlock) {
			this.setLastNum(totalPage);
			this.setLast(true);
		}
	}
	
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page==null||this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getSearchItem() {
		return searchItem;
	}

	public void setSearchItem(String searchItem) {
		this.searchItem = searchItem;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	





}
