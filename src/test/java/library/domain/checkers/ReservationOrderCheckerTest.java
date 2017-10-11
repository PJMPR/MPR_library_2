package library.domain.checkers;

import library.domain.ReservationOrder;
import library.domain.User;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

/**
 * Created by Owner on 11/10/2017.
 */
public class ReservationOrderCheckerTest {

    @Test
    public void test_reservationOrder_checker_should_check_reservationOrder() {
        ReservationOrderChecker checker = new ReservationOrderChecker();

        ReservationOrder reservationOrderWithUser= new ReservationOrder();
        reservationOrderWithUser.setUser(new User());
        ReservationOrder reservationOrderWithNullUser= new ReservationOrder();


        ReservationOrder reservationOrderWithDate= new ReservationOrder();
        reservationOrderWithDate.setDate(new Date());
        ReservationOrder reservationOrderWithNullDate= new ReservationOrder();

        boolean isReservationOrderWithUser= checker.isValidUser(reservationOrderWithUser);
       boolean isReservationOrderWithNullUser= checker.isValidUser(reservationOrderWithNullUser);

       boolean isReservationOrderWithDate=checker.isValidDate(reservationOrderWithDate);
       boolean isReservationOrderWithNullDate=checker.isValidDate(reservationOrderWithNullDate);

        assertTrue("Reservation Order is a valid Reservation Order", isReservationOrderWithUser);
        assertFalse("Reservation Order is invalid Reservation Order", isReservationOrderWithNullUser);

        assertTrue("Reservation Order is a valid Reservation Order", isReservationOrderWithDate);
        assertFalse("Reservation Order is invalid Reservation Order", isReservationOrderWithNullDate);
}
