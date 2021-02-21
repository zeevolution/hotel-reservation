package model.room;

import model.room.enums.RoomType;

/**
 * @author joseneto
 *
 */
public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();
}
