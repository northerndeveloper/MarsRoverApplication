package enums;

public enum Direction {

    NORTH("North"),
    SOUTH("South"),
    WEST("West"),
    EAST("East");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }


}
