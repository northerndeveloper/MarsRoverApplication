import enums.Direction;

public class MarsRoverApplication {

    public static final int North = 1;
    public static final int East = 2;
    public static final int South = 3;
    public static final int West = 4;

    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char FORWARD = 'F';
    private static final char BACKWARD = 'B';

    int xAxis, yAxis = 0;
    int currentMovingDirection = North;

    public MarsRoverApplication() {
    }

    public void setPosition(int x, int y, int currentMovingDirection) {

        this.xAxis = x;
        this.yAxis = y;
        this.currentMovingDirection = currentMovingDirection;
    }

    public void showDirection() {

        String direction = Direction.NORTH.getDirection();

        switch (currentMovingDirection) {

            case 1:
                direction = Direction.NORTH.getDirection();
                break;
            case 2:
                direction = Direction.EAST.getDirection();
                break;
            case 3:
                direction = Direction.SOUTH.getDirection();
                break;
            case 4:
                direction = Direction.WEST.getDirection();
                break;
            default:
                System.out.println("(" + xAxis + "," + yAxis + ") " + direction);
        }
        System.out.println("(" + xAxis + "," + yAxis + ") " + direction);
    }

    public void processCommands(String marsRoverCommands) {

        for (int command = 0; command < marsRoverCommands.length(); command++) {
            processSingleCommand(marsRoverCommands.charAt(command));
        }
    }

    public void processSingleCommand(Character marsRoverCommand) {

        switch (marsRoverCommand) {
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
            case FORWARD:
                moveForward();
                break;
            case BACKWARD:
                moveBackward();
                break;
            default:
                throw new IllegalArgumentException(
                        "Proper accepted commands are L R F and B");
        }
    }

    public void moveForward() {
        if (currentMovingDirection == North) {
            this.yAxis++;
        } else if (currentMovingDirection == East) {
            this.xAxis++;
        } else if (currentMovingDirection == South) {
            this.yAxis--;
        } else if (currentMovingDirection == West) {
            this.xAxis--;
        }
    }

    public void moveBackward() {
        if (currentMovingDirection == North) {
            this.yAxis--;
        } else if (currentMovingDirection == East) {
            this.xAxis--;
        } else if (currentMovingDirection == South) {
            this.yAxis++;
        } else if (currentMovingDirection == West) {
            this.xAxis++;
        }
    }

    public void turnLeft() {
        currentMovingDirection = (currentMovingDirection - 1) < North ? West : currentMovingDirection - 1;
    }

    public void turnRight() {
        currentMovingDirection = (currentMovingDirection + 1) > West ? North : currentMovingDirection + 1;
    }

    public static void main(String args[]) {
        MarsRoverApplication rover = new MarsRoverApplication();
        rover.setPosition(4, 2, East);
        rover.processCommands("FLFFFRFLB");
        rover.showDirection(); // prints (6,4) North
    }


}
