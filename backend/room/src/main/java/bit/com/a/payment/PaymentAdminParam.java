package bit.com.a.payment;

import java.io.Serializable;

public class PaymentAdminParam implements Serializable {
	private int pageNumber = 1;
	private int recordCountPerPage = 10;
	
	private int start = 1;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "PaymentAdminParam [pageNumber=" + pageNumber + ", recordCountPerPage=" + recordCountPerPage + ", start=" + start + "]";
	}
}
