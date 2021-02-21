package model.reservation;

import model.customer.Customer;
import model.room.IRoom;

import java.util.Date;

public class Reservation {

    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(final Customer customer, final IRoom room,
                       final Date checkInDate, final Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    @Override
    public String toString() {
        return "Customer: " + this.customer.toString()
                + "\nRoom: " + this.room.toString()
                + "\nCheckIn Date: " + this.checkInDate
                + "\nCheckOut Date: " + this.checkOutDate;
    }
}
