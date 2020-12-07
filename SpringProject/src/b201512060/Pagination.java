package b201512060;

//���댁� 泥�由�
public class Pagination {
	
	private int totalPages;//��泥� ���댁�
	private int beginPage;//�������댁�
	private int endPage;//�����댁�
	private int curPage; //�������댁�
	private int paginationCount; //珥� 紐�媛��� ���댁�
	private int startRow;//���� ����
	private int endRow;//������
	private int totalRows;//��泥� ����
	
	//��泥� ����媛���, 吏����� ���댁� 踰���, �����댁��� 蹂댁�ъ� ����(3), �����댁��� 蹂댁�ъ� ���댁� 媛��� 
	public void processPaging (int totalRows, int pageNum, int rowsPerPage, int paginationPerPage) {
		//��泥� ���� 吏���
		this.totalRows = totalRows;
		//���ы���댁�瑜� �ъ�⑹��媛� 吏����� ���댁�濡�
		curPage = pageNum;
		//遺��ъ�щ�� rowsPerPage�� 3�쇰� 吏���������. 蹂� �ㅻⅨ 吏������� 諛�濡� ���대�ㅻ㈃  pageNum�� 1濡� 吏�������
		//泥ル�吏� ���댁�瑜� 遺��ъ�ш��대��.((1 -1) * 3 + 1) 
		//�ㅼ���쇰� 2���댁�瑜� 遺��ъ�щ���� pageNum�� parameter濡� ��寃� 諛���寃��� 
		//request.getParameter("pageNum")濡�諛�����  pageNum�� 媛��� 蹂�寃쎈����.		
		startRow = (curPage - 1) * rowsPerPage + 1;
		//泥����대�쇰㈃ 1 + 3 - 1 = 3�쇰� 1~3源�吏��� �곗�댄�곕� 媛��몄�ш��대��. 
		endRow = startRow + rowsPerPage - 1;
		//endRow = curPage * rowsPerPage ;
		//�����댁��� 蹂댁�ъ� ���댁� ��紐�, �댄��媛��� >>濡� ���닿��쇳����.
		paginationCount = paginationPerPage;
		//��泥� ���댁� 媛����� ��泥� �������� �����댁��� 蹂댁�ъ� ������ 媛���瑜� ����以���.
		totalPages = totalRows / rowsPerPage; 
		if((totalRows % rowsPerPage) > 0)
			totalPages++; 
		
		if(totalPages > 0) { 
			beginPage = (pageNum - 1) / paginationPerPage * paginationPerPage + 1; 
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
