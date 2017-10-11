package library.domain.checkers;

import static org.junit.Assert.*;

import java.util.Date;

import library.domain.Book;
import library.domain.BorrowingOrder;
import library.domain.User;

import org.junit.Test;

public class BorrowingorderCheckerTest {

	@Test
	public void test_borrowingorder_checker_should_check_borrowingorder_user(){
		BorrowingorderChecker checker = new BorrowingorderChecker();
		
		BorrowingOrder borrowingorderWithUser = new BorrowingOrder();
		borrowingorderWithUser.setUser(new User());
		BorrowingOrder borrowingorderWithNullUser = new BorrowingOrder();
		
		boolean isBorrowingOrderValid = checker.vaildBorrowingorderUser(borrowingorderWithUser);
		boolean isBorrowingOrderWithNullUserValid = checker.vaildBorrowingorderUser(borrowingorderWithNullUser);
		
		assertTrue("BorrowingOrder with user should be a valid actor", isBorrowingOrderValid);
		assertFalse("BorrowingOrder with null user should be invalid", isBorrowingOrderWithNullUserValid);
	}
	
	@Test
	public void test_borrowingorder_checker_should_check_borrowingorder_book(){
		BorrowingorderChecker checker = new BorrowingorderChecker();
		
		BorrowingOrder borrowingorderWithBook = new BorrowingOrder();
		borrowingorderWithBook.setBook(new Book());
		BorrowingOrder borrowingorderWithNullBook = new BorrowingOrder();
		
		boolean isBorrowingOrderValid = checker.vaildBorrowingorderBook(borrowingorderWithBook);
		boolean isBorrowingOrderWithNullUserValid = checker.vaildBorrowingorderBook(borrowingorderWithNullBook);
		
		assertTrue("BorrowingOrder with book should be a valid actor", isBorrowingOrderValid);
		assertFalse("BorrowingOrder with null book should be invalid", isBorrowingOrderWithNullUserValid);
	}
	
	@Test
	public void test_borrowingorder_checker_should_check_borrowingorder_dateFrom(){
		BorrowingorderChecker checker = new BorrowingorderChecker();
		
		BorrowingOrder borrowingorderWithDateFrom = new BorrowingOrder();
		borrowingorderWithDateFrom.setDateFrom(new Date());
		BorrowingOrder borrowingorderWithNullDateFrom = new BorrowingOrder();
		
		boolean isBorrowingOrderValid = checker.vaildBorrowingorderDateFrom(borrowingorderWithDateFrom);
		boolean isBorrowingOrderWithNullUserValid = checker.vaildBorrowingorderDateFrom(borrowingorderWithNullDateFrom);
		
		assertTrue("BorrowingOrder with dateFrom should be a valid actor", isBorrowingOrderValid);
		assertFalse("BorrowingOrder with null dateFrom should be invalid", isBorrowingOrderWithNullUserValid);
	}
	
	@Test
	public void test_borrowingorder_checker_should_check_borrowingorder_dateTo(){
		BorrowingorderChecker checker = new BorrowingorderChecker();
		
		BorrowingOrder borrowingorderWithDateTo = new BorrowingOrder();
		borrowingorderWithDateTo.setDateTo(new Date());
		BorrowingOrder borrowingorderWithNullDateTo = new BorrowingOrder();
		
		boolean isBorrowingOrderValid = checker.vaildBorrowingorderDateTo(borrowingorderWithDateTo);
		boolean isBorrowingOrderWithNullUserValid = checker.vaildBorrowingorderDateTo(borrowingorderWithNullDateTo);
		
		assertTrue("BorrowingOrder with dateTo should be a valid actor", isBorrowingOrderValid);
		assertFalse("BorrowingOrder with null dateTo should be invalid", isBorrowingOrderWithNullUserValid);
	}
}
