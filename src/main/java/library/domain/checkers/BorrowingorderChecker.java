package library.domain.checkers;

import library.domain.BorrowingOrder;

public class BorrowingorderChecker {

	public boolean vaildBorrowingorderUser(BorrowingOrder borrowingorder){
		return borrowingorder.getUser() != null;
	}
	
	public boolean vaildBorrowingorderBook(BorrowingOrder borrowingorder){
		return borrowingorder.getBook() != null;
	}
	
	public boolean vaildBorrowingorderDateFrom(BorrowingOrder borrowingorder){
		return borrowingorder.getDateFrom() != null;
	}
	
	public boolean vaildBorrowingorderDateTo(BorrowingOrder borrowingorder){
		return borrowingorder.getDateTo() != null;
	}
}
