package model.room;

import model.room.enums.RoomType;

import java.util.Objects;

/**
 * @author joseneto
 *
 */
public class Room implements IRoom {

    private final String roomNumber;
    private final Double price;
    private final RoomType enumeration;

    public Room(final String roomNumber, final Double price, final RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public Double getRoomPrice() {
        return this.price;
    }

    public RoomType getRoomType() {
        return this.enumeration;
    }

    public boolean isFree() {
        return this.price != null && this.price.equals(0.0);
    }

    @Override
    public String toString() {
        return "Room Number: " + this.roomNumber
                + " Price: $" + this.price
                + " Enumeration: " + this.enumeration;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof Room)) {
            return false;
        }

        final Room room = (Room) obj;
        return Objects.equals(this.roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
