package model;


public class Pagination {
	
	private int totalPages;
	private int beginPage;
	private int endPage;
	private int curPage; // ���� ������
	private int paginationCount; // ������ ǥ�� ����
	private int startRow;
	private int endRow;
	private int totalRows;
	
	public void processPaging (int totalRows, int pageNum, int rowsPerPage, int paginationPerPage) {
		// pageNum�� ������ ���� ���� ��� 1
		this.totalRows = totalRows;
		curPage = pageNum;
		startRow = (pageNum - 1) * rowsPerPage + 1;
		endRow = startRow + rowsPerPage - 1;		    		
		paginationCount = paginationPerPage;
		
		totalPages = totalRows / rowsPerPage; // �������� ���� ���� �� ���� ������ �� �������� ����(������)
		if((totalRows % rowsPerPage) > 0)
			totalPages++; // ���� ���� �ִ� ��� 1 �������� �߰��Ͽ� �� �������� ��ȯ��
		
		if(totalPages > 0) { // �� �������� 1�� ��� ���� �������� 1, ������ �������� 1��
			beginPage = (pageNum - 1) / paginationPerPage * paginationPerPage + 1; // ���� �������� ���� �������� ����
			endPage = beginPage + paginationPerPage - 1;
			if(endPage > totalPages)
				endPage = totalPages;
		}    
		
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPaginationCount() {
		return paginationCount;
	}

	public void setPaginationCount(int paginationCount) {
		this.paginationCount = paginationCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	

}
