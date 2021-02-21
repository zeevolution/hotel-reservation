package model.room.enums;

/**
 * @author joseneto
 *
 */
public enum RoomType {
    SINGLE("1"),
    DOUBLE("2");

    public final String label;

    private RoomType(String label) {
        this.label = label;
    }

    public static RoomType valueOfLabel(String label) {
        for (RoomType roomType : values()) {
            if (roomType.label.equals(label)) {
                return roomType;
            }
        }
        throw new IllegalArgumentException();
    }
}
