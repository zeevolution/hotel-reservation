package models.room;

import models.room.enums.RoomType;

public class Room implements IRoom {

    private String roomNumber;
    private Double price;
    private RoomType enumeration;

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
        return true;
    }

    @Override
    public String toString() {
        return "Room Number:" + this.roomNumber
                + " Price:" + this.price
                + " Enumeration:" + this.enumeration;
    }
}
