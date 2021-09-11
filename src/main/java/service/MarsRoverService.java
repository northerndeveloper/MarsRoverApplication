package service;

import contant.DirectionContants;
import entity.Axis;
import enums.Direction;
import lombok.Data;

@Data
public class MarsRoverService {

    public void showDirection(Axis axis) {

        String direction = Direction.NORTH.getDirection();

        switch (axis.getCurrentMovingDirection()) {

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
                System.out.println("(" + axis.getXAxis() + "," + axis.getYAxis() + ") " + direction); //TODO wrong
        }
        System.out.println("(" + axis.getXAxis() + "," + axis.getYAxis() + ") " + direction);
    }

    public void processCommands(String marsRoverCommands, Axis axis) {

        for (int command = 0; command < marsRoverCommands.length(); command++) {
            processSingleCommand(marsRoverCommands.charAt(command),axis);
        }
    }

    public void processSingleCommand(Character marsRoverCommand, Axis axis) {

        switch (marsRoverCommand) {
            case DirectionContants.LEFT:
                turnLeft(axis);
                break;
            case DirectionContants.RIGHT:
                turnRight(axis);
                break;
            case DirectionContants.FORWARD:
                moveForward(axis);
                break;
            case DirectionContants.BACKWARD:
                moveBackward(axis);
                break;
            default:
                throw new IllegalArgumentException(
                        "Proper accepted commands are L R F and B");
        }
    }

    public void moveForward(Axis axis) {
        if (axis.getCurrentMovingDirection() == DirectionContants.North) {
            axis.setYAxis(axis.getYAxis() + 1);
        } else if (axis.getCurrentMovingDirection() == DirectionContants.East) {
            axis.setXAxis(axis.getXAxis() + 1);
        } else if (axis.getCurrentMovingDirection() == DirectionContants.South) {
            axis.setYAxis(axis.getYAxis() - 1);
        } else if (axis.getCurrentMovingDirection() == DirectionContants.West) {
            axis.setXAxis(axis.getXAxis() - 1);
        }
    }

    public void moveBackward(Axis axis) {
        if (axis.getCurrentMovingDirection() == DirectionContants.North) {
            axis.setYAxis(axis.getYAxis() - 1);
        } else if (axis.getCurrentMovingDirection() == DirectionContants.East) {
            axis.setXAxis(axis.getXAxis() - 1);
        } else if (axis.getCurrentMovingDirection() == DirectionContants.South) {
            axis.setYAxis(axis.getYAxis() + 1);
        } else if (axis.getCurrentMovingDirection() == DirectionContants.West) {
            axis.setXAxis(axis.getXAxis() + 1);
        }
    }

    public void turnLeft(Axis axis) {
        axis.setCurrentMovingDirection((axis.getCurrentMovingDirection() - 1) < DirectionContants.North ? DirectionContants.West : axis.getCurrentMovingDirection() - 1);
    }

    public void turnRight(Axis axis) {
        axis.setCurrentMovingDirection((axis.getCurrentMovingDirection()  + 1) > DirectionContants.West ? DirectionContants.North : axis.getCurrentMovingDirection()  + 1);

    }

}
