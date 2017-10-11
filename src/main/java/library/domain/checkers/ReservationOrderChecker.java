package library.domain.checkers;

import library.domain.ReservationOrder;

/**
 * Created by Owner on 11/10/2017.
 */
public class ReservationOrderChecker {

    public boolean isValidUser(ReservationOrder reservationOrder) { return reservationOrder.getUser() != null;}
    public boolean isValidDate(ReservationOrder reservationOrder) {return reservationOrder.getDate() != null;}
}
