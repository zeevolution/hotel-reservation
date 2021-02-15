package models.room;

import models.room.enums.RoomType;

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();
}
