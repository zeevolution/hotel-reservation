package services.reservation;

import models.customer.Customer;
import models.reservation.Reservation;
import models.room.IRoom;

import java.util.*;

public class ReservationService {

    private static final ReservationService SINGLETON = new ReservationService();

    private final Map<String, IRoom> rooms = new HashMap<>();
    private final Map<String, Collection<Reservation>> reservations = new HashMap<>();

    private ReservationService() {}

    public void addRoom(final IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(final String roomNumber) {
        return rooms.get(roomNumber);
    }

    public Reservation reserveARoom(final Customer customer, final IRoom room,
                                    final Date checkInDate, final Date checkOutDate) {
        final Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        final Collection<Reservation> customersReservation = this.getCustomersReservation(customer);
        customersReservation.add(reservation);

        reservations.put(customer.getEmail(), customersReservation);

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return reservations.get(customer.getEmail());
    }

    public void printAllReservation() {

    }

    public ReservationService getSingleton() {
        return SINGLETON;
    }
}
